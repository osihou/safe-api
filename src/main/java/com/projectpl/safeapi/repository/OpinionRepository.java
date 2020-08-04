package com.projectpl.safeapi.repository;

import com.projectpl.safeapi.entity.Opinion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionRepository extends CrudRepository<Opinion, Integer> {
}
