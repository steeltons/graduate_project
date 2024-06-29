package org.jenjetsu.graduate_project.client.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Представление погодного параметра с параметром, связывающим формулу
 */

@Schema(name = "FFWIWeatherParamDto", description = "Представление погодного параметра с параметром, связывающим формулу")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class FFWIWeatherParamDto {

  private String id;

  private String weatherName;

  private String formulaParameter;

  public FFWIWeatherParamDto id(String id) {
    this.id = id;
    return this;
  }

  /**
   * ID погодного параметра
   * @return id
  */
  
  @Schema(name = "id", example = "2a3c6c0e-2d26-49fb-ab45-55a3e703cace", description = "ID погодного параметра", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public FFWIWeatherParamDto weatherName(String weatherName) {
    this.weatherName = weatherName;
    return this;
  }

  /**
   * Название погодного условия
   * @return weatherName
  */
  
  @Schema(name = "weatherName", example = "Температура воздуха", description = "Название погодного условия", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("weatherName")
  public String getWeatherName() {
    return weatherName;
  }

  public void setWeatherName(String weatherName) {
    this.weatherName = weatherName;
  }

  public FFWIWeatherParamDto formulaParameter(String formulaParameter) {
    this.formulaParameter = formulaParameter;
    return this;
  }

  /**
   * Название параметра в формуле
   * @return formulaParameter
  */
  
  @Schema(name = "formulaParameter", example = "$T_d", description = "Название параметра в формуле", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("formulaParameter")
  public String getFormulaParameter() {
    return formulaParameter;
  }

  public void setFormulaParameter(String formulaParameter) {
    this.formulaParameter = formulaParameter;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FFWIWeatherParamDto ffWIWeatherParamDto = (FFWIWeatherParamDto) o;
    return Objects.equals(this.id, ffWIWeatherParamDto.id) &&
        Objects.equals(this.weatherName, ffWIWeatherParamDto.weatherName) &&
        Objects.equals(this.formulaParameter, ffWIWeatherParamDto.formulaParameter);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, weatherName, formulaParameter);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FFWIWeatherParamDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    weatherName: ").append(toIndentedString(weatherName)).append("\n");
    sb.append("    formulaParameter: ").append(toIndentedString(formulaParameter)).append("\n");
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

