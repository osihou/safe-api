package com.projectpl.safeapi.service.ecommerce;

import com.projectpl.safeapi.errors.exceptions.ResourceNotFoundException;
import com.projectpl.safeapi.persistance.entity.Product;

import com.projectpl.safeapi.persistance.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductService implements IProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(long id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Iterable<Product> findProductByType(String type) {
       return productRepository.findProductByType(type);
    }

    @Override
    public Product updateProduct(Product newProduct ,long id) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setDescription(newProduct.getDescription());
                    product.setName(newProduct.getName());
                    product.setPrice(newProduct.getPrice());
                    product.setStatus(newProduct.isStatus());
                    product.setType(newProduct.getType());
                    return productRepository.save(product);

                })

                .orElseGet( () ->{
                    newProduct.setId(id);
                    productRepository.save(newProduct);
                    return null;
                });
    }

    @Override
    public void deleteProductById(long id) {
        productRepository.deleteById(id);

    }

    @Override
    public Iterable<Product> findProductByName(String name) {
        return productRepository.findByName(name);
    }


    public Product create(Product product) {
        return productRepository.save(product);
    }
}
