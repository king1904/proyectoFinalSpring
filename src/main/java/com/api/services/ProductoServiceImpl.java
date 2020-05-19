package com.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.clases.Producto;
import com.api.repositories.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private   ProductoRepository productoRepository;
	
	 
	
	@Override
	public List<Producto> getProductos() {
		// TODO Auto-generated method stub
		return this.productoRepository.findAll();
	}

	@Override
	public Producto getProductoById(int id) {
		// TODO Auto-generated method stub
		return this.productoRepository.findById(id).get();
	}

	@Override
	public Producto addProducto(Producto producto) {
		// TODO Auto-generated method stub
		return this.productoRepository.save(producto);
	}

	@Override
	public Producto updateProducto(Producto producto) {
		// TODO Auto-generated method stub
		return this.productoRepository.saveAndFlush(producto);
	}

	@Override
	public void deleteProducto(Producto producto) {
		// TODO Auto-generated method stub
		 this.productoRepository.delete(producto);
	}

	@Override
	public List<Producto> getProductosByCategoria(String categoria) {
		// TODO Auto-generated method stub
		return this.productoRepository.getProductosByCategoria(categoria);
	}

}
