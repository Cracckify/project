package com.ecomerce.service;

import com.ecomerce.data.ProductData;
import com.ecomerce.data.ResponseData;

public interface IProductService {
	
	public ResponseData save(ProductData productData);
	
	public ResponseData update(ProductData productData);
	
	public ResponseData getProduct(Long id);
	
	public ResponseData delete(Long id);

}
