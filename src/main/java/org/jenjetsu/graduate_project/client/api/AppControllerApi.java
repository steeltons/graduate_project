/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.5.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.jenjetsu.graduate_project.client.api;

import org.jenjetsu.graduate_project.client.model.ApiExceptionDto;
import org.jenjetsu.graduate_project.client.model.ForecastDataResponseDto;
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
@Tag(name = "AppController", description = "Различные api приложения, которые не попадают ни в один контроллер")
public interface AppControllerApi {

    /**
     * POST /api/v1/app-endpoints : Очитить базу данных
     * Полная очистка базы данных
     *
     * @return Успешная очистка БД (status code 200)
     *         or Пользователь не авторизован (status code 401)
     *         or Пользователю не хватает прав (status code 403)
     *         or Ошибка на сервере (status code 500)
     */
    @Operation(
        operationId = "apiV1AppEndpointsPost",
        summary = "Очитить базу данных",
        description = "Полная очистка базы данных",
        tags = { "AppController" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Успешная очистка БД"),
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
        value = "/api/v1/app-endpoints",
        produces = { "application/json" }
    )
    
    ResponseEntity<Void> apiV1AppEndpointsPost(
        
    );


    /**
     * GET /api/v1/app-endpoints/forecast : Получить данные для составления прогноза
     * Получение всех данных для возможности составления прогноза
     *
     * @return Успешный ответ (status code 200)
     *         or Отсутствие id в запросе (status code 400)
     *         or Пользователь не авторизован (status code 401)
     *         or Ошибка на сервере (status code 500)
     */
    @Operation(
        operationId = "getForecastData",
        summary = "Получить данные для составления прогноза",
        description = "Получение всех данных для возможности составления прогноза",
        tags = { "AppController" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Успешный ответ", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ForecastDataResponseDto.class)))
            }),
            @ApiResponse(responseCode = "400", description = "Отсутствие id в запросе", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiExceptionDto.class))
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
        value = "/api/v1/app-endpoints/forecast",
        produces = { "application/json" }
    )
    
    ResponseEntity<List<ForecastDataResponseDto>> getForecastData(
        
    );

}
