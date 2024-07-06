--liquibase formatted sql
--changeset Stas Tsvetkov:a0010
CREATE TABLE forecast_weather_param(
    id BIGSERIAL PRIMARY KEY,
    forecast_id BIGSERIAL NOT NULL REFERENCES recent_forecast(id),
    weather_data_id UUID NOT NULL REFERENCES weather_data(id),
    value VARCHAR(100) NOT NULL
);