package com.projectpl.safeapi.persistance.repository;

import com.projectpl.safeapi.persistance.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    Location findByName(String name);

    Iterable<Location> findByCity(String city);
}
