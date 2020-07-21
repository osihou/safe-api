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
        location.setCity(resultSet.getString("city"));
        location.setStreet(resultSet.getString("street"));
        location.setNum(resultSet.getString("num"));
        location.setPostal_code(resultSet.getString("postal_code"));
        location.setType(resultSet.getString("type"));

        location.setSecurity_rate(resultSet.getDouble("security_rat"));
        location.setSTAFF_WEARING_MASKS(resultSet.getDouble("STAFF_WEARING_MASKS"));
        location.setDIST_KEPT(resultSet.getDouble("DIST_KEPT"));
        location.setOther(resultSet.getDouble("other"));

        location.setOPEN(resultSet.getBoolean("IsOPEN"));

        location.setLatitude(resultSet.getDouble("latitude"));
        location.setLongitude(resultSet.getDouble("longitude"));

        return location;
    }
}
