package org.jenjetsu.graduate_project.entity.formula;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = FormulaStringValidator.class)
@Target(FIELD)
@Retention(RUNTIME)
public @interface ValidFormula {
    
    String message() default "Формула некорректна";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
