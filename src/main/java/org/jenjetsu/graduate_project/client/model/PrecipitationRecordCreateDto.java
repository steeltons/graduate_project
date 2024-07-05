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
 * PrecipitationRecordCreateDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class PrecipitationRecordCreateDto {

  private BigDecimal minValue;

  private BigDecimal maxValue;

  private Integer value;

  private UUID ffwiId;

  public PrecipitationRecordCreateDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PrecipitationRecordCreateDto(BigDecimal minValue, BigDecimal maxValue, Integer value, UUID ffwiId) {
    this.minValue = minValue;
    this.maxValue = maxValue;
    this.value = value;
    this.ffwiId = ffwiId;
  }

  public PrecipitationRecordCreateDto minValue(BigDecimal minValue) {
    this.minValue = minValue;
    return this;
  }

  /**
   * Минимальная граница горимости
   * @return minValue
  */
  @NotNull @Valid 
  @Schema(name = "minValue", example = "0", description = "Минимальная граница горимости", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("minValue")
  public BigDecimal getMinValue() {
    return minValue;
  }

  public void setMinValue(BigDecimal minValue) {
    this.minValue = minValue;
  }

  public PrecipitationRecordCreateDto maxValue(BigDecimal maxValue) {
    this.maxValue = maxValue;
    return this;
  }

  /**
   * Максимальная граница горимости
   * @return maxValue
  */
  @NotNull @Valid 
  @Schema(name = "maxValue", example = "100000.0", description = "Максимальная граница горимости", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("maxValue")
  public BigDecimal getMaxValue() {
    return maxValue;
  }

  public void setMaxValue(BigDecimal maxValue) {
    this.maxValue = maxValue;
  }

  public PrecipitationRecordCreateDto value(Integer value) {
    this.value = value;
    return this;
  }

  /**
   * Значение осадков в мм
   * @return value
  */
  @NotNull 
  @Schema(name = "value", example = "3", description = "Значение осадков в мм", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("value")
  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public PrecipitationRecordCreateDto ffwiId(UUID ffwiId) {
    this.ffwiId = ffwiId;
    return this;
  }

  /**
   * ID КППО
   * @return ffwiId
  */
  @NotNull @Valid 
  @Schema(name = "ffwi_id", example = "97b4e98f-6829-446a-aea7-8e7be17d56c9", description = "ID КППО", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("ffwi_id")
  public UUID getFfwiId() {
    return ffwiId;
  }

  public void setFfwiId(UUID ffwiId) {
    this.ffwiId = ffwiId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PrecipitationRecordCreateDto precipitationRecordCreateDto = (PrecipitationRecordCreateDto) o;
    return Objects.equals(this.minValue, precipitationRecordCreateDto.minValue) &&
        Objects.equals(this.maxValue, precipitationRecordCreateDto.maxValue) &&
        Objects.equals(this.value, precipitationRecordCreateDto.value) &&
        Objects.equals(this.ffwiId, precipitationRecordCreateDto.ffwiId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(minValue, maxValue, value, ffwiId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PrecipitationRecordCreateDto {\n");
    sb.append("    minValue: ").append(toIndentedString(minValue)).append("\n");
    sb.append("    maxValue: ").append(toIndentedString(maxValue)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    ffwiId: ").append(toIndentedString(ffwiId)).append("\n");
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

