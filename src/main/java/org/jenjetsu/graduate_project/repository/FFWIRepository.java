package org.jenjetsu.graduate_project.repository;

import java.util.*;

import org.jenjetsu.graduate_project.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface FFWIRepository extends JpaRepository<FFWI, UUID> {

    @Query(
        value = """
            SELECT DISTINCT f
            FROM ffwi f
            LEFT OUTER JOIN f.fwiSet
            LEFT OUTER JOIN f.weatherDataParams
            LEFT OUTER JOIN f.precipitationRecords
            """
    )
    public List<FFWI> findAllFetchSubEntities();

    @Query(
        value = """
            SELECT f
            FROM ffwi f
            LEFT JOIN FETCH f.recentForecasts rf
            """
    )
    public List<FFWI> findAllWithForecast();

}
