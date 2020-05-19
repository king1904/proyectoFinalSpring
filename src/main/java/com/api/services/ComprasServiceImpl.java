package com.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.clases.Compra;
import com.api.repositories.CompraRepository;

@Service
public class ComprasServiceImpl implements ComprasService{

	private CompraRepository compraRepository;
	
	public ComprasServiceImpl(CompraRepository compraRepository) {
	this.compraRepository=compraRepository;	
	}
	
	
	@Override
	public List<Compra> getComprasByUserId(int id) {
		// TODO Auto-generated method stub
		return this.compraRepository.findAllByUserId(id);
	}

}
