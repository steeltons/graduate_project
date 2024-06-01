--liquibase formatted sql
--changeset Stas Tsvetkov:a0003
CREATE TABLE fire_danger(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);