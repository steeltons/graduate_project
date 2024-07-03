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
public class FWIControllerApiImpl implements FwiControllerApi {

    private final FWIService fwiService;

    private final ModelMapper modelMapper;

    @Override
    public ResponseEntity<Void> createFwi(FFWICreateDto ffWICreateDto) {
        var rawFwi = modelMapper.map(ffWICreateDto, FWI.class);

        fwiService.create(rawFwi);

        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> deleteById(UUID id) {
        fwiService.deleteById(id);

        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<List<FWIResponseDto>> getAll() {
        var fwis = fwiService.readAll();

        List dtos = modelMapper.map(fwis, new TypeToken<List<FWIResponseDto>>(){}.getType());

        return ResponseEntity.ok(dtos);
    }

    @Override
    public ResponseEntity<FWIResponseDto> getById(UUID id) {
        var fwi = fwiService.readById(id);

        var dto = modelMapper.map(fwi, FWIResponseDto.class);

        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<Void> updateFwi(FWIResponseDto fwIResponseDto) {
        var fwi = modelMapper.map(fwIResponseDto, FWI.class);

        fwiService.update(fwi);

        return ResponseEntity.ok(null);
    }

}
