package com.api.services;

import java.util.List;

import com.api.clases.Cart;

public interface CartService {

	Cart getCartByUserId(int id);
	
	Cart addOrUpdateCart(Cart cart);
	
	Cart getByCartId(int id);
	List<Cart> getAllCarts();
}
