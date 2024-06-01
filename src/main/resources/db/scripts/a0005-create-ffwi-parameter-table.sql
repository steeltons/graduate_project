--liquibase formatted sql
--changeset Stas Tsvetkov:a0005
CREATE TABLE ffwi_parameter(
    id BIGSERIAL PRIMARY KEY,
    formula_parameter VARCHAR(16) NOT NULL,
    weather_name VARCHAR(255) NOT NULL,
    weather_data_id UUID NOT NULL,
    ffwi_id UUID NOT NULL,

    FOREIGN KEY(weather_data_id) REFERENCES weather_data(id),
    FOREIGN KEY(ffwi_id) REFERENCES ffwi(id)
);