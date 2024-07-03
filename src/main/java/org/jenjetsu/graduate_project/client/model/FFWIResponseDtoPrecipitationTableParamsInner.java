package org.jenjetsu.graduate_project.client.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * FFWIResponseDtoPrecipitationTableParamsInner
 */

@JsonTypeName("FFWIResponseDto_precipitationTableParams_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class FFWIResponseDtoPrecipitationTableParamsInner {

  private BigDecimal minValue;

  private BigDecimal maxValue;

  private Integer value;

  public FFWIResponseDtoPrecipitationTableParamsInner minValue(BigDecimal minValue) {
    this.minValue = minValue;
    return this;
  }

  /**
   * Нижняя граница горимости
   * @return minValue
  */
  @Valid 
  @Schema(name = "minValue", example = "0", description = "Нижняя граница горимости", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("minValue")
  public BigDecimal getMinValue() {
    return minValue;
  }

  public void setMinValue(BigDecimal minValue) {
    this.minValue = minValue;
  }

  public FFWIResponseDtoPrecipitationTableParamsInner maxValue(BigDecimal maxValue) {
    this.maxValue = maxValue;
    return this;
  }

  /**
   * Верхняя граница горимости
   * @return maxValue
  */
  @Valid 
  @Schema(name = "maxValue", description = "Верхняя граница горимости", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maxValue")
  public BigDecimal getMaxValue() {
    return maxValue;
  }

  public void setMaxValue(BigDecimal maxValue) {
    this.maxValue = maxValue;
  }

  public FFWIResponseDtoPrecipitationTableParamsInner value(Integer value) {
    this.value = value;
    return this;
  }

  /**
   * Кол-во осадков для сброса
   * @return value
  */
  
  @Schema(name = "value", example = "3", description = "Кол-во осадков для сброса", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    FFWIResponseDtoPrecipitationTableParamsInner ffWIResponseDtoPrecipitationTableParamsInner = (FFWIResponseDtoPrecipitationTableParamsInner) o;
    return Objects.equals(this.minValue, ffWIResponseDtoPrecipitationTableParamsInner.minValue) &&
        Objects.equals(this.maxValue, ffWIResponseDtoPrecipitationTableParamsInner.maxValue) &&
        Objects.equals(this.value, ffWIResponseDtoPrecipitationTableParamsInner.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(minValue, maxValue, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FFWIResponseDtoPrecipitationTableParamsInner {\n");
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

