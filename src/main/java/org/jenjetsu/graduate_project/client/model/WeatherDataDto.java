package org.jenjetsu.graduate_project.client.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.UUID;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * WeatherDataDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class WeatherDataDto {

  private UUID id;

  private String name;

  private String description;

  public WeatherDataDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public WeatherDataDto(UUID id, String name) {
    this.id = id;
    this.name = name;
  }

  public WeatherDataDto id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * ID погодного параметра в системе
   * @return id
  */
  @NotNull @Valid 
  @Schema(name = "id", example = "1993dbee-eb94-46cb-aa9d-5b166b1c6659", description = "ID погодного параметра в системе", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public WeatherDataDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Название погодного параметра
   * @return name
  */
  @NotNull 
  @Schema(name = "name", example = "Температура воздуха", description = "Название погодного параметра", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public WeatherDataDto description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Описание параметра
   * @return description
  */
  
  @Schema(name = "description", example = "AAAAAAAAAAA", description = "Описание параметра", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WeatherDataDto weatherDataDto = (WeatherDataDto) o;
    return Objects.equals(this.id, weatherDataDto.id) &&
        Objects.equals(this.name, weatherDataDto.name) &&
        Objects.equals(this.description, weatherDataDto.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WeatherDataDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

