package org.jenjetsu.graduate_project.repository;

import java.util.*;

import org.jenjetsu.graduate_project.entity.*;
import org.springframework.data.jpa.repository.*;

public interface RecentForecastRepository extends JpaRepository<RecentForecast, Long> {

    @Query(
        value = """
            SELECT rf
            FROM recent_forecast rf
            LEFT JOIN FETCH rf.ffwi f
            LEFT JOIN FETCH f.weatherDataParams
            WHERE rf.forecastTime = (
                SELECT MAX(rf1.forecastTime) FROM recent_forecast rf1
                WHERE rf1.ffwi.id = rf.ffwi.id
            )
            """
    )
    public List<RecentForecast> getLatestForFFWI();
}
