package com.api.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.clases.ChatMessage;
import com.api.clases.Usuario;

@Controller
@CrossOrigin("*")
@RequestMapping("/backend/service/webchat")
 public class ChatController {
	
	
	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		Usuario user=new Usuario();
		user.setUserDetails(chatMessage.getUser().getUserDetails());
		user.setEmail(chatMessage.getUser().getEmail());
		user.setUsername(chatMessage.getUser().getUsername());
		
		chatMessage.setUser(user);
		
		headerAccessor.getSessionAttributes().put("username", chatMessage.getUser().getUsername());
		return chatMessage;
	}

	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}

 
}
