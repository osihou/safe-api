package com.projectpl.safeapi.persistance.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.projectpl.safeapi.persistance.entity.Product;

import java.util.Optional;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Long> {
    Iterable<Product> findProductByType(String type);

    Iterable<Product> findByName(String name);
}