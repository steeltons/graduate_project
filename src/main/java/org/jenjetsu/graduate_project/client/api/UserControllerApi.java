/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.5.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.jenjetsu.graduate_project.client.api;

import org.jenjetsu.graduate_project.client.model.ApiExceptionDto;
import org.jenjetsu.graduate_project.client.model.UserCreateDto;
import org.jenjetsu.graduate_project.client.model.UserLoginDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
@Validated
@Tag(name = "UserController", description = "Контроллер для работы с пользователями")
public interface UserControllerApi {

    /**
     * POST /api/v1/users/login : Endpoint для аутентификации пользователя в системе
     * Аутентификация пользователя в приложении
     *
     * @param userLoginDto  (optional)
     * @return Успешная аутентификация пользователя в системе (status code 200)
     *         or Ошибка в составлении запроса (status code 400)
     *         or Пользователь не найден в приложении по username или паролю (status code 404)
     *         or Ошибка на сервере (status code 500)
     */
    @Operation(
        operationId = "loginUser",
        summary = "Endpoint для аутентификации пользователя в системе",
        description = "Аутентификация пользователя в приложении",
        tags = { "UserController" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Успешная аутентификация пользователя в системе"),
            @ApiResponse(responseCode = "400", description = "Ошибка в составлении запроса", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiExceptionDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден в приложении по username или паролю", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiExceptionDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Ошибка на сервере", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiExceptionDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/api/v1/users/login",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    ResponseEntity<Void> loginUser(
        @Parameter(name = "UserLoginDto", description = "") @Valid @RequestBody(required = false) UserLoginDto userLoginDto
    );


    /**
     * POST /api/v1/users/registration : Endpoint для регистрации пользователя в системе
     * Регистрация нового пользователя в приложении
     *
     * @param userCreateDto  (optional)
     * @return Успешная регистрация пользователя (status code 201)
     *         or Ошибка в составлении запроса (status code 400)
     *         or Ошибка на сервере (status code 500)
     */
    @Operation(
        operationId = "registrateUser",
        summary = "Endpoint для регистрации пользователя в системе",
        description = "Регистрация нового пользователя в приложении",
        tags = { "UserController" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Успешная регистрация пользователя"),
            @ApiResponse(responseCode = "400", description = "Ошибка в составлении запроса", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiExceptionDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Ошибка на сервере", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiExceptionDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/api/v1/users/registration",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    ResponseEntity<Void> registrateUser(
        @Parameter(name = "UserCreateDto", description = "") @Valid @RequestBody(required = false) UserCreateDto userCreateDto
    );

}