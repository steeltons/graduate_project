package org.jenjetsu.graduate_project.client.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.jenjetsu.graduate_project.client.model.WeatherValueDto;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ForecastDataCalculateDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class ForecastDataCalculateDto {

  private UUID ffwiId;

  private BigDecimal previousComplexIndicator;

  @Valid
  private List<@Valid WeatherValueDto> weatherDataParams = new ArrayList<>();

  public ForecastDataCalculateDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ForecastDataCalculateDto(UUID ffwiId, BigDecimal previousComplexIndicator, List<@Valid WeatherValueDto> weatherDataParams) {
    this.ffwiId = ffwiId;
    this.previousComplexIndicator = previousComplexIndicator;
    this.weatherDataParams = weatherDataParams;
  }

  public ForecastDataCalculateDto ffwiId(UUID ffwiId) {
    this.ffwiId = ffwiId;
    return this;
  }

  /**
   * ID комплексного показателя
   * @return ffwiId
  */
  @NotNull @Valid 
  @Schema(name = "ffwiId", example = "7575fa5e-252f-46dc-9684-8414e2c93a1b", description = "ID комплексного показателя", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("ffwiId")
  public UUID getFfwiId() {
    return ffwiId;
  }

  public void setFfwiId(UUID ffwiId) {
    this.ffwiId = ffwiId;
  }

  public ForecastDataCalculateDto previousComplexIndicator(BigDecimal previousComplexIndicator) {
    this.previousComplexIndicator = previousComplexIndicator;
    return this;
  }

  /**
   * Предыдущее значение КП для конкретного КППО
   * @return previousComplexIndicator
  */
  @NotNull @Valid 
  @Schema(name = "previousComplexIndicator", example = "500.0", description = "Предыдущее значение КП для конкретного КППО", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("previousComplexIndicator")
  public BigDecimal getPreviousComplexIndicator() {
    return previousComplexIndicator;
  }

  public void setPreviousComplexIndicator(BigDecimal previousComplexIndicator) {
    this.previousComplexIndicator = previousComplexIndicator;
  }

  public ForecastDataCalculateDto weatherDataParams(List<@Valid WeatherValueDto> weatherDataParams) {
    this.weatherDataParams = weatherDataParams;
    return this;
  }

  public ForecastDataCalculateDto addWeatherDataParamsItem(WeatherValueDto weatherDataParamsItem) {
    if (this.weatherDataParams == null) {
      this.weatherDataParams = new ArrayList<>();
    }
    this.weatherDataParams.add(weatherDataParamsItem);
    return this;
  }

  /**
   * Параметры прогноза для конкретного КППО
   * @return weatherDataParams
  */
  @NotNull @Valid 
  @Schema(name = "weatherDataParams", description = "Параметры прогноза для конкретного КППО", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("weatherDataParams")
  public List<@Valid WeatherValueDto> getWeatherDataParams() {
    return weatherDataParams;
  }

  public void setWeatherDataParams(List<@Valid WeatherValueDto> weatherDataParams) {
    this.weatherDataParams = weatherDataParams;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ForecastDataCalculateDto forecastDataCalculateDto = (ForecastDataCalculateDto) o;
    return Objects.equals(this.ffwiId, forecastDataCalculateDto.ffwiId) &&
        Objects.equals(this.previousComplexIndicator, forecastDataCalculateDto.previousComplexIndicator) &&
        Objects.equals(this.weatherDataParams, forecastDataCalculateDto.weatherDataParams);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ffwiId, previousComplexIndicator, weatherDataParams);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ForecastDataCalculateDto {\n");
    sb.append("    ffwiId: ").append(toIndentedString(ffwiId)).append("\n");
    sb.append("    previousComplexIndicator: ").append(toIndentedString(previousComplexIndicator)).append("\n");
    sb.append("    weatherDataParams: ").append(toIndentedString(weatherDataParams)).append("\n");
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

