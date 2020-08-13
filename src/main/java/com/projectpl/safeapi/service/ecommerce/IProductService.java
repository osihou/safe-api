package com.projectpl.safeapi.service.ecommerce;

import com.projectpl.safeapi.persistance.entity.Product;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface IProductService {

    @NotNull Iterable<Product> getAllProducts();

    Product getProductById(@Min(value = 1L, message = "Invalid product ID.") long id);

    Product save(Product product);

}
