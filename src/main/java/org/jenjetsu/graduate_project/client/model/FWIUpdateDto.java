package org.jenjetsu.graduate_project.client.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import java.util.UUID;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * FWIUpdateDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class FWIUpdateDto {

  private UUID id;

  private String name;

  private BigDecimal minValue;

  private BigDecimal maxValue;

  public FWIUpdateDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FWIUpdateDto(UUID id) {
    this.id = id;
  }

  public FWIUpdateDto id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @NotNull @Valid 
  @Schema(name = "id", example = "12efb6fa-72b7-455e-87c2-872d24d1f22d", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public FWIUpdateDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", example = "КПО_Нестерова_1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FWIUpdateDto minValue(BigDecimal minValue) {
    this.minValue = minValue;
    return this;
  }

  /**
   * нижняя граница горммости
   * minimum: 0
   * @return minValue
  */
  @Valid @DecimalMin("0") 
  @Schema(name = "minValue", example = "0", description = "нижняя граница горммости", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("minValue")
  public BigDecimal getMinValue() {
    return minValue;
  }

  public void setMinValue(BigDecimal minValue) {
    this.minValue = minValue;
  }

  public FWIUpdateDto maxValue(BigDecimal maxValue) {
    this.maxValue = maxValue;
    return this;
  }

  /**
   * верхняя граница горимости
   * minimum: 0
   * @return maxValue
  */
  @Valid @DecimalMin("0") 
  @Schema(name = "maxValue", example = "1000", description = "верхняя граница горимости", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maxValue")
  public BigDecimal getMaxValue() {
    return maxValue;
  }

  public void setMaxValue(BigDecimal maxValue) {
    this.maxValue = maxValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FWIUpdateDto fwIUpdateDto = (FWIUpdateDto) o;
    return Objects.equals(this.id, fwIUpdateDto.id) &&
        Objects.equals(this.name, fwIUpdateDto.name) &&
        Objects.equals(this.minValue, fwIUpdateDto.minValue) &&
        Objects.equals(this.maxValue, fwIUpdateDto.maxValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, minValue, maxValue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FWIUpdateDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    minValue: ").append(toIndentedString(minValue)).append("\n");
    sb.append("    maxValue: ").append(toIndentedString(maxValue)).append("\n");
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

