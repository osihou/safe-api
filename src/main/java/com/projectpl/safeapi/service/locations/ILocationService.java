package com.projectpl.safeapi.service.locations;

import com.projectpl.safeapi.persistance.entity.Location;

public interface ILocationService {

    Location findById(int id);

    Location findByName(String city);

    Iterable<Location> findByCity(String city);

    Iterable<Location> findAll();

    Location save(Location newLocation);

    void deleteById(int id);
}
