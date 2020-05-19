package com.api.services;

import java.util.List;

import com.api.clases.Producto;

public interface ProductoService {
	
	List<Producto> getProductos();
	List<Producto> getProductosByCategoria(String categoria);

	Producto getProductoById(int id);
	Producto addProducto(Producto producto);
	Producto updateProducto(Producto producto);
	void deleteProducto(Producto producto);



}
