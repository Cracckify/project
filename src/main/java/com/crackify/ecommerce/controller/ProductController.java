package com.crackify.ecommerce.controller;

import com.crackify.ecommerce.entitties.Product;
import com.crackify.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService prodS;

    @GetMapping("/get/{id}")
    public Product getProduct(@PathVariable long id){
        return prodS.getProduct(id);

    }
    @GetMapping("/add/")
    public Product addProduct(@RequestBody Product product){
        return prodS.createProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String DeleteProduct(@PathVariable long id){
        return prodS.deleteproduct(id);
    }
}
