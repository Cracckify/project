package com.craccify.ecommerce.controller;

import com.craccify.ecommerce.model.Product;
import com.craccify.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    @Qualifier("productServiceImpl")
    ProductService productService;

    @Autowired
    @Qualifier("externalProductServiceImpl")
    ProductService externalProductService;

    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        ResponseEntity response = null;
        //validation
        if (product.getName() == null || product.getName().equals("")) {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product name should not be empty");
        }
        if (product.getPrice() == null || product.getPrice() < 0) {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product Price is invalid");
        }
        Product createdProduct = productService.createProduct(product);
        response = ResponseEntity.status(HttpStatus.CREATED).body("Product created successfully");
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/externalProducts")
    public ResponseEntity<List<Product>> getExternalProducts() {
        return ResponseEntity.ok(externalProductService.getAllProducts());
    }

    @GetMapping("/get/{id}")
    public Product getProductById(@PathVariable  Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/externalProducts/get/{id}")
    public Product getExternalProductById(@PathVariable  Long id) {
        return externalProductService.getProductById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        ResponseEntity response = null;
        //validation
        if (product.getName() == null || product.getName().equals("")) {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product name should not be empty");
        }
        if (product.getPrice() == null || product.getPrice() < 0) {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product Price is invalid");
        }
        Product createdProduct = productService.updateProduct(id, product);
        response = ResponseEntity.status(HttpStatus.CREATED).body("Product updated successfully");
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        boolean status = productService.deleteProduct(id);
        if (status) {
            return ResponseEntity.ok("Product deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Product not found");
        }
    }

}
