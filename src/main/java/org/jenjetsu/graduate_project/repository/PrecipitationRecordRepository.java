package org.jenjetsu.graduate_project.repository;

import java.util.*;

import org.jenjetsu.graduate_project.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface PrecipitationRecordRepository extends JpaRepository<PrecipitationTable, Long> {

    @Query(
        value = """
            SELECT pt
            FROM precipitation_table pt
            LEFT JOIN FETCH pt.ffwi
            """
    )
    public List<PrecipitationTable> readAllFetchEverything();

}
