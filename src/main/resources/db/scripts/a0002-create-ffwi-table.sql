--liquibase formatted sql
--changeset Stas Tsvetkov:a0002
CREATE TABLE ffwi(
    id UUID PRIMARY KEY,
    name VARCHAR(32) NOT NULL UNIQUE,
    formula VARCHAR(512) NOT NULL
);