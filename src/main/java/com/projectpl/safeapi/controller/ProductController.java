package com.projectpl.safeapi.controller;

import com.projectpl.safeapi.service.ecommerce.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.projectpl.safeapi.persistance.entity.Product;


@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(
            path = "/product",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Iterable<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping(
            path = "/product/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Product getProductById(
            @PathVariable int id
    ){
        return productService.getProductById(id);
    }

    @RequestMapping(
            path = "/product",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void saveProduct(
            @RequestBody Product product
    ){
        productService.save(product);
    }


//    @RequestMapping(method = RequestMethod.GET)
//    public String index(ModelMap modelMap) {
//        modelMap.put("product", new Product());
//        return "product/index";
//    }

//    @RequestMapping(value = "save", method = RequestMethod.POST)
//    public String save(@ModelAttribute("product") Product product, ModelMap modelMap) {
//        Product newProduct = productService.create(product);
//        modelMap.put("newProduct", newProduct);
//        return "product/success";
//    }

}