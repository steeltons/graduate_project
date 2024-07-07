--liquibase formatted sql
--changeset Stas Tsvetkov:a0012
ALTER TABLE weather_data
ADD COLUMN description VARCHAR(1000);