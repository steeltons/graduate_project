package org.jenjetsu.graduate_project.repository;

import java.util.*;

import org.jenjetsu.graduate_project.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface FFWIRepository extends JpaRepository<FFWI, UUID> {

    @Query(
        value = """
            SELECT f
            FROM ffwi f
            JOIN FETCH f.fwiSet
            JOIN FETCH f.weatherParams
            JOIN FETCH f.precipitationTables
            """
    )
    public List<FFWI> findAllFetchSubEntities();

}
