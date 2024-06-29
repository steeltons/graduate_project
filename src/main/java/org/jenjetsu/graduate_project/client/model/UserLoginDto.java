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
 * DTO для логина пользователя
 */

@Schema(name = "UserLoginDto", description = "DTO для логина пользователя")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class UserLoginDto {

  private String username;

  private String password;

  public UserLoginDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UserLoginDto(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public UserLoginDto username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Логин или почта пользователя
   * @return username
  */
  @NotNull 
  @Schema(name = "username", example = "tcvetkov.so", description = "Логин или почта пользователя", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public UserLoginDto password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Пароль пользователя
   * @return password
  */
  @NotNull 
  @Schema(name = "password", example = "$omeP@ssw0rd", description = "Пароль пользователя", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserLoginDto userLoginDto = (UserLoginDto) o;
    return Objects.equals(this.username, userLoginDto.username) &&
        Objects.equals(this.password, userLoginDto.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserLoginDto {\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

