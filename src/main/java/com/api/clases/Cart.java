package com.api.clases;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public @Data class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "user_id")
	private Usuario user;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "carts")
 	private List<Producto> products;
	
	
	
}
