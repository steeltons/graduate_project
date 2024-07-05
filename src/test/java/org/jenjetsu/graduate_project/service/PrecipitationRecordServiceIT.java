package org.jenjetsu.graduate_project.service;

import java.math.*;
import java.util.*;

import org.jenjetsu.graduate_project.*;
import org.jenjetsu.graduate_project.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PrecipitationRecordServiceIT extends AbstractIntegrationTest {

    @Autowired
    private PrecipitationRecordService precipitationService;

    @Test
    void createEntity() {
        var record = PrecipitationTable.builder()
            .minValue(new BigDecimal("150.00"))
            .maxValue(new BigDecimal("500.00"))
            .value(15)
            .ffwi(FFWI.builder()
                .id(UUID.fromString("10825f4d-2265-4c4f-942b-5a1c5a5839c2"))
                .build())
            .build();

        var result = precipitationService.create(record);

        assertNotNull(record.getId());
        assertEquals(record.getMinValue(), result.getMinValue());
        assertEquals(record.getMaxValue(), result.getMaxValue());
        assertEquals(record.getValue(), result.getValue());
    }

    @Test
    void readEntity() {
        final var id = 2L;
        final var minValue = new BigDecimal("0.00");
        final var maxValue = new BigDecimal("4000.00");
        final var value = 4;

        var result = precipitationService.readById(id);

        assertEquals(minValue, result.getMinValue());
        assertEquals(maxValue, result.getMaxValue());
        assertEquals(value, result.getValue());
    }

    @Test
    void updateEntity() {
        var newRecord = PrecipitationTable.builder()
            .id(3L)
            .minValue(new BigDecimal("666.66"))
            .maxValue(new BigDecimal("777.77"))
            .value(42)
            .build();

        var result = precipitationService.update(newRecord);

        assertEquals(newRecord.getMinValue(), result.getMinValue());
        assertEquals(newRecord.getMaxValue(), result.getMaxValue());
        assertEquals(newRecord.getValue(), result.getValue());
    }

    @Test
    void deleteEntity() {
        final var id = 4L;

        assertDoesNotThrow(() -> precipitationService.deleteById(id));
        assertThrows(Exception.class, () -> precipitationService.readById(id));
    }

}
