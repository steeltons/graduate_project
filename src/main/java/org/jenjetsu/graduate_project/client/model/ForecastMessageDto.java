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
 * ForecastMessageDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class ForecastMessageDto {

  private Integer step;

  private String message;

  private UUID ffwiId;

  public ForecastMessageDto step(Integer step) {
    this.step = step;
    return this;
  }

  /**
   * Шаг расчёта
   * @return step
  */
  
  @Schema(name = "step", example = "0", description = "Шаг расчёта", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("step")
  public Integer getStep() {
    return step;
  }

  public void setStep(Integer step) {
    this.step = step;
  }

  public ForecastMessageDto message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Сообщение с шага
   * @return message
  */
  
  @Schema(name = "message", example = "Коэффициент осадков = 0 т.к. сегодняшние дневные осадки меньше максимального порога", description = "Сообщение с шага", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ForecastMessageDto ffwiId(UUID ffwiId) {
    this.ffwiId = ffwiId;
    return this;
  }

  /**
   * ID КППО, для которого расчитывается
   * @return ffwiId
  */
  @Valid 
  @Schema(name = "ffwiId", example = "7575fa5e-252f-46dc-9684-8414e2c93a1b", description = "ID КППО, для которого расчитывается", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ffwiId")
  public UUID getFfwiId() {
    return ffwiId;
  }

  public void setFfwiId(UUID ffwiId) {
    this.ffwiId = ffwiId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ForecastMessageDto forecastMessageDto = (ForecastMessageDto) o;
    return Objects.equals(this.step, forecastMessageDto.step) &&
        Objects.equals(this.message, forecastMessageDto.message) &&
        Objects.equals(this.ffwiId, forecastMessageDto.ffwiId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(step, message, ffwiId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ForecastMessageDto {\n");
    sb.append("    step: ").append(toIndentedString(step)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    ffwiId: ").append(toIndentedString(ffwiId)).append("\n");
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

