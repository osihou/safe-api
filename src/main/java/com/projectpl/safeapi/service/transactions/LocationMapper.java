package com.projectpl.safeapi.service.transactions;

import com.projectpl.safeapi.persistance.entity.Location;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class LocationMapper implements RowMapper<Location> {

    @Override
    public Location mapRow(ResultSet resultSet, int i) throws SQLException {
        //Location location = new Location();



        //return location;

        return null;
    }

}
