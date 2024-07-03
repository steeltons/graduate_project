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
public class FWIServiceIT extends AbstractIntegrationTest {

    @Autowired
    private FWIService fwiService;

    @Test
    void createFwi() {
        var fwi = FWI.builder()
            .name("КПО_Нестерова_1")
            .minValue(new BigDecimal("150"))
            .maxValue(new BigDecimal("450"))
            .ffwi(FFWI.builder()
                .id(UUID.fromString("10825f4d-2265-4c4f-942b-5a1c5a5839c2"))
                .build())
            .fireDanger(FireDanger.builder().id(1L).build())
            .build();

        var result = fwiService.create(fwi);

        assertNotNull(result);
        assertNotNull(result.getId());
    }

    @Test
    void readFwi() {
        var id = UUID.fromString("bdcc3917-c9e0-4f89-b151-52b2f826af69");
        final var name = "КПО_чтение_1";
        final var minValue = new BigDecimal("0.00");
        final var maxValue = new BigDecimal("1000.00");

        var result = fwiService.readById(id);

        assertNotNull(result);
        assertEquals(name, result.getName());
        assertEquals(minValue, result.getMinValue());
        assertEquals(maxValue, result.getMaxValue());
    }

    @Test
    void updateFwi() {
        var fwi = FWI.builder()
            .id(UUID.fromString("c22e8ac1-a7c6-404b-8318-b9330f87d1cc"))
            .name("КПО_Новое имя_1")
            .minValue(new BigDecimal("666.00"))
            .maxValue(new BigDecimal("777.00"))
            .build();

        fwiService.update(fwi);

        var result = fwiService.readById(fwi.getId());

        assertNotNull(result);
        assertEquals(fwi.getName(), result.getName());
        assertEquals(fwi.getMinValue(), result.getMinValue());
        assertEquals(fwi.getMaxValue(), result.getMaxValue());
    }

    @Test
    void deleteFwi() {
        var id = UUID.fromString("ec6c933d-1936-4a35-b4a3-3daafe87264d");

        fwiService.deleteById(id);

        assertThrows(Exception.class, () -> fwiService.readById(id));
    }

}
