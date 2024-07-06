package org.jenjetsu.graduate_project.service;

import java.util.*;

import org.jenjetsu.graduate_project.entity.*;

public interface FWIService extends CrudService<FWI, UUID> {

    public List<FWI> findAllFetchEverything();

}
