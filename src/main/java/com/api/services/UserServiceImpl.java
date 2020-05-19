package com.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.clases.Usuario;
import com.api.repositories.ProductoRepository;
import com.api.repositories.UsuarioRepository;

@Service
public class UserServiceImpl {
	@Autowired
	private UsuarioRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

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

 			
		return this.userRepository.save(user);
	}

	public Usuario updateUser(Usuario user) {
		
		Usuario originalUser=this.userRepository.findById(user.getId()).get();
 		
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
