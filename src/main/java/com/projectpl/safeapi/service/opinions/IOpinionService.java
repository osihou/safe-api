package com.projectpl.safeapi.service.opinions;

import com.projectpl.safeapi.persistance.entity.Location;
import com.projectpl.safeapi.persistance.entity.Opinion;

public interface IOpinionService {
    Opinion findById(int id);

    Iterable<Opinion> findAll();

    Opinion save(Opinion newOpinion);

    Opinion findByLocationKey(int id);

    void deleteById(int id);
}
