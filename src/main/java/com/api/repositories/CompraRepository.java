package com.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.clases.Compra;

public interface CompraRepository extends JpaRepository<Compra, Integer>{

	List<Compra> findAllByUserId(int id);
}
