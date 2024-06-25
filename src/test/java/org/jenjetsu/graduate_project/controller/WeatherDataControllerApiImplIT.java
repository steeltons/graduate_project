package org.jenjetsu.graduate_project.controller;

import java.util.*;

import lombok.*;
import org.jenjetsu.graduate_project.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;
import org.springframework.web.util.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.*;

@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WeatherDataControllerApiImplIT extends AbstractIntegrationTest {

    private static final String PATH = "/api/v1/weather-data";

    @Autowired
    private MockMvc mockMvc;

    @Test
    @SneakyThrows
    void readAllTestSuccess() {
        mockMvc.perform(get(PATH))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    void readByIdTest() {
        final var id = UUID.fromString("51de31d9-27d2-4085-a723-8a6e4b58e7fc");
        var requestPath = PATH + '/' + id;

        mockMvc.perform(get(requestPath))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(id.toString()))
            .andExpect(jsonPath("$.name").value("Тестовое имя для контроллера"));
    }

    @Test
    @SneakyThrows
    void updateWeatherData() {
        final var id = UUID.fromString("c7d351d0-2b5b-4a75-8bf3-9e46ebbc8ab1");
        final var anotherName = "Имя контроллера";

        mockMvc.perform(patch(PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                        \"id\" : \"c7d351d0-2b5b-4a75-8bf3-9e46ebbc8ab1\", 
                        \"name\" : \"Имя контроллера\"
                    }
                    """))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(id.toString()))
            .andExpect(jsonPath("$.name").value(anotherName));
    }

}
