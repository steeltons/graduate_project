package org.jenjetsu.graduate_project.service.impl;

import java.util.*;

import org.jenjetsu.graduate_project.entity.formula.*;
import org.jenjetsu.graduate_project.service.*;
import org.springframework.stereotype.Component;

import static org.jenjetsu.graduate_project.entity.formula.FormulaToken.*;

@Component
public class FormulaParserServiceImpl implements FormulaParserService {

    @Override
    public FormulaTreeNode parse(List<FormulaLexem> lexems) {
        LinkedList<FormulaLexem> queue = new LinkedList<>(lexems);
        return this.parseExpression(queue);
    }

    private FormulaTreeNode parseExpression(LinkedList<FormulaLexem> queue) {
        var left = this.parseTerm(queue);
        while (!queue.isEmpty() &&
               (
                queue.peekFirst().getToken().equals(ADDITION) ||
                queue.peekFirst().getToken().equals(SUBSTRACTION)
               )) {
            var operator = queue.peekFirst().getToken();
            var data = queue.peekFirst().getText();
            queue.pollFirst();
            var right = this.parseTerm(queue);
            left = new FormulaTreeNode(data, operator, left, right);
        }
        return left;
    }

    private FormulaTreeNode parseTerm(LinkedList<FormulaLexem> queue) {
        var left = this.parseUnar(queue);
        while (!queue.isEmpty() &&
               (
                queue.peekFirst().getToken().equals(MULTIPLICATION) ||
                queue.peekFirst().getToken().equals(DIVISION)
               )) {
            var operator = queue.peekFirst().getToken();
            var data = queue.peekFirst().getText();
            queue.pollFirst();
            var right = this.parseUnar(queue);
            left = new FormulaTreeNode(data, operator, left, right);
        }
        return left;
    }

    private FormulaTreeNode parseUnar(LinkedList<FormulaLexem> queue) {
        if (queue.peekFirst().getToken().equals(SUBSTRACTION)) {
            queue.pollFirst();
            var right = this.parseFactor(queue);
            if (right.getToken().equals(NUMBER)) {
                right.setData("-" + right.getData());
            } else {
                var left = new FormulaTreeNode("0", NUMBER);
                right = new FormulaTreeNode("-", SUBSTRACTION, left, right);
            }
            return right;
        } else {
            if (queue.peekFirst().getToken().equals(ADDITION)) {
                queue.pollFirst();
            }
            return this.parseFactor(queue);
        }
    }

    private FormulaTreeNode parseFactor(LinkedList<FormulaLexem> queue) {
        return switch(queue.peek().getToken()) {
            case PAREN -> {
                queue.pollFirst();
                var node = this.parseExpression(queue);
                if (!queue.peek().getToken().equals(PAREN)) {
                    throw new RuntimeException("AAAA");
                }
                queue.pollFirst();
                yield node;
            }
            case VARIABLE, NUMBER -> {
                var token = queue.peekFirst().getToken();
                var data = queue.peekFirst().getText();
                queue.pollFirst();
                yield new FormulaTreeNode(data, token);
            }
            default -> throw new RuntimeException("");
        };
    }
    
}
