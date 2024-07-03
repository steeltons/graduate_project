package org.jenjetsu.graduate_project.client.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.jenjetsu.graduate_project.client.model.FFWIResponseDtoPrecipitationTableParamsInner;
import org.jenjetsu.graduate_project.client.model.FFWIWeatherParamDto;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * DTO представления КППО в приложении
 */

@Schema(name = "FFWIResponseDto", description = "DTO представления КППО в приложении")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class FFWIResponseDto {

  private UUID ffwiId;

  private String name;

  private String formula;

  private String fwis;

  @Valid
  private List<@Valid FFWIWeatherParamDto> weatherParams = new ArrayList<>();

  @Valid
  private List<@Valid FFWIResponseDtoPrecipitationTableParamsInner> precipitationTableParams = new ArrayList<>();

  public FFWIResponseDto ffwiId(UUID ffwiId) {
    this.ffwiId = ffwiId;
    return this;
  }

  /**
   * ID КППО
   * @return ffwiId
  */
  @Valid 
  @Schema(name = "ffwiId", example = "92eb322f-9fec-4f5c-adbf-008627ed271a", description = "ID КППО", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ffwiId")
  public UUID getFfwiId() {
    return ffwiId;
  }

  public void setFfwiId(UUID ffwiId) {
    this.ffwiId = ffwiId;
  }

  public FFWIResponseDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Название КППО
   * @return name
  */
  
  @Schema(name = "name", example = "КППО Нестерова", description = "Название КППО", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FFWIResponseDto formula(String formula) {
    this.formula = formula;
    return this;
  }

  /**
   * Формула определения КП
   * @return formula
  */
  
  @Schema(name = "formula", example = "($T_d - $T_0) * $T_d", description = "Формула определения КП", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("formula")
  public String getFormula() {
    return formula;
  }

  public void setFormula(String formula) {
    this.formula = formula;
  }

  public FFWIResponseDto fwis(String fwis) {
    this.fwis = fwis;
    return this;
  }

  /**
   * Список названий КПО, придлежащих КППО
   * @return fwis
  */
  
  @Schema(name = "fwis", example = "КПО_Нестеров_1, КПО_Нестеров_2, КПО_Нестеров_3", description = "Список названий КПО, придлежащих КППО", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fwis")
  public String getFwis() {
    return fwis;
  }

  public void setFwis(String fwis) {
    this.fwis = fwis;
  }

  public FFWIResponseDto weatherParams(List<@Valid FFWIWeatherParamDto> weatherParams) {
    this.weatherParams = weatherParams;
    return this;
  }

  public FFWIResponseDto addWeatherParamsItem(FFWIWeatherParamDto weatherParamsItem) {
    if (this.weatherParams == null) {
      this.weatherParams = new ArrayList<>();
    }
    this.weatherParams.add(weatherParamsItem);
    return this;
  }

  /**
   * Get weatherParams
   * @return weatherParams
  */
  @Valid 
  @Schema(name = "weatherParams", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("weatherParams")
  public List<@Valid FFWIWeatherParamDto> getWeatherParams() {
    return weatherParams;
  }

  public void setWeatherParams(List<@Valid FFWIWeatherParamDto> weatherParams) {
    this.weatherParams = weatherParams;
  }

  public FFWIResponseDto precipitationTableParams(List<@Valid FFWIResponseDtoPrecipitationTableParamsInner> precipitationTableParams) {
    this.precipitationTableParams = precipitationTableParams;
    return this;
  }

  public FFWIResponseDto addPrecipitationTableParamsItem(FFWIResponseDtoPrecipitationTableParamsInner precipitationTableParamsItem) {
    if (this.precipitationTableParams == null) {
      this.precipitationTableParams = new ArrayList<>();
    }
    this.precipitationTableParams.add(precipitationTableParamsItem);
    return this;
  }

  /**
   * Get precipitationTableParams
   * @return precipitationTableParams
  */
  @Valid 
  @Schema(name = "precipitationTableParams", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("precipitationTableParams")
  public List<@Valid FFWIResponseDtoPrecipitationTableParamsInner> getPrecipitationTableParams() {
    return precipitationTableParams;
  }

  public void setPrecipitationTableParams(List<@Valid FFWIResponseDtoPrecipitationTableParamsInner> precipitationTableParams) {
    this.precipitationTableParams = precipitationTableParams;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FFWIResponseDto ffWIResponseDto = (FFWIResponseDto) o;
    return Objects.equals(this.ffwiId, ffWIResponseDto.ffwiId) &&
        Objects.equals(this.name, ffWIResponseDto.name) &&
        Objects.equals(this.formula, ffWIResponseDto.formula) &&
        Objects.equals(this.fwis, ffWIResponseDto.fwis) &&
        Objects.equals(this.weatherParams, ffWIResponseDto.weatherParams) &&
        Objects.equals(this.precipitationTableParams, ffWIResponseDto.precipitationTableParams);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ffwiId, name, formula, fwis, weatherParams, precipitationTableParams);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FFWIResponseDto {\n");
    sb.append("    ffwiId: ").append(toIndentedString(ffwiId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    formula: ").append(toIndentedString(formula)).append("\n");
    sb.append("    fwis: ").append(toIndentedString(fwis)).append("\n");
    sb.append("    weatherParams: ").append(toIndentedString(weatherParams)).append("\n");
    sb.append("    precipitationTableParams: ").append(toIndentedString(precipitationTableParams)).append("\n");
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

