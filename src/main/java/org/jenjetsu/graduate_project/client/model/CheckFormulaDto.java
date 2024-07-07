package org.jenjetsu.graduate_project.client.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CheckFormulaDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class CheckFormulaDto {

  private String formula;

  public CheckFormulaDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CheckFormulaDto(String formula) {
    this.formula = formula;
  }

  public CheckFormulaDto formula(String formula) {
    this.formula = formula;
    return this;
  }

  /**
   * Сырая формула
   * @return formula
  */
  @NotNull 
  @Schema(name = "formula", example = "$T_0 + $T_d", description = "Сырая формула", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("formula")
  public String getFormula() {
    return formula;
  }

  public void setFormula(String formula) {
    this.formula = formula;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckFormulaDto checkFormulaDto = (CheckFormulaDto) o;
    return Objects.equals(this.formula, checkFormulaDto.formula);
  }

  @Override
  public int hashCode() {
    return Objects.hash(formula);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckFormulaDto {\n");
    sb.append("    formula: ").append(toIndentedString(formula)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

