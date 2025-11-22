package com.cracckify.ecommerce.services;

import com.cracckify.ecommerce.configurations.RestTemplateConfiguration;
import com.cracckify.ecommerce.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ExternalStoreService implements ProductService{

    public static final String BASE_URL = "https://fakestoreapi.com/products/";

    @Autowired
    RestTemplate restTemplateConfiguration;


    ExternalStoreService(){
    }

    @Override
    public Product getProductById(Long id) {
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
    public List<Product> getAllProducts() {
        List<Product> products = List.of(restTemplateConfiguration.getForObject(BASE_URL, Product[].class));
        return products;
    }
}
