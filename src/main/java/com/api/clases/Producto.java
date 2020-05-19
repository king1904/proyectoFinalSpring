package com.api.clases;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor

public @Data class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "categoria")
	private String categoria;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Image> imgs;
	
	@Column(name = "precio")
	private float precio;
	
	@Column(name = "stock")
	private int stock;
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<Post> posts;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Cart> carts; 

	 
 
	public Producto(String nombre, String descripcion, List<Image> imgs, float precio, int stock) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imgs = imgs;
		this.precio = precio;
		this.stock = stock;
	}

 

}
