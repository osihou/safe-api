package com.projectpl.safeapi.service.transactions;

import com.projectpl.safeapi.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionService {

    private final String TABLE_LOCATION_NAME = "locations_table";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void removeAll(){
        jdbcTemplate.execute("DELETE FROM "+TABLE_LOCATION_NAME);
        //jdbcTemplate.execute("ALTER TABLE locations_table ALTER COLUMN longitude NUMERIC(9,6) NULL");
    }

    public Iterable<String> getCities(String country) {
        return jdbcTemplate.query("SELECT DISTINCT city FROM "+TABLE_LOCATION_NAME,
                (rs, rowNum) -> rs.getString("city"));
    }

    public Iterable<Location> getTopPlacesInCity(String country, String city, String num){
        return jdbcTemplate.query("SELECT TOP "+num+" * FROM "+TABLE_LOCATION_NAME+" WHERE city = '"+city+"'" , new LocationMapper());

    }

    public int getIdWhereNameStreet(String name, String street) {
        return jdbcTemplate.query("SELECT * FROM "+TABLE_LOCATION_NAME+" WHERE name='"+name+"' AND street='" + street + "'", new LocationMapper()).get(0).getId();
    }
}
