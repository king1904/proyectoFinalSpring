package com.api.clases;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class   ChatMessage {
	 private String username;
     private String name;
     private String img;
     private String content;
     private String date;
 
 
	
}
