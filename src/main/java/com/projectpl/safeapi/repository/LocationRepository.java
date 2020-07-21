package com.projectpl.safeapi.repository;

import com.projectpl.safeapi.entity.Location;
import org.springframework.data.repository.CrudRepository;


public interface LocationRepository extends CrudRepository<Location, Integer> {
    Location findByName(String name);

    Iterable<Location> findByCity(String city);
}
