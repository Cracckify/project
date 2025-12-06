package com.cracckify.ecommerce.controllers;

import com.cracckify.ecommerce.models.Product;
import com.cracckify.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    //Create Get, Delete Put/Patch, Post methods for Product
    // Raise a PR on github

    @Autowired
    @Qualifier("externalStoreService")
    ProductService productService;

    @GetMapping("/get/{id}")
    public Product getProducts(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/create")
    public String createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        System.out.println("Created product: " + product.getTitle());
        return "Product created: " + product.getTitle();
    }
}
