package org.jenjetsu.graduate_project.service;

import java.util.*;

import org.jenjetsu.graduate_project.entity.*;

public interface PrecipitationRecordService extends CrudService<PrecipitationTable, Long> {

    public List<PrecipitationTable> readAllFetchFfwi();

}
