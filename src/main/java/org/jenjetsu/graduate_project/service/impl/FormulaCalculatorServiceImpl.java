package org.jenjetsu.graduate_project.service.impl;

import java.math.*;
import java.util.Map;

import org.jenjetsu.graduate_project.entity.formula.*;
import org.jenjetsu.graduate_project.service.*;
import org.springframework.stereotype.Component;

@Component
public class FormulaCalculatorServiceImpl implements FormulaCalculatorService {

    @Override
    public BigDecimal calculate(FormulaTreeNode head, Map<String, Object> variableValueMap) {
        return switch(head.getToken()) {
            case NUMBER -> new BigDecimal(head.getData());
            case VARIABLE -> this.calculateVariable(head.getData(), variableValueMap);
            default -> {
                var left = this.calculate(head.getLeft(), variableValueMap);
                var right = this.calculate(head.getRight(), variableValueMap);
                yield this.calculateOperation(head.getToken(), left, right);
            }
        };
    }

    private BigDecimal calculateVariable(String variableName, Map<String, Object> variableValueMap) {
        if (variableValueMap.containsKey(variableName)) {
            var result = new BigDecimal(variableValueMap.get(variableName).toString());

            return result;
        }
        throw new RuntimeException("asdad");
    }

    private BigDecimal calculateOperation(FormulaToken operator, BigDecimal left, BigDecimal right) {
        return switch(operator) {
            case ADDITION -> left.add(right);
            case SUBSTRACTION -> left.subtract(right);
            case MULTIPLICATION -> left.multiply(right);
            case DIVISION -> left.divide(right, 5, RoundingMode.HALF_UP);
            default -> throw new RuntimeException("");
        };
    }
    
}
