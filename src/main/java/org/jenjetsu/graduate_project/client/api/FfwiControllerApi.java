/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.5.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.jenjetsu.graduate_project.client.api;

import org.jenjetsu.graduate_project.client.model.ApiExceptionDto;
import org.jenjetsu.graduate_project.client.model.FFWICreateRequestDto;
import org.jenjetsu.graduate_project.client.model.FFWIResponseDto;
import java.util.UUID;
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
@Tag(name = "FFWIController", description = "Контроллер для работы с комплексными показателями пожарной опасности")
public interface FfwiControllerApi {

    /**
     * POST /api/v1/fire-forecast-indexes : Endpoint для добавления нового КППО
     * Добавление КППО в базу данных
     *
     * @param ffWICreateRequestDto  (optional)
     * @return Успешное создание КППО (status code 201)
     *         or Ошибка в составлении запроса (status code 400)
     *         or Пользователь не авторизован (status code 401)
     *         or Пользователю не хватает прав (status code 403)
     *         or Ошибка на сервере (status code 500)
     */
    @Operation(
        operationId = "createFfwi",
        summary = "Endpoint для добавления нового КППО",
        description = "Добавление КППО в базу данных",
        tags = { "FFWIController" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Успешное создание КППО"),
            @ApiResponse(responseCode = "400", description = "Ошибка в составлении запроса", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiExceptionDto.class))
            }),
            @ApiResponse(responseCode = "401", description = "Пользователь не авторизован", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiExceptionDto.class))
            }),
            @ApiResponse(responseCode = "403", description = "Пользователю не хватает прав", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiExceptionDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Ошибка на сервере", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiExceptionDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/api/v1/fire-forecast-indexes",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    ResponseEntity<Void> createFfwi(
        @Parameter(name = "FFWICreateRequestDto", description = "") @Valid @RequestBody(required = false) FFWICreateRequestDto ffWICreateRequestDto
    );


    /**
     * GET /api/v1/fire-forecast-indexes : Endpoint для получения всей информации об КППО
     * Получение списка КППО для отображения на странице
     *
     * @return Успешный ответ на запрос (status code 200)
     *         or Пользователь не авторизован (status code 401)
     *         or Ошибка на сервере (status code 500)
     */
    @Operation(
        operationId = "getAllFfwi",
        summary = "Endpoint для получения всей информации об КППО",
        description = "Получение списка КППО для отображения на странице",
        tags = { "FFWIController" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Успешный ответ на запрос", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = FFWIResponseDto.class)))
            }),
            @ApiResponse(responseCode = "401", description = "Пользователь не авторизован", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiExceptionDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Ошибка на сервере", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiExceptionDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/fire-forecast-indexes",
        produces = { "application/json" }
    )
    
    ResponseEntity<List<FFWIResponseDto>> getAllFfwi(
        
    );


    /**
     * GET /api/v1/fire-forecase-indexes/{id} : Получить КППО по id
     * получение КППО по id
     *
     * @param id  (required)
     * @return Успешный ответ (status code 200)
     *         or Отсутствие id в запросе (status code 400)
     *         or Пользователь не авторизован (status code 401)
     *         or Пользователь не авторизован (status code 404)
     *         or Ошибка на сервере (status code 500)
     */
    @Operation(
        operationId = "getFfwiById",
        summary = "Получить КППО по id",
        description = "получение КППО по id",
        tags = { "FFWIController" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Успешный ответ", content = {
                @Content(mediaType = "appplication/json", schema = @Schema(implementation = FFWIResponseDto.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = FFWIResponseDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Отсутствие id в запросе", content = {
                @Content(mediaType = "appplication/json", schema = @Schema(implementation = ApiExceptionDto.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiExceptionDto.class))
            }),
            @ApiResponse(responseCode = "401", description = "Пользователь не авторизован", content = {
                @Content(mediaType = "appplication/json", schema = @Schema(implementation = ApiExceptionDto.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiExceptionDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Пользователь не авторизован", content = {
                @Content(mediaType = "appplication/json", schema = @Schema(implementation = ApiExceptionDto.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiExceptionDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Ошибка на сервере", content = {
                @Content(mediaType = "appplication/json", schema = @Schema(implementation = ApiExceptionDto.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiExceptionDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/fire-forecase-indexes/{id}",
        produces = { "appplication/json", "application/json" }
    )
    
    ResponseEntity<FFWIResponseDto> getFfwiById(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") UUID id
    );

}
