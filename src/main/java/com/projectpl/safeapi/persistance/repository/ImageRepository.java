package com.projectpl.safeapi.persistance.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projectpl.safeapi.persistance.entity.ImageModel;
public interface ImageRepository extends JpaRepository<ImageModel, Long> {
    Optional<ImageModel> findByName(String name);
}