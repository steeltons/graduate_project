package org.jenjetsu.graduate_project.controller;

import java.lang.reflect.*;
import java.util.*;

import lombok.*;
import org.jenjetsu.graduate_project.client.api.*;
import org.jenjetsu.graduate_project.client.model.*;
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

    @Override
    public ResponseEntity<Void> apiV1AppEndpointsPost() {
        appService.clearDatabase();
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<List<ForecastDataResponseDto>> getForecastData() {
        var forecastDatas = appService.getForecastData();
        List<ForecastDataResponseDto> dtos = modelMapper.map(forecastDatas, GENERIC_LIST_TYPE);

        return ResponseEntity.ok(dtos);
    }

    // TODO Доделать
    @Override
    public ResponseEntity<List<ForecastMessageDto>> calculateFireDanger(ForecastDataCalculateDto dto) {
        var res = appService.calculateFireDanger(dto);

        return null;
    }

}
