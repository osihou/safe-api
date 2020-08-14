package com.projectpl.safeapi.service.transactions;

import com.projectpl.safeapi.persistance.entity.Location;
import com.projectpl.safeapi.persistance.entity.Opinion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OpinionMapper implements RowMapper<Opinion> {

    @Override
    public Opinion mapRow(ResultSet resultSet, int i) throws SQLException {

        Opinion opinion = new Opinion();

        opinion.setId_score(resultSet.getInt("id_score"));

        opinion.setScore(resultSet.getInt("score"));
        opinion.setCleanliness(resultSet.getInt("cleanliness"));
        opinion.setImprovements(resultSet.getInt("improvements"));
        opinion.setService(resultSet.getInt("service"));
        opinion.setEquipment(resultSet.getInt("equipment"));
        opinion.setConsumables(resultSet.getInt("consumables"));
        opinion.setEndorsement(resultSet.getInt("endorsement"));

        opinion.setLocationKey(resultSet.getInt("location_key"));


        return opinion;
    }
}
