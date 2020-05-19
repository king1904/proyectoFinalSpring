package com.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.clases.Message;
import com.api.services.MessageServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/message")
public class MessageController {
	
	
	private MessageServiceImpl messageService;
	
public MessageController(MessageServiceImpl messageService) {
	this.messageService=messageService;
	
}


@GetMapping
public List<Message> getMessages(){
	
	return this.messageService.getMessages();
}

@PostMapping

public Message postMessage(@RequestBody Message message) {
	
	return this.messageService.postMessage(message);
}

}
