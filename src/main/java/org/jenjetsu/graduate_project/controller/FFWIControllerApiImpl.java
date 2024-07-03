package org.jenjetsu.graduate_project.controller;

import java.lang.reflect.*;
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
public class FFWIControllerApiImpl implements FfwiControllerApi {

    private static final Type GENERIC_LIST_TYPE = new TypeToken<List<FFWIResponseDto>>() {
    }.getType();

    private final FFWIService ffwiService;

    private final ModelMapper modelMapper;

    @Override
    public ResponseEntity<Void> createFfwi(FFWICreateRequestDto dto) {
        FFWI ffwi = modelMapper.map(dto, FFWI.class);

        ffwiService.create(ffwi);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public ResponseEntity<Void> deleteFfwiById(UUID id) {
        ffwiService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public ResponseEntity<List<FFWIResponseDto>> getAllFfwi() {
        var ffwis = ffwiService.findAllFetchSubEntities();

        List<FFWIResponseDto> dtos = modelMapper.map(ffwis, GENERIC_LIST_TYPE);

        return ResponseEntity.ok(dtos);
    }

    @Override
    public ResponseEntity<FFWIResponseDto> getFfwiById(UUID id) {
        var ffwi = ffwiService.readById(id);

        var dto = modelMapper.map(ffwi, FFWIResponseDto.class);

        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<Void> patchFfwi(FFWIResponseDto ffWIResponseDto) {
        var newFfwi = modelMapper.map(ffWIResponseDto, FFWI.class);

        ffwiService.update(newFfwi);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
