package com.craccify.ecommerce.service.Impl;

import com.craccify.ecommerce.constants.Appconstants;
import com.craccify.ecommerce.model.Product;
import com.craccify.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ExternalProductServiceImpl implements ProductService {

    @Autowired
    RestTemplate restTemplate;
    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList= List.of(restTemplate.getForObject(Appconstants.EXTERNAL_BASE_URL, Product[].class));
        return productList;
    }

    @Override
    public Product getProductById(Long id) {
        String url = Appconstants.EXTERNAL_BASE_URL+id;
        Product product= restTemplate.getForObject(url, Product.class);
        return product;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Boolean deleteProduct(Long id) {
        return null;
    }
}
