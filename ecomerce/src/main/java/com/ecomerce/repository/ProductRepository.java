package com.ecomerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecomerce.model.Product;

public interface ProductRepository extends CrudRepository<Product ,Long> {

}
