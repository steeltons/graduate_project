package org.jenjetsu.graduate_project.controller;

import java.util.*;

import lombok.*;
import org.jenjetsu.graduate_project.client.api.*;
import org.jenjetsu.graduate_project.client.model.*;
import org.jenjetsu.graduate_project.entity.*;
import org.jenjetsu.graduate_project.service.*;
import org.modelmapper.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class WeatherDataControllerApiImpl implements WeatherDataControllerApi {

    private final WeatherDataService weatherDataService;

    private final ModelMapper modelMapper;

    @Override
    public ResponseEntity<WeatherDataDto> createWeatherData(CreateWeaterDataDto createDto) {
        var rawWeatherData = modelMapper.map(createDto, WeatherData.class);

        var persistedData = weatherDataService.create(rawWeatherData);

        var returnDto = modelMapper.map(persistedData, WeatherDataDto.class);

        return ResponseEntity.ok(returnDto);
    }

    @Override
    public ResponseEntity<Void> deleteWeatherDataById(UUID id) {
        weatherDataService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public ResponseEntity<WeatherDataDto> getWeatherDataById(UUID id) {
        var weatherData = weatherDataService.readById(id);

        var returnDto = modelMapper.map(weatherData, WeatherDataDto.class);

        return ResponseEntity.ok(returnDto);
    }

    @Override
    public ResponseEntity<List<WeatherDataDto>> getWeatherDatas() {
        var weatherDatas = weatherDataService.readAll();

        var genericListType = new TypeToken<List<WeatherDataDto>>(){}.getType();

        List<WeatherDataDto> returnDtos = modelMapper.map(weatherDatas, genericListType);

        return ResponseEntity.ok(returnDtos);
    }

    @Override
    public ResponseEntity<WeatherDataDto> patchWeatherData(WeatherDataDto weatherDataDto) {
        var newEntity = modelMapper.map(weatherDataDto, WeatherData.class);

        var updatedEntity = weatherDataService.update(newEntity);

        var returnDto = modelMapper.map(updatedEntity, WeatherDataDto.class);

        return ResponseEntity.ok(returnDto);
    }

}
