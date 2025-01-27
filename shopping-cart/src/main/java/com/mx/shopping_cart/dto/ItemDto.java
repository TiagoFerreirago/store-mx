package com.mx.shopping_cart.dto;

import com.mx.shopping_cart.model.Item;

public class ItemDto {

	
	private Long id;
	private Integer amount;
	
	public ItemDto(Item item) {
		
		this.id=item.getId();
		this.amount = item.getAmount();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
}
