package com.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.clases.Cart;
import com.api.repositories.CartRepository;
@Service
public class CartServiceImpl implements CartService{

	
	private CartRepository cartRepo;
	
	 public CartServiceImpl(CartRepository cartRepo) {
		this.cartRepo=cartRepo;
	}
	 
	@Override
	public Cart getCartByUserId(int id) {
		// TODO Auto-generated method stub
		return this.cartRepo.findByUserId(id);
	}

	@Override
	public Cart addOrUpdateCart(Cart cart) {
		// TODO Auto-generated method stub
		return this.cartRepo.saveAndFlush(cart);
	}

	@Override
	public Cart getByCartId(int id) {
		// TODO Auto-generated method stub
		return this.cartRepo.findById(id).get();
	}

	@Override
	public List<Cart> getAllCarts() {
		// TODO Auto-generated method stub
		return this.cartRepo.findAll();
	}

}
