package com.projectpl.safeapi.persistance.repository;

import com.projectpl.safeapi.persistance.entity.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionRepository extends JpaRepository<Opinion, Integer> {
        Opinion findByLocationKey(int id);
}
