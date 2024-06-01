package org.jenjetsu.graduate_project.repository;

import java.util.*;

import org.jenjetsu.graduate_project.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface FWIRepository extends JpaRepository<FWI, UUID> {

}
