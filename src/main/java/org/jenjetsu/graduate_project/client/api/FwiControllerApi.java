/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.5.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.jenjetsu.graduate_project.client.api;

import org.jenjetsu.graduate_project.client.model.ApiExceptionDto;
import org.jenjetsu.graduate_project.client.model.FWICreateDto;
import org.jenjetsu.graduate_project.client.model.FWIResponseDto;
import org.jenjetsu.graduate_project.client.model.FWIUpdateDto;
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
@Tag(name = "FWIController", description = "Контроллер для работы с классом пожарной опасности")
public interface FwiControllerApi {

    /**
     * POST /api/v1/fire-weather-indexes : Добавть запись
     * Добавление новой записи по КПО в БД
     *
     * @param fwICreateDto  (required)
     * @return Успешное добавление КПО (status code 200)
     *         or Ошибка в составлении запроса (status code 400)
     *         or Пользователь не авторизован (status code 401)
     *         or Пользователю не хватает прав (status code 403)
     *         or Ошибка на сервере (status code 500)
     */
    @Operation(
        operationId = "createFwi",
        summary = "Добавть запись",
        description = "Добавление новой записи по КПО в БД",
        tags = { "FWIController" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Успешное добавление КПО"),
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
        value = "/api/v1/fire-weather-indexes",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    ResponseEntity<Void> createFwi(
        @Parameter(name = "FWICreateDto", description = "", required = true) @Valid @RequestBody FWICreateDto fwICreateDto
    );


    /**
     * DELETE /api/v1/fire-weather-indexes/{id} : Удалить запись
     * Удаление записи по КПО
     *
     * @param id  (required)
     * @return Успешное выполнение запроса (status code 200)
     *         or Отсутствие id в запросе (status code 400)
     *         or Пользователь не авторизован (status code 401)
     *         or Пользователь не авторизован (status code 404)
     *         or Ошибка на сервере (status code 500)
     */
    @Operation(
        operationId = "deleteById",
        summary = "Удалить запись",
        description = "Удаление записи по КПО",
        tags = { "FWIController" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Успешное выполнение запроса"),
            @ApiResponse(responseCode = "400", description = "Отсутствие id в запросе", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiExceptionDto.class))
            }),
            @ApiResponse(responseCode = "401", description = "Пользователь не авторизован", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiExceptionDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Пользователь не авторизован", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiExceptionDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Ошибка на сервере", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiExceptionDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/api/v1/fire-weather-indexes/{id}",
        produces = { "application/json" }
    )
    
    ResponseEntity<Void> deleteById(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") UUID id
    );


    /**
     * GET /api/v1/fire-weather-indexes : Получить весь список
     * Получение всего списка по КПО для отображения
     *
     * @return Успешный ответ (status code 200)
     *         or Пользователь не авторизован (status code 401)
     *         or Ошибка на сервере (status code 500)
     */
    @Operation(
        operationId = "getAll",
        summary = "Получить весь список",
        description = "Получение всего списка по КПО для отображения",
        tags = { "FWIController" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Успешный ответ", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = FWIResponseDto.class)))
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
        value = "/api/v1/fire-weather-indexes",
        produces = { "application/json" }
    )
    
    ResponseEntity<List<FWIResponseDto>> getAll(
        
    );


    /**
     * GET /api/v1/fire-weather-indexes/{id} : Получение конкретной записи
     * Получение конкретной записи об КПО
     *
     * @param id  (required)
     * @return Успешный запрос (status code 200)
     *         or Отсутствие id в запросе (status code 400)
     *         or Пользователь не авторизован (status code 401)
     *         or Пользователь не авторизован (status code 404)
     *         or Ошибка на сервере (status code 500)
     */
    @Operation(
        operationId = "getById",
        summary = "Получение конкретной записи",
        description = "Получение конкретной записи об КПО",
        tags = { "FWIController" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Успешный запрос", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = FWIResponseDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Отсутствие id в запросе", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiExceptionDto.class))
            }),
            @ApiResponse(responseCode = "401", description = "Пользователь не авторизован", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiExceptionDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Пользователь не авторизован", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiExceptionDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Ошибка на сервере", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiExceptionDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/fire-weather-indexes/{id}",
        produces = { "application/json" }
    )
    
    ResponseEntity<FWIResponseDto> getById(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") UUID id
    );


    /**
     * PATCH /api/v1/fire-weather-indexes : Обновить запись
     * Обновление информации по КПО
     *
     * @param fwIUpdateDto  (required)
     * @return Успешное обновление записи (status code 200)
     *         or Ошибка в составлении запроса (status code 400)
     *         or Пользователь не авторизован (status code 401)
     *         or Пользователю не хватает прав (status code 403)
     *         or Ошибка на сервере (status code 500)
     */
    @Operation(
        operationId = "updateFwi",
        summary = "Обновить запись",
        description = "Обновление информации по КПО",
        tags = { "FWIController" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Успешное обновление записи"),
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
        method = RequestMethod.PATCH,
        value = "/api/v1/fire-weather-indexes",
        produces = { "application/json" },
        consumes = { "applicaton/json" }
    )
    
    ResponseEntity<Void> updateFwi(
        @Parameter(name = "FWIUpdateDto", description = "", required = true) @Valid @RequestBody FWIUpdateDto fwIUpdateDto
    );

}
