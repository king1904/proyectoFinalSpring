package com.api.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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
import com.api.clases.UsuarioDetails;
import com.api.repositories.CartRepository;
import com.api.repositories.ProductoRepository;
import com.api.repositories.UsuarioRepository;
import com.api.security.AuthRequest;
import com.api.security.AuthResponse;
import com.api.security.JwtUtil;
import com.api.security.UserDetailServiceImpl;
import com.api.services.UserDetailsServiceImpl;
import com.api.services.UserServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/backend/service/usuario")

public class UsuariosController {

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailServiceImpl userDetailService;
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	@Autowired
	private UsuarioRepository userRepo;
	@Autowired
	private ProductoRepository productRepository;
	@Autowired
	private CartRepository cartRepository;

	@PostMapping("/login")

	public ResponseEntity<?> createAutentecationToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("Incorrect username or password", e);
		}

		final Usuario user = this.userRepo.findByEmail(authRequest.getEmail());

//		
//		final UsuarioDetails usuarioDetails= new UsuarioDetails(user.getUserDetails().getFirstname()
//				, user.getUserDetails().getLastname(), user.getUserDetails().getWebsite(),
//				user.getUserDetails().getInfo(),user.getUserDetails().getImg(),user);
//		
		// final Usuario sentUser= new Usuario(user.getId(),
		// user.getUsername(),usuarioDetails, user.getEmail() , user.getPassword(),
		// user.isActive(), user.getRoles());

		final UserDetails userDetails = userDetailService.loadUserByUsername(authRequest.getEmail());
		final String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthResponse(jwt, user));
	}

	@PostMapping("/register")
	public Usuario registrarUsuario(@RequestBody Usuario user) {

		return this.userService.registerUser(user);
	}

	@PatchMapping("/update")
	public Usuario updateUser(@RequestBody Usuario user) {

		return this.userService.updateUser(user);
	}

	@PatchMapping("/update/{id}")
	public Usuario adminUpdateUser(@PathVariable("id") int id, @RequestBody Usuario user) {

		return this.userService.adminUpdateUser(id, user.getRoles(), user.isActive());
	}

	@PatchMapping("/userDetails/update")
	public UsuarioDetails updateUserDetails(@RequestBody UsuarioDetails user) {

		return this.userDetailsService.updateUserDetails(user);
	}

	@GetMapping("/user/{id}")
	public Usuario getUserByEmail(@PathVariable int id) {

		return this.userService.getUserById(id);
	}

	@GetMapping("/user/{id}/cart/{productId}")
	public Usuario updateCart(@PathVariable("id") Integer id, @PathVariable("productId") Integer productId) {

		Usuario usuario = this.userService.getUserById(id);

		Producto productoNuevo = this.productRepository.findById(productId).get();
		Cart cart = usuario.getCart();
		cart.getProducts().add(productoNuevo);
		this.cartRepository.save(cart);

		usuario.setCart(cart);

		return this.userService.updateUser(usuario);
	}

	@GetMapping("/user")
	public List<Usuario> getUsers() {

		return this.userService.getUsuarios();
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		this.userRepo.deleteById(id);
	}
}
