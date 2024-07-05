package org.jenjetsu.graduate_project.client.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PrecipitationRecordUpdateDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class PrecipitationRecordUpdateDto {

  private Long id;

  private BigDecimal minValue;

  private BigDecimal maxValue;

  private Integer value;

  public PrecipitationRecordUpdateDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PrecipitationRecordUpdateDto(Long id) {
    this.id = id;
  }

  public PrecipitationRecordUpdateDto id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @NotNull 
  @Schema(name = "id", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public PrecipitationRecordUpdateDto minValue(BigDecimal minValue) {
    this.minValue = minValue;
    return this;
  }

  /**
   * Минимальная граница горимости
   * @return minValue
  */
  @Valid 
  @Schema(name = "minValue", example = "0", description = "Минимальная граница горимости", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("minValue")
  public BigDecimal getMinValue() {
    return minValue;
  }

  public void setMinValue(BigDecimal minValue) {
    this.minValue = minValue;
  }

  public PrecipitationRecordUpdateDto maxValue(BigDecimal maxValue) {
    this.maxValue = maxValue;
    return this;
  }

  /**
   * Максимальная граница горимости
   * @return maxValue
  */
  @Valid 
  @Schema(name = "maxValue", example = "100000.0", description = "Максимальная граница горимости", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maxValue")
  public BigDecimal getMaxValue() {
    return maxValue;
  }

  public void setMaxValue(BigDecimal maxValue) {
    this.maxValue = maxValue;
  }

  public PrecipitationRecordUpdateDto value(Integer value) {
    this.value = value;
    return this;
  }

  /**
   * Значение осадков в мм
   * @return value
  */
  
  @Schema(name = "value", example = "3", description = "Значение осадков в мм", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("value")
  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PrecipitationRecordUpdateDto precipitationRecordUpdateDto = (PrecipitationRecordUpdateDto) o;
    return Objects.equals(this.id, precipitationRecordUpdateDto.id) &&
        Objects.equals(this.minValue, precipitationRecordUpdateDto.minValue) &&
        Objects.equals(this.maxValue, precipitationRecordUpdateDto.maxValue) &&
        Objects.equals(this.value, precipitationRecordUpdateDto.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, minValue, maxValue, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PrecipitationRecordUpdateDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    minValue: ").append(toIndentedString(minValue)).append("\n");
    sb.append("    maxValue: ").append(toIndentedString(maxValue)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

