package com.projectpl.safeapi.persistance.repository;


import com.projectpl.safeapi.persistance.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}