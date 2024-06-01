--liquibase formatted sql
--changeset Stas Tsvetkov:a0006
CREATE TABLE precipitation_table(
    id BIGSERIAL PRIMARY KEY,
    min_value NUMERIC(19, 2) NOT NULL CHECK(min_value >= 0.0),
    max_value NUMERIC(19, 2) NOT NULL CHECK(max_value >= 0.0),
    value INTEGER NOT NULL CHECK(value >= 0),
    ffwi_id UUID NOT NULL,

    FOREIGN KEY(ffwi_id) REFERENCES ffwi(id)
);