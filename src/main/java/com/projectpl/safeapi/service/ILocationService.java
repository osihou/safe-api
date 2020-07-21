package com.projectpl.safeapi.service;

import com.projectpl.safeapi.entity.Location;

import java.util.List;

public interface ILocationService {

    Location findById(int id);

    Location findByName(String city);

    Iterable<Location> findByCity(String city);

    Iterable<Location> findAll();

    Location save(Location newLocation);

    void deleteById(int id);
}
