package org.jenjetsu.graduate_project.service.impl;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.jenjetsu.graduate_project.service.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppServiceImpl implements AppService {

    private final EntityManager entityManager;

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

}
