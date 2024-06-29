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
 * DTO для создания пользователя
 */

@Schema(name = "UserCreateDto", description = "DTO для создания пользователя")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class UserCreateDto {

  private UUID registrationCode;

  private String login;

  private String password;

  private String email;

  public UserCreateDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UserCreateDto(UUID registrationCode, String login, String password, String email) {
    this.registrationCode = registrationCode;
    this.login = login;
    this.password = password;
    this.email = email;
  }

  public UserCreateDto registrationCode(UUID registrationCode) {
    this.registrationCode = registrationCode;
    return this;
  }

  /**
   * Код регистрации пользователя
   * @return registrationCode
  */
  @NotNull @Valid 
  @Schema(name = "registrationCode", example = "7894a71a-0c58-4ee0-9ed7-283ae4ce54ae", description = "Код регистрации пользователя", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("registrationCode")
  public UUID getRegistrationCode() {
    return registrationCode;
  }

  public void setRegistrationCode(UUID registrationCode) {
    this.registrationCode = registrationCode;
  }

  public UserCreateDto login(String login) {
    this.login = login;
    return this;
  }

  /**
   * Логин пользователя
   * @return login
  */
  @NotNull 
  @Schema(name = "login", example = "tcvetkov.so", description = "Логин пользователя", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("login")
  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public UserCreateDto password(String password) {
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

  public UserCreateDto email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Email адрес пользователя
   * @return email
  */
  @NotNull @jakarta.validation.constraints.Email 
  @Schema(name = "email", example = "tsvetkov@so@dvfu.ru", description = "Email адрес пользователя", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserCreateDto userCreateDto = (UserCreateDto) o;
    return Objects.equals(this.registrationCode, userCreateDto.registrationCode) &&
        Objects.equals(this.login, userCreateDto.login) &&
        Objects.equals(this.password, userCreateDto.password) &&
        Objects.equals(this.email, userCreateDto.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(registrationCode, login, password, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserCreateDto {\n");
    sb.append("    registrationCode: ").append(toIndentedString(registrationCode)).append("\n");
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

