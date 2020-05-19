package com.api.clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @Data class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private String name;
	private String email;
	private int telefono;
	private String text;

	public Message() {}

	public Message( String name, String email, int telefono, String text) {
		this.name = name;
		this.email = email;
		this.telefono=telefono;
		this.text = text;
	}

	 
	
}
