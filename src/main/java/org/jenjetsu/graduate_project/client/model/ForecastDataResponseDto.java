package org.jenjetsu.graduate_project.client.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.jenjetsu.graduate_project.client.model.FFWIWeatherParamDto;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ForecastDataResponseDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class ForecastDataResponseDto {

  private UUID ffwiId;

  private String ffwiName;

  private BigDecimal previousComplexIndicator;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate previousComplexDate;

  @Valid
  private List<@Valid FFWIWeatherParamDto> weatherDataParams = new ArrayList<>();

  public ForecastDataResponseDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ForecastDataResponseDto(UUID ffwiId, String ffwiName, BigDecimal previousComplexIndicator, LocalDate previousComplexDate, List<@Valid FFWIWeatherParamDto> weatherDataParams) {
    this.ffwiId = ffwiId;
    this.ffwiName = ffwiName;
    this.previousComplexIndicator = previousComplexIndicator;
    this.previousComplexDate = previousComplexDate;
    this.weatherDataParams = weatherDataParams;
  }

  public ForecastDataResponseDto ffwiId(UUID ffwiId) {
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

  public ForecastDataResponseDto ffwiName(String ffwiName) {
    this.ffwiName = ffwiName;
    return this;
  }

  /**
   * Название КППО для отображения на фронте
   * @return ffwiName
  */
  @NotNull 
  @Schema(name = "ffwiName", example = "КППО нестерова", description = "Название КППО для отображения на фронте", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("ffwiName")
  public String getFfwiName() {
    return ffwiName;
  }

  public void setFfwiName(String ffwiName) {
    this.ffwiName = ffwiName;
  }

  public ForecastDataResponseDto previousComplexIndicator(BigDecimal previousComplexIndicator) {
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

  public ForecastDataResponseDto previousComplexDate(LocalDate previousComplexDate) {
    this.previousComplexDate = previousComplexDate;
    return this;
  }

  /**
   * Get previousComplexDate
   * @return previousComplexDate
  */
  @NotNull @Valid 
  @Schema(name = "previousComplexDate", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("previousComplexDate")
  public LocalDate getPreviousComplexDate() {
    return previousComplexDate;
  }

  public void setPreviousComplexDate(LocalDate previousComplexDate) {
    this.previousComplexDate = previousComplexDate;
  }

  public ForecastDataResponseDto weatherDataParams(List<@Valid FFWIWeatherParamDto> weatherDataParams) {
    this.weatherDataParams = weatherDataParams;
    return this;
  }

  public ForecastDataResponseDto addWeatherDataParamsItem(FFWIWeatherParamDto weatherDataParamsItem) {
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
  public List<@Valid FFWIWeatherParamDto> getWeatherDataParams() {
    return weatherDataParams;
  }

  public void setWeatherDataParams(List<@Valid FFWIWeatherParamDto> weatherDataParams) {
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
    ForecastDataResponseDto forecastDataResponseDto = (ForecastDataResponseDto) o;
    return Objects.equals(this.ffwiId, forecastDataResponseDto.ffwiId) &&
        Objects.equals(this.ffwiName, forecastDataResponseDto.ffwiName) &&
        Objects.equals(this.previousComplexIndicator, forecastDataResponseDto.previousComplexIndicator) &&
        Objects.equals(this.previousComplexDate, forecastDataResponseDto.previousComplexDate) &&
        Objects.equals(this.weatherDataParams, forecastDataResponseDto.weatherDataParams);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ffwiId, ffwiName, previousComplexIndicator, previousComplexDate, weatherDataParams);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ForecastDataResponseDto {\n");
    sb.append("    ffwiId: ").append(toIndentedString(ffwiId)).append("\n");
    sb.append("    ffwiName: ").append(toIndentedString(ffwiName)).append("\n");
    sb.append("    previousComplexIndicator: ").append(toIndentedString(previousComplexIndicator)).append("\n");
    sb.append("    previousComplexDate: ").append(toIndentedString(previousComplexDate)).append("\n");
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

