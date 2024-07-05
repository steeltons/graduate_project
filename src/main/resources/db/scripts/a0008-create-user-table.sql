--liquibase formatted sql
--changeset Stas Tsvetkov:a0008
CREATE TABLE users(
    id BIGSERIAL PRIMARY KEY,
    login VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(120) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role_id BIGSERIAL NOT NULL REFERENCES project_role(id)
);