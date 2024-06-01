package org.jenjetsu.graduate_project.service.impl;

import static java.lang.String.format;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

import org.jenjetsu.graduate_project.entity.formula.*;
import org.jenjetsu.graduate_project.exception.*;
import org.jenjetsu.graduate_project.service.*;
import org.springframework.stereotype.Component;

import static org.jenjetsu.graduate_project.entity.formula.FormulaToken.*;

@Component
public class FormulaLexerServiceImpl implements FormulaLexerService {

    private final char endOfTextSymbol = (char) 3;
    private final Set<Character> operators = Set.of(new Character[]{'+','-','*','/','^','!'});
    private final Pattern variablePattern = Pattern.compile("[a-zA-Z_\\x7f-\\xff][a-zA-Z0-9_\\x7f-\\xff]*");
    private final Pattern numberPattern = Pattern.compile("[+-]?([0-9]*[.])?[0-9]+");
     
    public List<FormulaLexem> parseFormula(String text) {
        List<FormulaLexem> lexems = new ArrayList<>();
        AtomicInteger index = new AtomicInteger(0);
        while (index.get() < text.length()) {
            if (text.charAt(index.get()) == '$') {
                index.incrementAndGet();
                lexems.add(this.parseVariable(text, index));
            } else if (Character.isDigit(text.charAt(index.get()))) {
                lexems.add(this.parseNumber(text, index));
            } else if (this.operators.contains(text.charAt(index.get()))) {
                lexems.add(this.parseOperator(text, index));
            } else if (text.charAt(index.get()) == '(' || text.charAt(index.get()) == ')') {
                lexems.add(this.parseParen(text, index));
            } else {
                index.incrementAndGet();
            }
        }
        return lexems;
    }

    private void throwException(String message, int pos) {
        throw new LexerException(format("Lexer throw exception on char position %d. Error message %s",
                                         pos, message
                                        ));
    }

    private char nextChar(String text, AtomicInteger index) {
        return index.get() < text.length() 
               ? text.charAt(index.getAndIncrement()) 
               : this.endOfTextSymbol;
    }

    private FormulaLexem parseVariable(String text, AtomicInteger index) {
        var lexem = new FormulaLexem();
        lexem.setStartIndex(index.get());
        lexem.setToken(VARIABLE);
        var builder = new StringBuilder();
        var currentChar = text.charAt(index.get()); 
        while (currentChar != this.endOfTextSymbol &&
               currentChar != '\s' && 
               currentChar != '(' && currentChar != ')' &&
               !this.operators.contains(currentChar)) {
            builder.append(currentChar);
            currentChar = index.get() < text.length() - 1 ? text.charAt(index.incrementAndGet()) : this.endOfTextSymbol;
        }
        if (!this.variablePattern.matcher(builder.toString()).matches()) {
            this.throwException("Not valid variable", lexem.getStartIndex());
        }
        lexem.setText(builder.toString());
        return lexem;
    }

    private FormulaLexem parseNumber(String text, AtomicInteger index) {
        var lexem = new FormulaLexem();
        lexem.setStartIndex(index.get());
        lexem.setToken(NUMBER);
        var builder = new StringBuilder();
        var currentChar = this.nextChar(text, index);
        while (currentChar != this.endOfTextSymbol && 
               (currentChar == '.' || Character.isDigit(currentChar))) {
            builder.append(currentChar);
            currentChar = this.nextChar(text, index);
        }
        if (!this.numberPattern.matcher(builder.toString()).matches()) {
            this.throwException("Number is not valid", lexem.getStartIndex());
        }
        lexem.setText(builder.toString());
        return lexem;
    }

    private FormulaLexem parseParen(String text, AtomicInteger index) {
        var lexem = new FormulaLexem();
        lexem.setStartIndex(index.get());
        lexem.setText(Character.toString(this.nextChar(text, index)).intern());
        lexem.setToken(PAREN);
        return lexem;
    }

    private FormulaLexem parseOperator(String text, AtomicInteger index) {
        var lexem = new FormulaLexem();
        lexem.setStartIndex(index.get());
        char currentChar = this.nextChar(text, index);
        var token = switch(currentChar) {
            case '+' -> ADDITION;
            case '-' -> SUBSTRACTION;
            case '*' -> MULTIPLICATION;
            case '/', ':' -> DIVISION;
            case '^' -> DEGREE;
            default -> {
                this.throwException(format("Operator %c not supported", currentChar), index.get());
                yield null; // Not reachable
            }
        };
        lexem.setToken(token);
        lexem.setText(Character.toString(currentChar).intern());
        return lexem;
    }

}
