package com.ecomerce.data;

import com.ecomerce.model.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductData {

    private Long id;

    private String name;
	
    private Double price;
	
    private Integer quantity;
    
    private Category category;

	
    
    
}
