/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.5.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.jenjetsu.graduate_project.client.api;

import org.jenjetsu.graduate_project.client.model.ApiExceptionDto;
import org.jenjetsu.graduate_project.client.model.PrecipitationRecordCreateDto;
import org.jenjetsu.graduate_project.client.model.PrecipitationRecordResponseDto;
import org.jenjetsu.graduate_project.client.model.PrecipitationRecordUpdateDto;
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
@Tag(name = "PrecipitationRecordController", description = "the PrecipitationRecordController API")
public interface PrecipitationRecordControllerApi {

    /**
     * POST /api/v1/precipitation-records : Добавить запись по таблице осадков
     * Добавление новой записи по природному осадку в БД
     *
     * @param precipitationRecordCreateDto  (required)
     * @return Успешное добавление записи (status code 201)
     *         or Ошибка в составлении запроса (status code 400)
     *         or Пользователь не авторизован (status code 401)
     *         or Пользователю не хватает прав (status code 403)
     *         or Ошибка на сервере (status code 500)
     */
    @Operation(
        operationId = "addPrecipitationRecord",
        summary = "Добавить запись по таблице осадков",
        description = "Добавление новой записи по природному осадку в БД",
        tags = { "PrecipitationRecordController" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Успешное добавление записи", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PrecipitationRecordResponseDto.class))
            }),
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
        value = "/api/v1/precipitation-records",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    ResponseEntity<PrecipitationRecordResponseDto> addPrecipitationRecord(
        @Parameter(name = "PrecipitationRecordCreateDto", description = "", required = true) @Valid @RequestBody PrecipitationRecordCreateDto precipitationRecordCreateDto
    );


    /**
     * DELETE /api/v1/precipitation-records/{id} : Удалить запись
     * Удаление конкретной записи по id
     *
     * @param id  (required)
     * @return Успешное выполнение запроса (status code 200)
     *         or Отсутствие id в запросе (status code 400)
     *         or Пользователь не авторизован (status code 401)
     *         or Пользователь не авторизован (status code 404)
     *         or Ошибка на сервере (status code 500)
     */
    @Operation(
        operationId = "deleteRecord",
        summary = "Удалить запись",
        description = "Удаление конкретной записи по id",
        tags = { "PrecipitationRecordController" },
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
        value = "/api/v1/precipitation-records/{id}",
        produces = { "application/json" }
    )
    
    ResponseEntity<Void> deleteRecord(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    );


    /**
     * GET /api/v1/precipitation-records : Получить записи по таблице осадков
     * Получение всех записей таблицы осадков
     *
     * @return Успешное получение всех записей (status code 200)
     *         or Пользователь не авторизован (status code 401)
     *         or Ошибка на сервере (status code 500)
     */
    @Operation(
        operationId = "getPrecipitationRecords",
        summary = "Получить записи по таблице осадков",
        description = "Получение всех записей таблицы осадков",
        tags = { "PrecipitationRecordController" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Успешное получение всех записей", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PrecipitationRecordResponseDto.class)))
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
        value = "/api/v1/precipitation-records",
        produces = { "application/json" }
    )
    
    ResponseEntity<List<PrecipitationRecordResponseDto>> getPrecipitationRecords(
        
    );


    /**
     * GET /api/v1/precipitation-records/{id} : Получение конкретной записи
     * Всё равно меня никто не прочитает
     *
     * @param id  (required)
     * @return Успешный ответ (status code 200)
     *         or Пользователь не авторизован (status code 401)
     *         or Ошибка на сервере (status code 500)
     */
    @Operation(
        operationId = "getRecordById",
        summary = "Получение конкретной записи",
        description = "Всё равно меня никто не прочитает",
        tags = { "PrecipitationRecordController" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Успешный ответ", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PrecipitationRecordResponseDto.class))
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
        value = "/api/v1/precipitation-records/{id}",
        produces = { "application/json" }
    )
    
    ResponseEntity<PrecipitationRecordResponseDto> getRecordById(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    );


    /**
     * PATCH /api/v1/precipitation-records : Обновить запись по осадкам
     * Измененение минимальной, максимальной границы и кол-во осадков
     *
     * @param precipitationRecordUpdateDto  (required)
     * @return Успешное обновление записи (status code 200)
     *         or Ошибка в составлении запроса (status code 400)
     *         or Пользователь не авторизован (status code 401)
     *         or Пользователю не хватает прав (status code 403)
     *         or Ошибка на сервере (status code 500)
     */
    @Operation(
        operationId = "patchRecord",
        summary = "Обновить запись по осадкам",
        description = "Измененение минимальной, максимальной границы и кол-во осадков",
        tags = { "PrecipitationRecordController" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Успешное обновление записи", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PrecipitationRecordResponseDto.class))
            }),
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
        value = "/api/v1/precipitation-records",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    ResponseEntity<PrecipitationRecordResponseDto> patchRecord(
        @Parameter(name = "PrecipitationRecordUpdateDto", description = "", required = true) @Valid @RequestBody PrecipitationRecordUpdateDto precipitationRecordUpdateDto
    );

}