package com.ecm.ecommerce.services;

import com.ecm.ecommerce.models.FakeStoreProduct;
import com.ecm.ecommerce.models.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FakeProductService {
    public FakeStoreProduct getProductById(Integer id);
    public FakeStoreProduct createProduct(FakeStoreProduct product);
    public List<FakeStoreProduct> getAllProduct();
    public FakeStoreProduct updateProduct(Integer id,FakeStoreProduct product);
    public FakeStoreProduct deleteProduct(Integer id);
}
