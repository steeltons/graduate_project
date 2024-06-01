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
 * ДТО на добавление новго погодного условия
 */

@Schema(name = "CreateWeaterDataDto", description = "ДТО на добавление новго погодного условия")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-01T16:21:44.884137818+10:00[Asia/Vladivostok]", comments = "Generator version: 7.5.0")
public class CreateWeaterDataDto {

  private String name;

  public CreateWeaterDataDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateWeaterDataDto(String name) {
    this.name = name;
  }

  public CreateWeaterDataDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", example = "Температура воздуха", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateWeaterDataDto createWeaterDataDto = (CreateWeaterDataDto) o;
    return Objects.equals(this.name, createWeaterDataDto.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateWeaterDataDto {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

