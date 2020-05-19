package com.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.clases.Producto;
import com.api.services.ProductoServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/productos")
public class ProductosController {
	@Autowired
	private   ProductoServiceImpl productoService;
	
	 
	
	@GetMapping
	public List<Producto> getProductos() {
		
		return this.productoService.getProductos();
	}
	
	
	@GetMapping("/categoria/{categoria}")
	public List<Producto> getProductosByCategoria(@PathVariable String categoria) {
		
		return this.productoService.getProductosByCategoria(categoria);
	}
	
	
	
	@GetMapping("/{id}")
	public Producto getProductosById(@PathVariable int id) {
		
		return this.productoService.getProductoById(id);
	}
	
	@PostMapping
	public Producto addProducto(@RequestBody Producto producto) {
		
		return this.productoService.addProducto(producto);
	}
	
	@PutMapping
	public Producto updateProducto(@RequestBody Producto producto) {
		
		return this.productoService.updateProducto(producto);
	}
	
	@PatchMapping
	public void deleteProducto(@RequestBody Producto producto) {
		
		 this.productoService.deleteProducto(producto);
	}

}
