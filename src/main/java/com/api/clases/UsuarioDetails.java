package com.api.clases;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public @Data class UsuarioDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String firstname;

	private String lastname;

	private String website;

	private String info;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "img_id")
	private Image img;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.PERSIST,mappedBy = "userDetails")

	private Usuario user;

	public UsuarioDetails(String firstname, String lastname, String website, String info,Image imgs, Usuario user) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.website = website;
		this.info = info;
		
		this.img = img;
		this.user = user;
	}


}
