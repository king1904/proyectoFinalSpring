package com.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.clases.Message;
import com.api.repositories.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService{

	private MessageRepository messageRepo;
	
	public MessageServiceImpl(MessageRepository messageRepo) {
		this.messageRepo=messageRepo;
		
	}
	
	@Override
	public List<Message> getMessages() {
		// TODO Auto-generated method stub
		return this.messageRepo.findAll();
	}

	@Override
	public Message postMessage(Message message) {
		// TODO Auto-generated method stub
		return this.messageRepo.save(message);
	}

}
