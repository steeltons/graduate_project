package org.jenjetsu.graduate_project.service.impl;

import java.math.*;
import java.time.*;
import java.util.*;
import java.util.stream.*;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.jenjetsu.graduate_project.client.model.*;
import org.jenjetsu.graduate_project.entity.*;
import org.jenjetsu.graduate_project.model.*;
import org.jenjetsu.graduate_project.repository.*;
import org.jenjetsu.graduate_project.service.*;
import org.jenjetsu.graduate_project.service.impl.component.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppServiceImpl implements AppService {

    private static final UUID FOR_ALL_FFWI_ID = UUID.randomUUID();

    private final EntityManager entityManager;

    private final WeatherDateRepository weatherRep;

    private final RecentForecastRepository forecastRep;

    private final FFWIRepository ffwiRep;

    private final ForecastCalculatorComponent forecastComponent;

    @Override
    @Transactional
    public void clearDatabase() {
        log.info("Очистка базы знаний");
        entityManager.createNativeQuery("DELETE FROM precipitation_table").executeUpdate();
        log.info("... проиден этап очистки таблицы precipitation_table");
        entityManager.createNativeQuery("DELETE FROM fwi").executeUpdate();
        log.info("... проиден этап очистки таблицы fwi, далее очиста таблицы ffwi_parameter");
        entityManager.createNativeQuery("DELETE FROM ffwi_parameter").executeUpdate();
        log.info("... проиден этап очистки таблицы ffwi_parameter, далее forecast_weather_param");
        entityManager.createNativeQuery("DELETE FROM forecast_weather_param").executeUpdate();
        log.info("... проиден этап очистки таблицы recent_forecast_param, далее recent_forecast");
        entityManager.createNativeQuery("DELETE FROM recent_forecast").executeUpdate();
        log.info("... проиден этап очистки таблицы recent_forecast, далее ffwi");
        entityManager.createNativeQuery("DELETE FROM ffwi").executeUpdate();
        log.info("База данных была успешно очищена");
    }

    @Override
    public List<ForecastData> getForecastData() {
        var forecasts = forecastRep.getLatestForFFWI();

        var result = forecasts.stream()
            .map(this::mapRecentForecast)
            .collect(Collectors.toCollection(ArrayList::new));

        var standardResult = ForecastData.builder()
            .previousComplexDate(LocalDate.of(2020, 1, 1))
            .previousComplexIndicator(BigDecimal.ZERO)
            .ffwiId(FOR_ALL_FFWI_ID)
            .ffwiName("По всем параметрам")
            .weatherDataParams(weatherRep.findAll().stream()
                .map(param -> FFWIParameter.builder()
                    .weatherData(param)
                    .weatherName(param.getName())
                    .build())
                .toList())
            .build();

        result.add(standardResult);

        return result;
    }

    @Override
    public List<ForecastMessageDto> calculateFireDanger(ForecastDataCalculateDto calculateDto) {
        var ffwiList = ffwiRep.findAllFetchSubEntities();
        var forecastMessages = new ArrayList<ForecastMessageDto>();
        ffwiList.stream()
            .filter(ffwi -> calculateDto.getFfwiId().equals(FOR_ALL_FFWI_ID)
                            || ffwi.getId().equals(calculateDto.getFfwiId()))
            .forEach(ffwi -> {
                var result = forecastComponent.calculateForecast(calculateDto, ffwi);
                var forecastMessage = new ForecastMessageDto();
            });

        return List.of();
    }

    private ForecastData mapRecentForecast(RecentForecast forecast) {
        var data = ForecastData.builder()
            .previousComplexDate(forecast.getForecastTime().toLocalDate())
            .previousComplexIndicator(forecast.getComplexIndicator())
            .ffwiId(forecast.getFfwi().getId())
            .ffwiName(forecast.getFfwi().getName())
            .weatherDataParams(forecast.getFfwi().getWeatherDataParams().stream().toList())
            .build();

        return data;
    }

}
