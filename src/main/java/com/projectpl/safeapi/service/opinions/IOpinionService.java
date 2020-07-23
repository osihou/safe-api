package com.projectpl.safeapi.service.opinions;

import com.projectpl.safeapi.entity.Location;
import com.projectpl.safeapi.entity.Opinion;

public interface IOpinionService {
    Location findById(int id);

    Iterable<Opinion> findAll();

    Opinion save(Opinion newOpinion);
}
