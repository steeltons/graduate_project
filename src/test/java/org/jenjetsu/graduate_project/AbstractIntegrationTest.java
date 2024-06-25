package org.jenjetsu.graduate_project;

import org.springframework.test.context.*;
import org.testcontainers.containers.*;
import org.testcontainers.junit.jupiter.*;

@Testcontainers
public class AbstractIntegrationTest {

    public static final PostgreSQLContainer<?> POSTGRES;

    static {
        POSTGRES = new PostgreSQLContainer<>("postgres:14-alpine")
            .withDatabaseName("npcb")
            .withUsername("npcb")
            .withPassword("npcb");
        POSTGRES.start();
    }

    @DynamicPropertySource
    static void jdbcProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", () -> POSTGRES.getJdbcUrl());
        registry.add("spring.datasource.username", POSTGRES::getUsername);
        registry.add("spring.datasource.password", POSTGRES::getPassword);
        registry.add("logging.level.org.hibernate.SQL", () -> "debug");
        registry.add("logging.level.org.hibernate.type.descriptor.sql", () -> "trace");
    }

}


