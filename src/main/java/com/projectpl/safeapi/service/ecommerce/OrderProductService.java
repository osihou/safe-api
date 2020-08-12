package com.projectpl.safeapi.service.ecommerce;

import com.projectpl.safeapi.persistance.entity.OrderProduct;
import com.projectpl.safeapi.persistance.repository.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProductService implements IOrderProductService{

    @Autowired
    private OrderProductRepository orderProductRepository;

    public OrderProductService(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public OrderProduct create(OrderProduct orderProduct) {
        return this.orderProductRepository.save(orderProduct);
    }
}
