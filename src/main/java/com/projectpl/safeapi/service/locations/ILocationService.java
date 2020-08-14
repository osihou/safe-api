package com.projectpl.safeapi.service.locations;

import com.projectpl.safeapi.persistance.entity.Location;
import org.springframework.data.domain.PageRequest;

public interface ILocationService {

    Location findById(int id);


    Location save(Location newLocation);

    void deleteById(int id);

    Location updateLocation(Location newLocation, int id);

    Iterable<Location> findByNameOrAddressContaining(String infix);

    Iterable<Location> findTop20();
}
