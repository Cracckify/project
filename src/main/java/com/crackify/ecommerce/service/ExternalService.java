package com.crackify.ecommerce.service;

import com.crackify.ecommerce.entitties.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ExternalService implements ProductService{

    public static final String BASE_URL = "https://fakestoreapi.com/products/";

    @Autowired
    RestTemplate restTemplateConfiguration;


    @Override
    public Product getProduct(long id) {
        String url = BASE_URL + id;
        ResponseEntity<Product> p1 = restTemplateConfiguration.getForEntity(url, Product.class);
        System.out.println(p1);
        return p1.getBody();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public String deleteproduct(long id) {
        return "";
    }
}
