package com.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.clases.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{

	
}
