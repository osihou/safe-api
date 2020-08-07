package com.projectpl.safeapi.service.opinions;

import com.projectpl.safeapi.persistance.entity.Location;
import com.projectpl.safeapi.persistance.entity.Opinion;

public interface IOpinionService {
    Location findById(int id);

    Iterable<Opinion> findAll();

    Opinion save(Opinion newOpinion);
}
