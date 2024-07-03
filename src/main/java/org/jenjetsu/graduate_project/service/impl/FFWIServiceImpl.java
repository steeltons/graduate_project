package org.jenjetsu.graduate_project.service.impl;

import java.util.*;

import org.jenjetsu.graduate_project.entity.*;
import org.jenjetsu.graduate_project.repository.*;
import org.jenjetsu.graduate_project.service.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Service
public class FFWIServiceImpl extends SimpleJpaService<FFWI, UUID>
    implements FFWIService {

    private final FFWIRepository ffwiRep;

    public FFWIServiceImpl(
        FFWIRepository ffwiRep
    ) {
        super(FFWI.class, ffwiRep);
        this.ffwiRep = ffwiRep;
    }

    @Override
    public List<FFWI> findAllFetchSubEntities() {
        var ffwis = ffwiRep.findAllFetchSubEntities();

        return ffwis;
    }

    @Override
    public FFWI update(FFWI newEntity) {
        var oldEntity = super.readById(newEntity.getId());

        if (newEntity.getName() != null && !newEntity.getName().equals(oldEntity.getName())) {
            oldEntity.setName(newEntity.getName());
        }

        if (newEntity.getFormula() != null && !newEntity.getFormula()
            .equals(oldEntity.getFormula())) {
            oldEntity.setFormula(newEntity.getFormula());
        }

        return super.update(oldEntity);
    }

}
