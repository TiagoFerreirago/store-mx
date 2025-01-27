package com.mx.product_catalog.dto;

import com.mx.product_catalog.model.Product;

public class ProductDto {

	private Long id;
	private String name;
	private Double amount;
	
	public ProductDto(Product product) {
		
		this.id = product.getId();
		this.name = product.getName();
		this.amount = product.getAmount();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	
	
	
}
