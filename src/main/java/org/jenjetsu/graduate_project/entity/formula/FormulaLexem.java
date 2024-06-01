package org.jenjetsu.graduate_project.entity.formula;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FormulaLexem {

    private String text;

    private int startIndex;

    private FormulaToken token;

    @Override
    public String toString() {
        return String.format("<%s, %s, %d>", this.token.name(), this.text, this.startIndex);
    }

}
