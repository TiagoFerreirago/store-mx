package com.mx.product_catalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.product_catalog.dto.ProductDto;
import com.mx.product_catalog.model.Product;
import com.mx.product_catalog.repository.ProductRepository;

import jakarta.ws.rs.NotFoundException;
@Service
public class ProductService {

	
	@Autowired
	private ProductRepository repository;
	
	
	public ProductDto create(Product product) {
		
		if(product == null || product.getId() == null || product.getAmount() == null || product.getName() == null) {
			throw new IllegalArgumentException("Product, name, and price cannot be null");
		}
		
		Product productItem = repository.save(product);
		return new ProductDto(productItem);
	}
	
	public ProductDto findById(Long id){
		
		Product product = repository.findById(id).orElseThrow(() -> new NotFoundException("Product ID "+id+" Not Found"));
		return new ProductDto(product);
	}
}
