package com.projectpl.safeapi.service.opinions;

import com.projectpl.safeapi.errors.exceptions.LocationNotFoundException;
import com.projectpl.safeapi.persistance.entity.Opinion;
import com.projectpl.safeapi.persistance.repository.OpinionRepository;
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

        return opinionRepository.findByLocationKey(id);
        //return jdbcTemplate.query("SELECT * FROM opinions_table3 where location_key = "+id, new OpinionMapper()).get(0);
    }



    @Override
    public void deleteById(int id) {
        opinionRepository.deleteById(id);
    }

    @Override
    public Opinion updateOpinion(Opinion newOpinion, int id) {
        return opinionRepository.findById(id)
                .map(opinion -> {
                    opinion.setLocationKey(newOpinion.getLocationKey());
                    opinion.setService(newOpinion.getService());
                    opinion.setImprovements(newOpinion.getImprovements());
                    opinion.setEndorsement(newOpinion.getEndorsement());
                    opinion.setConsumables(newOpinion.getConsumables());
                    opinion.setEquipment(newOpinion.getEquipment());
                    opinion.setScore(newOpinion.getScore());
                    opinion.setCleanliness(newOpinion.getCleanliness());

                    return opinionRepository.save(opinion);

                })

                .orElseGet( () ->{
                    newOpinion.setId_score(id);
                    opinionRepository.save(newOpinion);
                    return null;
                });
    }
}
