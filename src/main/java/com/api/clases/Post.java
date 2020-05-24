package com.api.clases;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public @Data class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Usuario user;
	
	@JsonIgnore
  	@ManyToOne
	@JoinColumn(name = "product_id")
	private Producto product;
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "replay_id")
  	private Post replyTo;
	
	@OneToMany(mappedBy = "replyTo",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
 	private List<Post> replays;
	
	private String text;
	private String date;
	private int likes;
 

	
	public Post(int id, Usuario user, String text, String date, int likes ) {
		this.id = id;
		this.user = user;
		this.text = text;
		this.date = date;
		this.likes = likes;
  	}


	public Post(int id, Usuario user, Producto product, List<Post> replays, String text, String date, int likes ) {
		this.id = id;
		this.user = user;
		this.product = product;
		this.replays = replays;
		this.text = text;
		this.date = date;
		this.likes = likes;
 	}


	public Post(int id, int likes) {
		this.id = id;
		this.likes = likes;
	}

}
