package com.mx.shopping_cart.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mx.shopping_cart.model.Cart;

public interface CartRepository extends CrudRepository<Cart, Long> {

}
