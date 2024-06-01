package org.jenjetsu.graduate_project.service;

import java.util.List;

import org.jenjetsu.graduate_project.entity.formula.*;

public interface FormulaParserService {
    
    public FormulaTreeNode parse(List<FormulaLexem> lexems);
}
