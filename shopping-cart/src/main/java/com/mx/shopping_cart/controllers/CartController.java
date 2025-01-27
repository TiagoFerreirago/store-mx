package com.mx.shopping_cart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.shopping_cart.dto.CartDto;
import com.mx.shopping_cart.model.Item;
import com.mx.shopping_cart.services.CartServices;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

	@Autowired
	private CartServices service;
	
	@PostMapping(value = "/{id}")
	public CartDto addItem(@PathVariable(name = "id")Long id, @RequestBody Item item){
		
		return service.addItem(id, item);
	}
	@GetMapping(value = "/{id}")
	public CartDto findById(@PathVariable(name = "id")Long id){
		
		return service.findById(id);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<CartDto> delete(@PathVariable(name = "id")Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
