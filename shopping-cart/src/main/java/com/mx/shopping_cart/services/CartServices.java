package com.mx.shopping_cart.services;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.shopping_cart.model.Cart;
import com.mx.shopping_cart.model.Item;
import com.mx.shopping_cart.repositories.CartRepository;

@Service
public class CartServices {

	@Autowired
	private CartRepository repository;
	
	
	public Cart addItem(Long id,Item item){
		
	    Cart cartItem = repository.findById(id).orElse(null);

	    if (cartItem == null) {
	        cartItem = new Cart(id);
	    }

	    cartItem.getItems().add(item);

	    return repository.save(cartItem);
		
	}
	
	public Cart findById(Long id) throws AccountNotFoundException {
		
		Cart cartItem = repository.findById(id).orElseThrow(() -> new AccountNotFoundException("Id not found"));
		return cartItem;

	}
	
	public void delete(Long id) {
		
		repository.deleteById(id);
	}
}
