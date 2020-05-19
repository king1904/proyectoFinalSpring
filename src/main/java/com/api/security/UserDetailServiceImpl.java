package com.api.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.clases.Usuario;
import com.api.repositories.UsuarioRepository;
@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario user= userRepo.findByEmail(email);
		if (user == null)
		       throw new UsernameNotFoundException("Bad credentials");
		
		return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
	}

}
