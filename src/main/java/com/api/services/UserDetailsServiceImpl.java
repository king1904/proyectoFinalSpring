package com.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.clases.Usuario;
import com.api.clases.UsuarioDetails;
import com.api.repositories.UsuarioDetailsRepository;
import com.api.repositories.UsuarioRepository;

@Service
public class UserDetailsServiceImpl {
	@Autowired
	private UsuarioDetailsRepository userRepository;
 
	
	
	public UsuarioDetails updateUserDetails(UsuarioDetails user) {
		
  
		return this.userRepository.saveAndFlush(user);
	}

}
