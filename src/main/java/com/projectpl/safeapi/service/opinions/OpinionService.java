package com.projectpl.safeapi.service.opinions;

import com.projectpl.safeapi.errors.exceptions.LocationNotFoundException;
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
    public Opinion findById(int id) {
        return opinionRepository.findById(id).orElseThrow(() -> new LocationNotFoundException(id));
    }

    @Override
    public Iterable<Opinion> findAll() {
        return opinionRepository.findAll();
    }

    @Override
    public Opinion save(Opinion newOpinion) {
        return opinionRepository.save(newOpinion);
    }

    @Override
    public Opinion findByLocationKey(int id) {
        return opinionRepository.findByLocationKey(id);
    }

    @Override
    public void deleteById(int id) {
        opinionRepository.deleteById(id);
    }
}
