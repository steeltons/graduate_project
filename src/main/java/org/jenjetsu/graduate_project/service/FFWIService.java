package org.jenjetsu.graduate_project.service;

import java.util.*;

import org.jenjetsu.graduate_project.entity.*;

public interface FFWIService extends CrudService<FFWI, UUID> {

    public List<FFWI> findAllFetchSubEntities();

}
