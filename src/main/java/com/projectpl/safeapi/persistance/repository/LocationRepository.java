package com.projectpl.safeapi.persistance.repository;

import com.projectpl.safeapi.persistance.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    Iterable<Location> findByNameContainingOrAddressContaining(String infix1,String infix2);
}
