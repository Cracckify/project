package com.crackify.ecommerce.controller;

import com.crackify.ecommerce.entitties.Product;
import com.crackify.ecommerce.service.ProductService;
import com.crackify.ecommerce.service.SelfProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    SelfProductService prodS;

    @GetMapping("/get/{id}")
    public Product getProduct(@PathVariable long id){
        return prodS.getProduct(id);

    }
    @PostMapping("/add/")
    public Product addProduct(@RequestBody Product product){
        return prodS.createProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String DeleteProduct(@PathVariable long id){
        return prodS.deleteproduct(id);
    }
}
