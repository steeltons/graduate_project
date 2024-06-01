--liquibase formatted sql
--changeset Stas Tsvetkov:a0004
CREATE TABLE fwi(
    id UUID PRIMARY KEY,
    name VARCHAR(32) NOT NULL UNIQUE,
    min_value NUMERIC(19, 2) NOT NULL,
    max_value NUMERIC(19, 2) NOT NULL,
    ffwi_id UUID NOT NULL,
    fire_danger_id BIGSERIAL NOT NULL,

    FOREIGN KEY(ffwi_id) REFERENCES ffwi(id),
    FOREIGN KEY(fire_danger_id) REFERENCES fire_danger(id)
);