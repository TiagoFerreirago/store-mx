package com.mx.shopping_cart.model;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("item")
public class Item {

	
	private Long id;
	private Integer amount;
	
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
