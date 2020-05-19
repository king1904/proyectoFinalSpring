package com.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.clases.Compra;
import com.api.services.ComprasServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/compras")
public class ComprasController {
	
	private ComprasServiceImpl comprasService;
	
	public ComprasController( ComprasServiceImpl comprasService) {
		this.comprasService=comprasService;
		
	}

	
	@GetMapping("/{id}")
	
	public List<Compra> getComprasByUserId(@PathVariable  int id){
		
		
		return this.comprasService.getComprasByUserId(id);
	}
	
	
	
}
