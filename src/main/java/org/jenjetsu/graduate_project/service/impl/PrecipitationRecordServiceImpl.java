package org.jenjetsu.graduate_project.service.impl;

import java.util.*;

import org.jenjetsu.graduate_project.entity.*;
import org.jenjetsu.graduate_project.repository.*;
import org.jenjetsu.graduate_project.service.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Service
public class PrecipitationRecordServiceImpl extends SimpleJpaService<PrecipitationTable, Long>
                                            implements PrecipitationRecordService {

    private final PrecipitationRecordRepository precipitationRep;

    public PrecipitationRecordServiceImpl(PrecipitationRecordRepository precipitationRep) {
        super(PrecipitationTable.class, precipitationRep);
        this.precipitationRep = precipitationRep;
    }

    @Override
    public PrecipitationTable update(PrecipitationTable newEntity) {
        var oldEntity = super.readById(newEntity.getId());
        if (newEntity.getMaxValue() != null) {
            oldEntity.setMinValue(newEntity.getMinValue());
        }
        if (newEntity.getMaxValue() != null) {
            oldEntity.setMaxValue(newEntity.getMaxValue());
        }
        if (newEntity.getValue() != null) {
            oldEntity.setValue(newEntity.getValue());
        }

        return super.update(oldEntity);
    }

    @Override
    public List<PrecipitationTable> readAllFetchFfwi() {
        return precipitationRep.readAllFetchEverything();
    }

}
