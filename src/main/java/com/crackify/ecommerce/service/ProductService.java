package com.crackify.ecommerce.service;

import com.crackify.ecommerce.entitties.Product;

public interface ProductService {
    public Product getProduct(long id);
    public Product createProduct(Product product);
    public String deleteproduct(long id);

}
