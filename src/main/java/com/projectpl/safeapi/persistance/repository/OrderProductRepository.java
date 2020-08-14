package com.projectpl.safeapi.persistance.repository;

import com.projectpl.safeapi.persistance.entity.OrderProduct;
import com.projectpl.safeapi.persistance.entity.OrderProductPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductPK> {
}
