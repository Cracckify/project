package com.craccify.ecommerce.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

private Long id;
private String name;
private Double price;
private String description;
private String category;
}
