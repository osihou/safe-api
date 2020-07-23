package com.projectpl.safeapi.service.opinions;

import com.projectpl.safeapi.entity.Location;
import com.projectpl.safeapi.entity.Opinion;
import com.projectpl.safeapi.repository.OpinionRepository;
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
