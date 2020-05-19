package com.api.clases;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class PostRequest {
 	
	private String text;
	private int likes;
	private int product_id;
	private int user_id;
	private Integer replay_id;
}
