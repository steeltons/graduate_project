--liquibase formatted sql
--changeset Stas Tsvetkov:a0009
CREATE TABLE recent_forecast(
    id BIGSERIAL PRIMARY KEY,
    ffwi_id UUID NOT NULL REFERENCES ffwi(id),
    complex_indicator NUMERIC NOT NULL,
    forecast_time TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);