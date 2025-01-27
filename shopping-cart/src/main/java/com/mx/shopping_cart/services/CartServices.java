package com.mx.shopping_cart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.shopping_cart.dto.CartDto;
import com.mx.shopping_cart.model.Cart;
import com.mx.shopping_cart.model.Item;
import com.mx.shopping_cart.repositories.CartRepository;

import jakarta.ws.rs.NotFoundException;

@Service
public class CartServices {

	@Autowired
	private CartRepository repository;
	
	@Transactional
	public CartDto addItem(Long id,Item item){
		
		if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
		
	    Cart cartItem = repository.findById(id).orElseGet(() -> new Cart(id));
	    cartItem.getItems().add(item);
	    Cart updatedCart = repository.save(cartItem);
	    
	    return new CartDto(updatedCart);
	}
	
	public CartDto findById(Long id){
		
		Cart cartItem = repository.findById(id).orElseThrow(() -> new NotFoundException("Id not found"));
		return new CartDto(cartItem);

	}
	
	public void delete(Long id){
		
		if(!repository.existsById(id)) {
		 throw new NotFoundException("Cart ID "+id+" Not Found for deletaion");
		}
		repository.deleteById(id);
	}
}
