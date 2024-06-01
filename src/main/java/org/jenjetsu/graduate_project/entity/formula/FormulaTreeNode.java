package org.jenjetsu.graduate_project.entity.formula;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormulaTreeNode implements Cloneable {

    private String data;

    private FormulaToken token;

    private FormulaTreeNode left;

    private FormulaTreeNode right;

    public FormulaTreeNode(String data, FormulaToken token) {
        this.data = data;
        this.token = token;
    }

}
