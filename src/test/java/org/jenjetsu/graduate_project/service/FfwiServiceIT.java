package org.jenjetsu.graduate_project.service;

import java.util.*;

import org.jenjetsu.graduate_project.*;
import org.jenjetsu.graduate_project.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FfwiServiceIT extends AbstractIntegrationTest {

    @Autowired
    private FFWIService ffwiService;

    @Test
    void createFfwi() {
        var ffwi = FFWI.builder()
            .name("КППО_новое")
            .formula("$T_0 * $T_d")
            .build();

        var res = ffwiService.create(ffwi);

        assertNotNull(res);
        assertNotNull(res.getId());
    }

    @Test
    void readFfwi() {
        final var id = UUID.fromString("10825f4d-2265-4c4f-942b-5a1c5a5839c2");
        final var name = "КППО_для_чтения";
        final var formula = "$T_0 * ($T_0 - $T_d)";

        var result = ffwiService.readById(id);

        assertNotNull(result);
        assertEquals(name, result.getName());
        assertEquals(formula, result.getFormula());
    }

    @Test
    void deleteById() {
        final var id = UUID.fromString("b6c057e0-21bb-4656-9625-83dac3eb3af8");

        var result = ffwiService.deleteById(id);

        assertThrows(Exception.class, () -> ffwiService.readById(id));
    }

    @Test
    void updateEntity() {
        final var newEntity = FFWI.builder()
            .id(UUID.fromString("64fa94d4-b1e3-48ef-9c66-49edb1a9709a"))
            .name("Новое имя")
            .formula("Новая формула")
            .build();

        ffwiService.update(newEntity);

        var result = ffwiService.readById(newEntity.getId());

        assertEquals(newEntity.getName(), result.getName());
        assertEquals(newEntity.getFormula(), result.getFormula());
    }

}
