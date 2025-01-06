package com.mx.product_catalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.product_catalog.model.Product;
import com.mx.product_catalog.repository.ProductRepository;
@Service
public class ProductService {

	
	@Autowired
	private ProductRepository repository;
	
	
	public Product create(Product product) {
		
		return repository.save(product);
	}
	
	public Product findById(Long id) throws Exception {
		
		Product product = repository.findById(id).orElseThrow(() -> new Exception("Null ID"));
		return product;
	}
}
