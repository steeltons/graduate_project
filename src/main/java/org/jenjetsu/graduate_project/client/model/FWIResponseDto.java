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
 * DTO представление КПО в приложении
 */

@Schema(name = "FWIResponseDto", description = "DTO представление КПО в приложении")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class FWIResponseDto {

  private UUID id;

  private String name;

  private BigDecimal minValue;

  private BigDecimal maxValue;

  private String fireDangerName;

  private String ffwiName;

  public FWIResponseDto id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @Valid 
  @Schema(name = "id", example = "12efb6fa-72b7-455e-87c2-872d24d1f22d", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public FWIResponseDto name(String name) {
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

  public FWIResponseDto minValue(BigDecimal minValue) {
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

  public FWIResponseDto maxValue(BigDecimal maxValue) {
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

  public FWIResponseDto fireDangerName(String fireDangerName) {
    this.fireDangerName = fireDangerName;
    return this;
  }

  /**
   * Имя уровня пожарной угрозы
   * @return fireDangerName
  */
  
  @Schema(name = "fireDangerName", example = "Незначительный", description = "Имя уровня пожарной угрозы", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fireDangerName")
  public String getFireDangerName() {
    return fireDangerName;
  }

  public void setFireDangerName(String fireDangerName) {
    this.fireDangerName = fireDangerName;
  }

  public FWIResponseDto ffwiName(String ffwiName) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FWIResponseDto fwIResponseDto = (FWIResponseDto) o;
    return Objects.equals(this.id, fwIResponseDto.id) &&
        Objects.equals(this.name, fwIResponseDto.name) &&
        Objects.equals(this.minValue, fwIResponseDto.minValue) &&
        Objects.equals(this.maxValue, fwIResponseDto.maxValue) &&
        Objects.equals(this.fireDangerName, fwIResponseDto.fireDangerName) &&
        Objects.equals(this.ffwiName, fwIResponseDto.ffwiName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, minValue, maxValue, fireDangerName, ffwiName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FWIResponseDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    minValue: ").append(toIndentedString(minValue)).append("\n");
    sb.append("    maxValue: ").append(toIndentedString(maxValue)).append("\n");
    sb.append("    fireDangerName: ").append(toIndentedString(fireDangerName)).append("\n");
    sb.append("    ffwiName: ").append(toIndentedString(ffwiName)).append("\n");
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

