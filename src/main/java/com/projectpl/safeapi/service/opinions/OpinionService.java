package com.projectpl.safeapi.service.opinions;

import com.projectpl.safeapi.errors.exceptions.LocationNotFoundException;
import com.projectpl.safeapi.persistance.entity.Location;
import com.projectpl.safeapi.persistance.entity.Opinion;
import com.projectpl.safeapi.persistance.repository.OpinionRepository;
import com.projectpl.safeapi.service.transactions.OpinionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class OpinionService implements  IOpinionService {


    @Autowired
    private JdbcTemplate jdbcTemplate;

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
        return jdbcTemplate.query("SELECT * FROM opinions_table3 where location_key = "+id, new OpinionMapper()).get(0);
    }



    @Override
    public void deleteById(int id) {
        opinionRepository.deleteById(id);
    }
}
