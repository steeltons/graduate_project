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
 * FWICreateDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class FWICreateDto {

  private String name;

  private BigDecimal minValue;

  private BigDecimal maxValue;

  private Long fireDangerId;

  private UUID ffwiId;

  public FWICreateDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FWICreateDto(String name, BigDecimal minValue, BigDecimal maxValue, UUID ffwiId) {
    this.name = name;
    this.minValue = minValue;
    this.maxValue = maxValue;
    this.ffwiId = ffwiId;
  }

  public FWICreateDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", example = "КПО_Нестерова_1", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FWICreateDto minValue(BigDecimal minValue) {
    this.minValue = minValue;
    return this;
  }

  /**
   * нижняя граница горммости
   * minimum: 0
   * @return minValue
  */
  @NotNull @Valid @DecimalMin("0") 
  @Schema(name = "minValue", example = "0", description = "нижняя граница горммости", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("minValue")
  public BigDecimal getMinValue() {
    return minValue;
  }

  public void setMinValue(BigDecimal minValue) {
    this.minValue = minValue;
  }

  public FWICreateDto maxValue(BigDecimal maxValue) {
    this.maxValue = maxValue;
    return this;
  }

  /**
   * верхняя граница горимости
   * minimum: 0
   * @return maxValue
  */
  @NotNull @Valid @DecimalMin("0") 
  @Schema(name = "maxValue", example = "1000", description = "верхняя граница горимости", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("maxValue")
  public BigDecimal getMaxValue() {
    return maxValue;
  }

  public void setMaxValue(BigDecimal maxValue) {
    this.maxValue = maxValue;
  }

  public FWICreateDto fireDangerId(Long fireDangerId) {
    this.fireDangerId = fireDangerId;
    return this;
  }

  /**
   * Id пожарной угрозы
   * @return fireDangerId
  */
  
  @Schema(name = "fireDangerId", example = "1", description = "Id пожарной угрозы", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fireDangerId")
  public Long getFireDangerId() {
    return fireDangerId;
  }

  public void setFireDangerId(Long fireDangerId) {
    this.fireDangerId = fireDangerId;
  }

  public FWICreateDto ffwiId(UUID ffwiId) {
    this.ffwiId = ffwiId;
    return this;
  }

  /**
   * ID КППО
   * @return ffwiId
  */
  @NotNull @Valid 
  @Schema(name = "ffwiId", description = "ID КППО", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("ffwiId")
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
    FWICreateDto fwICreateDto = (FWICreateDto) o;
    return Objects.equals(this.name, fwICreateDto.name) &&
        Objects.equals(this.minValue, fwICreateDto.minValue) &&
        Objects.equals(this.maxValue, fwICreateDto.maxValue) &&
        Objects.equals(this.fireDangerId, fwICreateDto.fireDangerId) &&
        Objects.equals(this.ffwiId, fwICreateDto.ffwiId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, minValue, maxValue, fireDangerId, ffwiId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FWICreateDto {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    minValue: ").append(toIndentedString(minValue)).append("\n");
    sb.append("    maxValue: ").append(toIndentedString(maxValue)).append("\n");
    sb.append("    fireDangerId: ").append(toIndentedString(fireDangerId)).append("\n");
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

