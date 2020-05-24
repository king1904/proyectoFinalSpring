package com.api.clases;

import java.util.List;

import lombok.Data;

public @Data class PostResponse {
 
	private String date;
	private int id;
	private int likes;
	private String text;
	private List<Post> replays;
	private String img;
}
