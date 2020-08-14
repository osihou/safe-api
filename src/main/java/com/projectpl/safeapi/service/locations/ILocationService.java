package com.projectpl.safeapi.service.locations;

import com.projectpl.safeapi.persistance.entity.Location;

public interface ILocationService {

    Location findById(int id);

    Iterable<Location> findAll();

    Location save(Location newLocation);

    void deleteById(int id);

    Location updateLocation(Location newLocation, int id);
}
