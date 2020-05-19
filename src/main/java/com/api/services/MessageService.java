package com.api.services;

import java.util.List;

import com.api.clases.Message;

public interface MessageService {
	
	List<Message> getMessages();
	Message postMessage(Message  message);

}
