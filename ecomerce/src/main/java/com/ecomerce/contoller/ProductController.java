package com.ecomerce.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomerce.data.ProductData;
import com.ecomerce.data.ResponseData;
import com.ecomerce.service.IProductService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@PostMapping(value="/save")
	//@RequestMapping(value="/save",method=RequestMethod.POST,consumes="application/json")
	public ResponseEntity<ResponseData> save(@RequestBody ProductData productData) {
		ResponseData response=productService.save(productData);
		return ResponseEntity.ok().body(response);
	}
	
	@PutMapping(value="/update")
	//@RequestMapping(value="/update",method=RequestMethod.POST,consumes="application/json")
	public ResponseEntity<ResponseData> update(@RequestBody ProductData productData) {
		ResponseData response=productService.save(productData);
		return ResponseEntity.ok().body(response);
	}
	@GetMapping(value="/getProduct")
	//@RequestMapping(value="/getProduct",method=RequestMethod.POST,consumes="application/json")
	public ResponseEntity<ResponseData> getProduct(@RequestParam Long id) {
		ResponseData response=productService.getProduct(id);
		return ResponseEntity.ok().body(response);
	}
	@DeleteMapping(value="/delete")
	//@RequestMapping(value="/delete",method=RequestMethod.POST,consumes="application/json")
	public ResponseEntity<ResponseData> delete(@RequestParam Long id) {
		ResponseData response=productService.delete(id);
		return ResponseEntity.ok().body(response);
	}
	

}
