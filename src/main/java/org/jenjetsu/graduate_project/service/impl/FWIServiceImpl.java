package org.jenjetsu.graduate_project.service.impl;

import java.util.*;

import org.jenjetsu.graduate_project.entity.*;
import org.jenjetsu.graduate_project.repository.*;
import org.jenjetsu.graduate_project.service.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Service
public class FWIServiceImpl extends SimpleJpaService<FWI, UUID>
                            implements FWIService {

    private final FWIRepository fwiRep;

    public FWIServiceImpl(FWIRepository jpaRepository) {
        super(FWI.class, jpaRepository);
        this.fwiRep = jpaRepository;
    }

    @Override
    public FWI update(FWI newEntity) {
        var old = super.readById(newEntity.getId());

        if (newEntity.getName() != null && !newEntity.getName().equals(old.getName())) {
            old.setName(newEntity.getName());
        }
        if (newEntity.getMinValue() != null && !newEntity.getMinValue().equals(old.getMinValue())) {
            old.setMinValue(newEntity.getMinValue());
        }
        if (newEntity.getMaxValue() != null && !newEntity.getMaxValue().equals(old.getMaxValue())) {
            old.setMaxValue(newEntity.getMaxValue());
        }

        return super.update(old);
    }

    @Override
    public List<FWI> findAllFetchEverything() {
        return fwiRep.findAllFetchEverything();
    }

}
