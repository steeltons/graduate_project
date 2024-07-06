package org.jenjetsu.graduate_project.client.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.jenjetsu.graduate_project.client.model.FFWIWeatherParamDto;
import org.jenjetsu.graduate_project.client.model.PrecipitationRecordResponseDto;
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

  private UUID id;

  private String name;

  private String formula;

  private String fwis;

  @Valid
  private List<@Valid FFWIWeatherParamDto> weatherDataParams = new ArrayList<>();

  @Valid
  private List<@Valid PrecipitationRecordResponseDto> precipitationRecords = new ArrayList<>();

  public FFWIResponseDto id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * ID КППО
   * @return id
  */
  @Valid 
  @Schema(name = "id", example = "92eb322f-9fec-4f5c-adbf-008627ed271a", description = "ID КППО", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
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

  public FFWIResponseDto weatherDataParams(List<@Valid FFWIWeatherParamDto> weatherDataParams) {
    this.weatherDataParams = weatherDataParams;
    return this;
  }

  public FFWIResponseDto addWeatherDataParamsItem(FFWIWeatherParamDto weatherDataParamsItem) {
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

  public FFWIResponseDto precipitationRecords(List<@Valid PrecipitationRecordResponseDto> precipitationRecords) {
    this.precipitationRecords = precipitationRecords;
    return this;
  }

  public FFWIResponseDto addPrecipitationRecordsItem(PrecipitationRecordResponseDto precipitationRecordsItem) {
    if (this.precipitationRecords == null) {
      this.precipitationRecords = new ArrayList<>();
    }
    this.precipitationRecords.add(precipitationRecordsItem);
    return this;
  }

  /**
   * Get precipitationRecords
   * @return precipitationRecords
  */
  @Valid 
  @Schema(name = "precipitationRecords", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("precipitationRecords")
  public List<@Valid PrecipitationRecordResponseDto> getPrecipitationRecords() {
    return precipitationRecords;
  }

  public void setPrecipitationRecords(List<@Valid PrecipitationRecordResponseDto> precipitationRecords) {
    this.precipitationRecords = precipitationRecords;
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
    return Objects.equals(this.id, ffWIResponseDto.id) &&
        Objects.equals(this.name, ffWIResponseDto.name) &&
        Objects.equals(this.formula, ffWIResponseDto.formula) &&
        Objects.equals(this.fwis, ffWIResponseDto.fwis) &&
        Objects.equals(this.weatherDataParams, ffWIResponseDto.weatherDataParams) &&
        Objects.equals(this.precipitationRecords, ffWIResponseDto.precipitationRecords);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, formula, fwis, weatherDataParams, precipitationRecords);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FFWIResponseDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    formula: ").append(toIndentedString(formula)).append("\n");
    sb.append("    fwis: ").append(toIndentedString(fwis)).append("\n");
    sb.append("    weatherDataParams: ").append(toIndentedString(weatherDataParams)).append("\n");
    sb.append("    precipitationRecords: ").append(toIndentedString(precipitationRecords)).append("\n");
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

