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
 * FFWICreateDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class FFWICreateDto {

  private String name;

  private BigDecimal minValue;

  private BigDecimal maxValue;

  private UUID fireDangerId;

  private UUID ffwiId;

  public FFWICreateDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FFWICreateDto(String name, BigDecimal minValue, BigDecimal maxValue, UUID ffwiId) {
    this.name = name;
    this.minValue = minValue;
    this.maxValue = maxValue;
    this.ffwiId = ffwiId;
  }

  public FFWICreateDto name(String name) {
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

  public FFWICreateDto minValue(BigDecimal minValue) {
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

  public FFWICreateDto maxValue(BigDecimal maxValue) {
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

  public FFWICreateDto fireDangerId(UUID fireDangerId) {
    this.fireDangerId = fireDangerId;
    return this;
  }

  /**
   * Id пожарной угрозы
   * @return fireDangerId
  */
  @Valid 
  @Schema(name = "fireDangerId", description = "Id пожарной угрозы", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fireDangerId")
  public UUID getFireDangerId() {
    return fireDangerId;
  }

  public void setFireDangerId(UUID fireDangerId) {
    this.fireDangerId = fireDangerId;
  }

  public FFWICreateDto ffwiId(UUID ffwiId) {
    this.ffwiId = ffwiId;
    return this;
  }

  /**
   * ID КППО
   * @return ffwiId
  */
  @NotNull @Valid 
  @Schema(name = "ffwiId", example = "9d21406b-9673-408d-98dc-afb8f49683b3", description = "ID КППО", requiredMode = Schema.RequiredMode.REQUIRED)
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
    FFWICreateDto ffWICreateDto = (FFWICreateDto) o;
    return Objects.equals(this.name, ffWICreateDto.name) &&
        Objects.equals(this.minValue, ffWICreateDto.minValue) &&
        Objects.equals(this.maxValue, ffWICreateDto.maxValue) &&
        Objects.equals(this.fireDangerId, ffWICreateDto.fireDangerId) &&
        Objects.equals(this.ffwiId, ffWICreateDto.ffwiId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, minValue, maxValue, fireDangerId, ffwiId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FFWICreateDto {\n");
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

