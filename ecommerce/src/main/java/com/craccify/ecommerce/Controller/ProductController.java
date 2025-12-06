package com.craccify.ecommerce.Controller;

import com.craccify.ecommerce.Service.ProductService;
import com.craccify.ecommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/get/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/create")
    public String createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        System.out.println("Product created " + product.getTitle());
        return "Product created " + product.getTitle();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "Product deleted " + id;
    }
}

