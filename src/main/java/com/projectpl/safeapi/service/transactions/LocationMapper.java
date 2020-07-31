package com.projectpl.safeapi.service.transactions;

import com.projectpl.safeapi.entity.Location;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class LocationMapper implements RowMapper<Location> {

    @Override
    public Location mapRow(ResultSet resultSet, int i) throws SQLException {
        Location location = new Location();

        location.setId(resultSet.getInt("id"));

        location.setName(resultSet.getString("name"));
        location.setStreet(resultSet.getString("street"));
        location.setCity(resultSet.getString("city"));
        location.setCountry(resultSet.getString("country"));

        location.setNumber(resultSet.getString("number"));
        location.setPostal_code(resultSet.getString("postal_code"));
        location.setType(resultSet.getString("type"));

        location.setIs_open(resultSet.getString("is_open"));

        location.setLatitude(resultSet.getDouble("latitude"));
        location.setLongitude(resultSet.getDouble("longitude"));

        return location;
    }

}
