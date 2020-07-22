package com.projectpl.safeapi.service.opinions;

import com.projectpl.safeapi.entity.Location;
import com.projectpl.safeapi.exception.LocationNotFoundException;
import com.projectpl.safeapi.repository.OpinionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OpinionService implements  IOpinionService {

    @Autowired
    private OpinionRepository opinionRepository;

    @Override
    public Location findById(int id) {
        return null;
    }
}
