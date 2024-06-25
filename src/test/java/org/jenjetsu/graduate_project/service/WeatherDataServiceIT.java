package org.jenjetsu.graduate_project.service;

import java.util.*;

import org.jenjetsu.graduate_project.*;
import org.jenjetsu.graduate_project.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class WeatherDataServiceIT extends AbstractIntegrationTest {

    @Autowired
    private WeatherDataService weatherDataService;

    @Test
    void createTest() {
        var weatherData = WeatherData.builder()
            .name("Температура воздуха")
            .build();

        var persistedEntity = weatherDataService.create(weatherData);

        assertNotNull(persistedEntity.getId());
        assertEquals(weatherData.getName(), persistedEntity.getName());
    }

    @Test
    void readByIdTest() {
        final var name = "Тестовое название 1";
        final var id = UUID.fromString("6384666f-d9dc-48b8-b8d2-31baef06b271");

        var actual = weatherDataService.readById(id);

        assertNotNull(actual);
        assertAll(
            () -> assertEquals(name, actual.getName()),
            () -> assertEquals(id, actual.getId())
        );
    }

    @Test
    void readAllTest() {
        var actualList = weatherDataService.readAll();

        assertNotNull(actualList);
        assertFalse(actualList.isEmpty());
    }

    @Test
    void deleteByIdTest() {
        final var name = "Тестовое название 3";
        final var id = UUID.fromString("d1eb4634-e738-48f6-a9cd-f262f2f1ecc3");

        var removedEntity = weatherDataService.deleteById(id);

        assertNotNull(removedEntity);
        assertAll(
            () -> assertEquals(name, removedEntity.getName()),
            () -> assertEquals(id, removedEntity.getId())
        );

        assertThrows(Exception.class, () -> weatherDataService.readById(id));
    }

    @Test
    void updateTest() {
        final var name = "Изменённое имя";
        final var id = UUID.fromString("c7d351d0-2b5b-4a75-8bf3-9e46ebbc8ab1");
        var newEntity = WeatherData.builder().name(name).id(id).build();

        weatherDataService.update(newEntity);

        var actual = weatherDataService.readById(id);

        assertEquals(id, actual.getId());
        assertEquals(name, actual.getName());
    }

}
