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
 * WeatherValueDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class WeatherValueDto {

  private UUID weatherDataId;

  private BigDecimal value;

  public WeatherValueDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public WeatherValueDto(UUID weatherDataId, BigDecimal value) {
    this.weatherDataId = weatherDataId;
    this.value = value;
  }

  public WeatherValueDto weatherDataId(UUID weatherDataId) {
    this.weatherDataId = weatherDataId;
    return this;
  }

  /**
   * ID погодного параметра
   * @return weatherDataId
  */
  @NotNull @Valid 
  @Schema(name = "weatherDataId", description = "ID погодного параметра", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("weatherDataId")
  public UUID getWeatherDataId() {
    return weatherDataId;
  }

  public void setWeatherDataId(UUID weatherDataId) {
    this.weatherDataId = weatherDataId;
  }

  public WeatherValueDto value(BigDecimal value) {
    this.value = value;
    return this;
  }

  /**
   * Текущее значение параметра
   * @return value
  */
  @NotNull @Valid 
  @Schema(name = "value", example = "16.8", description = "Текущее значение параметра", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("value")
  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
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
    WeatherValueDto weatherValueDto = (WeatherValueDto) o;
    return Objects.equals(this.weatherDataId, weatherValueDto.weatherDataId) &&
        Objects.equals(this.value, weatherValueDto.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(weatherDataId, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WeatherValueDto {\n");
    sb.append("    weatherDataId: ").append(toIndentedString(weatherDataId)).append("\n");
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

