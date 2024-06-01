package org.jenjetsu.graduate_project.service.impl;

import java.util.Map;

import org.jenjetsu.graduate_project.entity.formula.*;
import org.jenjetsu.graduate_project.service.*;
import org.springframework.stereotype.Component;

@Component
public class FormulaCalculatorServiceImpl implements FormulaCalculatorService {

    @Override
    public double calculate(FormulaTreeNode head, Map<String, Object> variableValueMap) {
        return switch(head.getToken()) {
            case NUMBER -> Double.parseDouble(head.getData());
            case VARIABLE -> this.calculateVariable(head.getData(), variableValueMap);
            default -> {
                var left = this.calculate(head.getLeft(), variableValueMap);
                var right = this.calculate(head.getRight(), variableValueMap);
                yield this.calculateOperation(head.getToken(), left, right);
            }
        };
    }

    private double calculateVariable(String variableName, Map<String, Object> variableValueMap) {
        if (variableValueMap.containsKey(variableName)) {
            return Double.parseDouble(variableValueMap.get(variableName).toString());
        }
        throw new RuntimeException("asdad");
    }

    private double calculateOperation(FormulaToken operator, double left, double right) {
        return switch(operator) {
            case ADDITION -> left + right;
            case SUBSTRACTION -> left - right;
            case MULTIPLICATION -> left * right;
            case DIVISION -> left / right;
            default -> throw new RuntimeException("");
        };
    }
    
}
