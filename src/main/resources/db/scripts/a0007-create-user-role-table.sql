--liquibase formatted sql
--changeset Stas Tsvetkov:a0006
CREATE TABLE project_role(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);