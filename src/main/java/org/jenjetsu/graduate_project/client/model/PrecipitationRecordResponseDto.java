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
 * PrecipitationRecordResponseDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class PrecipitationRecordResponseDto {

  private Long id;

  private BigDecimal minValue;

  private BigDecimal maxValue;

  private Integer value;

  private String ffwiName;

  private UUID ffwId;

  public PrecipitationRecordResponseDto id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", example = "1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public PrecipitationRecordResponseDto minValue(BigDecimal minValue) {
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

  public PrecipitationRecordResponseDto maxValue(BigDecimal maxValue) {
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

  public PrecipitationRecordResponseDto value(Integer value) {
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

  public PrecipitationRecordResponseDto ffwiName(String ffwiName) {
    this.ffwiName = ffwiName;
    return this;
  }

  /**
   * Название КППО
   * @return ffwiName
  */
  
  @Schema(name = "ffwiName", example = "КППО_Нестерова", description = "Название КППО", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ffwiName")
  public String getFfwiName() {
    return ffwiName;
  }

  public void setFfwiName(String ffwiName) {
    this.ffwiName = ffwiName;
  }

  public PrecipitationRecordResponseDto ffwId(UUID ffwId) {
    this.ffwId = ffwId;
    return this;
  }

  /**
   * ID КППО
   * @return ffwId
  */
  @Valid 
  @Schema(name = "ffwId", example = "97b4e98f-6829-446a-aea7-8e7be17d56c9", description = "ID КППО", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ffwId")
  public UUID getFfwId() {
    return ffwId;
  }

  public void setFfwId(UUID ffwId) {
    this.ffwId = ffwId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PrecipitationRecordResponseDto precipitationRecordResponseDto = (PrecipitationRecordResponseDto) o;
    return Objects.equals(this.id, precipitationRecordResponseDto.id) &&
        Objects.equals(this.minValue, precipitationRecordResponseDto.minValue) &&
        Objects.equals(this.maxValue, precipitationRecordResponseDto.maxValue) &&
        Objects.equals(this.value, precipitationRecordResponseDto.value) &&
        Objects.equals(this.ffwiName, precipitationRecordResponseDto.ffwiName) &&
        Objects.equals(this.ffwId, precipitationRecordResponseDto.ffwId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, minValue, maxValue, value, ffwiName, ffwId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PrecipitationRecordResponseDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    minValue: ").append(toIndentedString(minValue)).append("\n");
    sb.append("    maxValue: ").append(toIndentedString(maxValue)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    ffwiName: ").append(toIndentedString(ffwiName)).append("\n");
    sb.append("    ffwId: ").append(toIndentedString(ffwId)).append("\n");
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

