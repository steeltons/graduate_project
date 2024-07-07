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
public class PrecipitationRecordControllerApiImpl implements PrecipitationRecordControllerApi {

    private static final Type GENERIC_LIST_TYPE
        = new TypeToken<List<PrecipitationRecordResponseDto>>() {
    }.getType();

    private final PrecipitationRecordService precipitationService;

    private final ModelMapper modelMapper;

    @Override
    public ResponseEntity<PrecipitationRecordResponseDto> addPrecipitationRecord(
        PrecipitationRecordCreateDto dto
    ) {
        var rawRecord = modelMapper.map(dto, PrecipitationTable.class);
        rawRecord.setFfwi(FFWI.builder().id(dto.getFfwiId()).build());
        var result = precipitationService.create(rawRecord);
        var responseDto = modelMapper.map(result, PrecipitationRecordResponseDto.class);

        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<Void> deleteRecord(Long id) {
        precipitationService.deleteById(id);

        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<List<PrecipitationRecordResponseDto>> getPrecipitationRecords() {
        var records = precipitationService.readAllFetchFfwi();
        List<PrecipitationRecordResponseDto> dtos = modelMapper.map(records, GENERIC_LIST_TYPE);

        return ResponseEntity.ok(dtos);
    }

    @Override
    public ResponseEntity<PrecipitationRecordResponseDto> getRecordById(Long id) {
        var record = precipitationService.readById(id);
        var dto = modelMapper.map(record, PrecipitationRecordResponseDto.class);

        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<PrecipitationRecordResponseDto> patchRecord(PrecipitationRecordUpdateDto dto) {
        var newEntity = modelMapper.map(dto, PrecipitationTable.class);
        var updatedEntity = precipitationService.update(newEntity);
        var responseDto = modelMapper.map(updatedEntity, PrecipitationRecordResponseDto.class);

        return ResponseEntity.ok(responseDto);
    }

}
