package org.jenjetsu.graduate_project.service.impl;

import java.util.*;

import org.jenjetsu.graduate_project.entity.*;
import org.jenjetsu.graduate_project.service.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
public class WeatherDataServiceImpl extends SimpleJpaService<WeatherData, UUID>
                                    implements WeatherDataService {

    public WeatherDataServiceImpl(JpaRepository<WeatherData, UUID> jpaRepository) {
        super(WeatherData.class, jpaRepository);
    }

    @Override
    public WeatherData update(WeatherData newEntity) {
        var targetWeather = readById(newEntity.getId());

        if (newEntity.getName() != null && !newEntity.getName().equals(targetWeather.getName())) {
            targetWeather.setName(newEntity.getName());
        }

        return super.update(targetWeather);
    }

}
