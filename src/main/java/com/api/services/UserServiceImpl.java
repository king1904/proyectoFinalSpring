package com.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.clases.Cart;
import com.api.clases.Compra;
import com.api.clases.Image;
import com.api.clases.Usuario;
import com.api.clases.UsuarioDetails;
import com.api.repositories.CartRepository;
import com.api.repositories.CompraRepository;
import com.api.repositories.ImageRepository;
import com.api.repositories.ProductoRepository;
import com.api.repositories.UsuarioDetailsRepository;
import com.api.repositories.UsuarioRepository;

@Service
public class UserServiceImpl {
	@Autowired
	private UsuarioRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UsuarioDetailsRepository userDetailsRepository;
	@Autowired
	private ImageRepository imageRepository;
	@Autowired
	private CartRepository cartRepository;
 

	public List<Usuario> getUsuarios() {

		return this.userRepository.findAll();
	}

	public Usuario getUsuarioByEmail(String email) {

		return this.userRepository.findByEmail(email);
	}

	public Usuario getUserById(int id) {

		return this.userRepository.findById(id).get();
	}

	public Usuario registerUser(Usuario user) {

		user.setPassword(this.passwordEncoder.encode(user.getPassword()));

 		Cart cart=this.cartRepository.save(new Cart());
		
 
		UsuarioDetails userDetails = this.userDetailsRepository.save(user.getUserDetails());
		Image imagen = this.imageRepository.save(user.getUserDetails().getImg());
		userDetails.setImg(imagen);
		user.setUserDetails(userDetails);
		user.setCart(cart);
 
		return this.userRepository.save(user);
	}

	public Usuario updateUser(Usuario user) {

		Usuario originalUser = this.userRepository.findById(user.getId()).get();

		originalUser.setUserDetails(user.getUserDetails());
		originalUser.setUsername(user.getUsername());
		originalUser.setEmail(user.getEmail());

		if (user.getPassword() != originalUser.getPassword()) {
			System.out.println("maybe?");
			originalUser.setUserDetails(user.getUserDetails());
			originalUser.setUsername(user.getUsername());
			originalUser.setEmail(user.getEmail());
			originalUser.setPassword(this.passwordEncoder.encode(user.getPassword()));

		}

		return this.userRepository.saveAndFlush(originalUser);
	}
}
