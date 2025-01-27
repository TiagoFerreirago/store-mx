package com.mx.product_catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.product_catalog.dto.ProductDto;
import com.mx.product_catalog.model.Product;
import com.mx.product_catalog.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping
	public ProductDto create(@RequestBody Product product) {
		
		return service.create(product);
	}
	
	@GetMapping(value = "/{id}")
	public ProductDto findById(@PathVariable Long id) throws Exception {
		
		return service.findById(id);
	}
}
