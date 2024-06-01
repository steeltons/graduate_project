--liquibase formatted sql
--changeset Stas Tsvetkov:a0001
CREATE TABLE weather_data(
    id UUID PRIMARY KEY,
    name VARCHAR(32) NOT NULL UNIQUE
);