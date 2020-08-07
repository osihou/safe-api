package com.projectpl.safeapi.service.opinions;

import com.projectpl.safeapi.persistance.entity.Location;
import com.projectpl.safeapi.persistance.entity.Opinion;
import com.projectpl.safeapi.persistance.repository.OpinionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpinionService implements  IOpinionService {

    @Autowired
    private OpinionRepository opinionRepository;

    @Override
    public Location findById(int id) {
        return null;
    }

    @Override
    public Iterable<Opinion> findAll() {
        return opinionRepository.findAll();
    }

    @Override
    public Opinion save(Opinion newOpinion) {
        return opinionRepository.save(newOpinion);
    }
}
