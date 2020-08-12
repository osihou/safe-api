package com.projectpl.safeapi.persistance.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.projectpl.safeapi.persistance.entity.Product;

@Repository("productRepository")
public interface ProductRepository extends CrudRepository<Product, Integer> {
}