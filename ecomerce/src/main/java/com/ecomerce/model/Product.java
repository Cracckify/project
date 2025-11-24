package com.ecomerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "PRODUCT")
public class Product {

	@Id
    @GeneratedValue(generator ="PRODUCT_SEQ", strategy =  GenerationType.SEQUENCE)
	@SequenceGenerator(name="PRODUCT_SEQ",allocationSize = 1,sequenceName = "PRODUCT_SEQ")
	@Column(name = "ID",nullable=false)
    private Long id;

	@Column(name = "NAME")
    private String name;
	
	@Column(name = "PRICE")
    private Double price;
	
	@Column(name = "QUANTITY")
    private Integer quantity;
	
	private Category category;

	
	
	
}
