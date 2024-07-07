package org.jenjetsu.graduate_project.controller;

import java.lang.reflect.*;
import java.util.*;

import lombok.*;
import org.jenjetsu.graduate_project.client.api.*;
import org.jenjetsu.graduate_project.client.model.*;
import org.jenjetsu.graduate_project.entity.formula.*;
import org.jenjetsu.graduate_project.model.*;
import org.jenjetsu.graduate_project.service.*;
import org.modelmapper.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AppControllerApiImpl implements AppControllerApi {

    private static final Type GENERIC_LIST_TYPE
        = new TypeToken<List<ForecastDataResponseDto>>(){}.getType();

    private final AppService appService;

    private final ModelMapper modelMapper;

    private final FormulaLexerService lexerService;

    private final FormulaParserService parserService;

    @Override
    public ResponseEntity<Void> apiV1AppEndpointsPost() {
        appService.clearDatabase();
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<List<ForecastDataResponseDto>> getForecastData() {
        var forecastDatas = appService.getForecastData();
        List<ForecastDataResponseDto> dtos = forecastDatas.stream()
            .map(forecast -> {
                var dto = new ForecastDataResponseDto();
                dto.setFfwiId(forecast.getFfwiId());
                dto.setFfwiName(forecast.getFfwiName());
                dto.setPreviousComplexIndicator(forecast.getPreviousComplexIndicator());
                dto.setPreviousComplexDate(forecast.getPreviousComplexDate());
                dto.setWeatherDataParams(forecast.getWeatherDataParams().stream()
                    .map(param -> {
                        var paramDto = new FFWIWeatherParamDto();
                        paramDto.setWeatherDataId(param.getWeatherData().getId().toString());
                        paramDto.setWeatherName(param.getWeatherName());
                        paramDto.setFormulaParameter(param.getFormulaParameter());
                        return paramDto;
                    }).toList());

                return dto;
            }).toList();


        return ResponseEntity.ok(dtos);
    }

    // TODO Доделать
    @Override
    public ResponseEntity<List<ForecastMessageDto>> calculateFireDanger(ForecastDataCalculateDto dto) {
        var res = appService.calculateFireDanger(dto);

        return ResponseEntity.ok(res);
    }



    @Override
    public ResponseEntity<List<String>> checkFormula(CheckFormulaDto checkFormulaDto) {
        try {
            var lexems = lexerService.parseFormula(checkFormulaDto.getFormula());
            var node = parserService.parse(lexems);
            var variables = lexems.stream()
                .filter(lexem -> lexem.getToken().equals(FormulaToken.VARIABLE))
                .map(FormulaLexem::getText)
                .toList();
            return ResponseEntity.ok(variables);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
