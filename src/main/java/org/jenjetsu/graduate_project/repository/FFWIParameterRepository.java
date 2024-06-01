package org.jenjetsu.graduate_project.repository;

import org.jenjetsu.graduate_project.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface FFWIParameterRepository extends JpaRepository<FFWIParameter, Long> {

}
