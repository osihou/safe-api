package com.projectpl.safeapi.repository;

import com.projectpl.safeapi.entity.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {
    Location findByName(String name);

    Iterable<Location> findByCity(String city);
}
