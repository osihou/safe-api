package com.projectpl.safeapi.service.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final String TABLE_LOCATION_NAME = "locations_table";

    @Autowired
    private JdbcTemplate jdbcTemplate;


}
