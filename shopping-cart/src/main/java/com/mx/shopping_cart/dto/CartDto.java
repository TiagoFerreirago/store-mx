package com.mx.shopping_cart.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.mx.shopping_cart.model.Cart;

public class CartDto {

	
	private Long id;
	
	private List<ItemDto> items;

	public CartDto(Cart cart) {
		
		this.id = cart.getId();
		this.items = cart.getItems().stream().map(ItemDto::new).collect(Collectors.toList());
	}
	
	
	public CartDto(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ItemDto> getItems() {
		if(items == null) {
			items = new ArrayList<>();
		}
		return items;
	}

	public void setItems(List<ItemDto> items) {
		this.items = items;
	}

	
	
	
}
