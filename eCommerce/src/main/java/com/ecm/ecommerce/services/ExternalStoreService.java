package com.ecm.ecommerce.services;

import com.ecm.ecommerce.configurations.RestTemplateConfiguration;
import com.ecm.ecommerce.models.FakeStoreProduct;
import com.ecm.ecommerce.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;


import java.util.List;

@Service
public class ExternalStoreService implements FakeProductService{

    @Autowired
    RestTemplateConfiguration restTemplateConfiguration;

    @Autowired
    RestTemplate restTemplate;

    final String baseurl="https://fakestoreapi.com/";

    @Override
    public FakeStoreProduct getProductById(Integer id) {
        ResponseEntity<FakeStoreProduct> response=restTemplate.getForEntity(baseurl+"products/"+id,FakeStoreProduct.class);


        System.out.println(response);
        return response.getBody();

    }

    @Override
    public FakeStoreProduct createProduct(FakeStoreProduct product) {
        return null;
    }

    @Override
    public List<FakeStoreProduct> getAllProduct() {

        return List.of();
    }

    @Override
    public FakeStoreProduct updateProduct(Integer id, FakeStoreProduct product) {
        return null;
    }

    @Override
    public FakeStoreProduct deleteProduct(Integer id) {
        return null;
    }
}
