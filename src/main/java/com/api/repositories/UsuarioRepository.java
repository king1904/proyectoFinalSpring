package com.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.clases.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	//Usuario findByUsername(String username);
	Usuario findByEmail(String email);
	
 
}
