package com.ecomerce.service.impl;

import java.io.ObjectInputFilter.Status;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.ecomerce.data.ProductData;
import com.ecomerce.data.ResponseData;
import com.ecomerce.model.Product;
import com.ecomerce.repository.ProductRepository;
import com.ecomerce.service.IProductService;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public ResponseData save(ProductData productData) {
		ResponseData responseData=null;
		Product product=new Product();
		product.setName(productData.getName());
		product.setPrice(productData.getPrice());
		product.setQuantity(productData.getQuantity());
		productRepository.save(product);
		responseData=new ResponseData(com.ecomerce.data.ResponseData.Status.SUCCESS, "Product Saved Successfully.");
		return responseData;
	}

	@Override
	public ResponseData update(ProductData productData) {
		ResponseData responseData=null;
		Optional<Product> productOptional=productRepository.findById(productData.getId());
		if(productOptional.isPresent()) {
			
		Product product=productOptional.get();
		String[] ignoreProp= {"id"};
		BeanUtils.copyProperties(productData, product,ignoreProp);
		product.setName(productData.getName());
		product.setPrice(productData.getPrice());
		product.setQuantity(productData.getQuantity());
		productRepository.save(product);
		responseData=new ResponseData(com.ecomerce.data.ResponseData.Status.SUCCESS, "Product Updated Successfully.");

		}else
		{
			responseData=new ResponseData(com.ecomerce.data.ResponseData.Status.FAILED, "Product Not Updated.");
	
		}
		return responseData;
	}

	@Override
	public ResponseData getProduct(Long id) {
		ResponseData responseData=null;
		Optional<Product> productOptional=productRepository.findById(id);
		if(productOptional.isPresent()) {
			
		Product product=productOptional.get();
		ProductData productData=new ProductData();
		BeanUtils.copyProperties(product, productData);
		productData.setName(productData.getName());
		productData.setPrice(productData.getPrice());
		productData.setQuantity(productData.getQuantity());
		
		responseData=new ResponseData(com.ecomerce.data.ResponseData.Status.SUCCESS, productData);

		}else
		{
			responseData=new ResponseData(com.ecomerce.data.ResponseData.Status.FAILED, "No Records.");
	
		}

		return responseData;
	}

	@Override
	public ResponseData delete(Long id) {
		ResponseData responseData=null;
		Optional<Product> productOptional=productRepository.findById(id);
		if(productOptional.isPresent()) {
			
		Product product=productOptional.get();
		productRepository.delete(product);
		responseData=new ResponseData(com.ecomerce.data.ResponseData.Status.SUCCESS, "Deleteed Sucussfully");

		}
		return responseData;
	}
	
	

}
