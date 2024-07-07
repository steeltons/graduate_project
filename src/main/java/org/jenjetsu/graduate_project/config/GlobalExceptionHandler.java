package org.jenjetsu.graduate_project.config;

import lombok.extern.slf4j.*;
import org.jenjetsu.graduate_project.client.model.*;
import org.jenjetsu.graduate_project.exception.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiExceptionDto> handleApiException(ApiException exception) {
        log.error(exception.getMessage(), exception);

        var exceptionDto = new ApiExceptionDto();
        exceptionDto.setCode(exception.getHttpStatus().value());
        exceptionDto.setMessage(exception.getMessage());

        return ResponseEntity.status(exceptionDto.getCode()).body(exceptionDto);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiExceptionDto> handleRuntimeException(RuntimeException exception) {
        log.error(exception.getMessage(), exception);

        var exceptionDto = new ApiExceptionDto();
        exceptionDto.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        exceptionDto.setMessage(exception.getMessage());

        return ResponseEntity.status(exceptionDto.getCode()).body(exceptionDto);
    }
}
