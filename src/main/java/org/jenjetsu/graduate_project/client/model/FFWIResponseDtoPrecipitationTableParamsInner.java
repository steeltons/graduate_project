package org.jenjetsu.graduate_project.client.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
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

  private String fireRange;

  private Integer precipitation;

  public FFWIResponseDtoPrecipitationTableParamsInner fireRange(String fireRange) {
    this.fireRange = fireRange;
    return this;
  }

  /**
   * Диапазон горимости
   * @return fireRange
  */
  
  @Schema(name = "fireRange", example = "[0,\"∞\"]", description = "Диапазон горимости", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fireRange")
  public String getFireRange() {
    return fireRange;
  }

  public void setFireRange(String fireRange) {
    this.fireRange = fireRange;
  }

  public FFWIResponseDtoPrecipitationTableParamsInner precipitation(Integer precipitation) {
    this.precipitation = precipitation;
    return this;
  }

  /**
   * Кол-во осадков для сброса
   * @return precipitation
  */
  
  @Schema(name = "precipitation", example = "3", description = "Кол-во осадков для сброса", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("precipitation")
  public Integer getPrecipitation() {
    return precipitation;
  }

  public void setPrecipitation(Integer precipitation) {
    this.precipitation = precipitation;
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
    return Objects.equals(this.fireRange, ffWIResponseDtoPrecipitationTableParamsInner.fireRange) &&
        Objects.equals(this.precipitation, ffWIResponseDtoPrecipitationTableParamsInner.precipitation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fireRange, precipitation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FFWIResponseDtoPrecipitationTableParamsInner {\n");
    sb.append("    fireRange: ").append(toIndentedString(fireRange)).append("\n");
    sb.append("    precipitation: ").append(toIndentedString(precipitation)).append("\n");
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

