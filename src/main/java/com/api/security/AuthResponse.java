package com.api.security;

import com.api.clases.Usuario;

public class AuthResponse {
	
	private final String jwt;
	private final Usuario usuario;

	public AuthResponse(String jwt, Usuario usuario) {
		this.usuario=  usuario;
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}
	

	public Usuario getUsuario() {
		return usuario;
	}
}
