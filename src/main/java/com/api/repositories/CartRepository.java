package com.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.clases.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{
	

Cart findByUserId(int id);
}
