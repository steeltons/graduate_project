package org.jenjetsu.graduate_project.service;

import java.math.*;
import java.util.Map;

import org.jenjetsu.graduate_project.entity.formula.*;

public interface FormulaCalculatorService {
    
    public BigDecimal calculate(FormulaTreeNode head, Map<String, Object> variableValueMap);
}
