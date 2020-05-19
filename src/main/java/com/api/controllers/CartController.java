package com.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.clases.Cart;
import com.api.services.CartServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/cart")
public class CartController {

	private CartServiceImpl cartService;
	public CartController(CartServiceImpl cartService) {
		this.cartService=cartService;
	}
	
	
	@GetMapping
	
	public List<Cart> hello () {
		
		return this.cartService.getAllCarts();
	}
	
	@GetMapping("/{id}")
	
	public Cart  getCartByUserId(@PathVariable int id) {
		
		
		return this.cartService.getCartByUserId(id);
	}
	
	@GetMapping("/id/{id}")
	
	public Cart  getCartByrId(@PathVariable int id) {
		
		
		return this.cartService.getByCartId(id);
	}
	
	@PatchMapping
	
	public Cart addOrUpdateCart(@RequestBody Cart cart) {
		
		return this.cartService.addOrUpdateCart(cart);
	}
}
