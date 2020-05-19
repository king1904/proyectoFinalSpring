package com.api.clases;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public @Data class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "img")
	@JoinColumn(name = "user_id")
	private UsuarioDetails user;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "imgs")

	private List<Producto> products;
	
	
	private String name;
	private String originalName;
	private Date date;
	
	
	public Image(Integer id,String name) {
		this.id=id;
		this.name=name;
	}
}
