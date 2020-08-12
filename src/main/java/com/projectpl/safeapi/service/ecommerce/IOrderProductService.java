package com.projectpl.safeapi.service.ecommerce;

import com.projectpl.safeapi.persistance.entity.OrderProduct;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface IOrderProductService {

    OrderProduct create(@NotNull(message = "The products for order cannot be null.") @Valid OrderProduct orderProduct);
}