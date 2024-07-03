package org.jenjetsu.graduate_project.client.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jenjetsu.graduate_project.client.model.FFWIWeatherParamDto;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * DTO для создания КППО
 */

@Schema(name = "FFWICreateRequestDto", description = "DTO для создания КППО")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class FFWICreateRequestDto {

  private String name;

  private String formula;

  @Valid
  private List<@Valid FFWIWeatherParamDto> weatherDataParams = new ArrayList<>();

  public FFWICreateRequestDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FFWICreateRequestDto(String name, String formula) {
    this.name = name;
    this.formula = formula;
  }

  public FFWICreateRequestDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Название КППО
   * @return name
  */
  @NotNull 
  @Schema(name = "name", example = "КППО Свердловой", description = "Название КППО", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FFWICreateRequestDto formula(String formula) {
    this.formula = formula;
    return this;
  }

  /**
   * Формула определения КП
   * @return formula
  */
  @NotNull 
  @Schema(name = "formula", description = "Формула определения КП", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("formula")
  public String getFormula() {
    return formula;
  }

  public void setFormula(String formula) {
    this.formula = formula;
  }

  public FFWICreateRequestDto weatherDataParams(List<@Valid FFWIWeatherParamDto> weatherDataParams) {
    this.weatherDataParams = weatherDataParams;
    return this;
  }

  public FFWICreateRequestDto addWeatherDataParamsItem(FFWIWeatherParamDto weatherDataParamsItem) {
    if (this.weatherDataParams == null) {
      this.weatherDataParams = new ArrayList<>();
    }
    this.weatherDataParams.add(weatherDataParamsItem);
    return this;
  }

  /**
   * Get weatherDataParams
   * @return weatherDataParams
  */
  @Valid 
  @Schema(name = "weatherDataParams", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    FFWICreateRequestDto ffWICreateRequestDto = (FFWICreateRequestDto) o;
    return Objects.equals(this.name, ffWICreateRequestDto.name) &&
        Objects.equals(this.formula, ffWICreateRequestDto.formula) &&
        Objects.equals(this.weatherDataParams, ffWICreateRequestDto.weatherDataParams);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, formula, weatherDataParams);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FFWICreateRequestDto {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    formula: ").append(toIndentedString(formula)).append("\n");
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

