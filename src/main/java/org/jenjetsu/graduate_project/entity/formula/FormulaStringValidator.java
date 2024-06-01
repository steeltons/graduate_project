package org.jenjetsu.graduate_project.entity.formula;

import org.jenjetsu.graduate_project.exception.*;
import org.jenjetsu.graduate_project.service.*;
import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FormulaStringValidator implements ConstraintValidator<ValidFormula, String> {

    private final FormulaLexerService lexerService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isValid = true;
        try {
            this.lexerService.parseFormula(value);
        } catch (LexerException e) {
            isValid = false;
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addConstraintViolation();
        }
        return isValid;
    }
    
}
