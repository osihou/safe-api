package com.projectpl.safeapi.persistance.repository;


import com.projectpl.safeapi.persistance.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
