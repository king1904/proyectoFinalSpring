package com.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.clases.Cart;
import com.api.clases.Producto;
import com.api.clases.Usuario;
import com.api.repositories.CartRepository;
import com.api.repositories.ProductoRepository;
import com.api.repositories.UsuarioRepository;
import com.api.services.CartServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/backend/service/cart")
public class CartController {

	@Autowired
	private CartServiceImpl cartService;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProductoRepository productRepository;
	public boolean existe = false;
@Autowired
private UsuarioRepository userRepository;

	@GetMapping

	public List<Cart> hello() {

		return this.cartService.getAllCarts();
	}

//	@GetMapping("/{id}")
//
//	public Cart getCartByUserId(@PathVariable int id) {
//
//		return this.cartService.getCartByUserId(id);
//	}

	@GetMapping("/{id}")

	public Cart getCartByrId(@PathVariable int id) {

		return this.cartService.getByCartId(id);
	}

	@GetMapping("/{id}/{productoId}")

	public Cart addOrUpdateCart(@PathVariable int id, @PathVariable int productoId) {
		this.existe = false;

		Producto productoNuevo = this.productRepository.findById(productoId).get();
		Cart cartNew = this.cartService.getByCartId(id);

		cartNew.getProducts().forEach(product -> {

			if (product.getId() == productoId) {
				this.existe = true;
			}

		});

		List<Producto> productos = cartNew.getProducts();

		if (existe) {
			return cartNew;
		} else {

			productos.add(productoNuevo);
			cartNew.setProducts(productos);

			return this.cartService.addOrUpdateCart(cartNew);

		}

	}

	@DeleteMapping("/{id}/{productId}")
	public Cart deleteProductFromCart(@PathVariable("id") int id, @PathVariable("productId") int productId) {

		Cart cart = this.cartService.getByCartId(id);
		List<Producto> productos = cart.getProducts().stream().filter(product -> product.getId() != productId)
				.collect(Collectors.toList());
		cart.setProducts(productos);
		return this.cartService.addOrUpdateCart(cart);
	}
	
	@DeleteMapping("/{id}")
	public Cart deleteUserCart(@PathVariable("id") int id) {

		Cart userCart= this.cartRepository.findById(id).get();
		List<Producto> productos=new ArrayList<Producto>();
		
		userCart.setProducts(productos);
 		return this.cartRepository.saveAndFlush(userCart);
 	}


}
