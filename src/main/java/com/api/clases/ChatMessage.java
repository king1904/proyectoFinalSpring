package com.api.clases;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class   ChatMessage {
	private Usuario user;
	private String content;
	private String date;
 
	
}
