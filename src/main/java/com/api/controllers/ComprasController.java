package com.api.controllers;

 import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.clases.Compra;
import com.api.clases.CompraDatos;
import com.api.clases.Producto;
import com.api.clases.Usuario;
import com.api.repositories.CompraRepository;
import com.api.repositories.ProductoRepository;
import com.api.repositories.UsuarioRepository;
import com.api.services.ComprasServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/backend/service/compra")
public class ComprasController {

	@Autowired
	private ComprasServiceImpl comprasService;
	@Autowired
	private CompraRepository compraRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ProductoRepository productRepository;

	@GetMapping("/{id}")

	public List<Compra> getComprasByUserId(@PathVariable int id) {

		return this.usuarioRepository.findById(id).get().getCompras();
	}

//	@PostMapping("/{id}/{productId}")
//	public Compra aniadirCompra(@PathVariable("id") int id, @PathVariable("productId") int productId,
//			@RequestBody CompraDatos datos) {
//		Usuario usuario = this.usuarioRepository.findById(id).get();
//		Compra compraNueva = this.compraRepository.save(new Compra());
//
//		compraNueva.setUser(usuario);
//
//		List<Producto> productos = new ArrayList<Producto>();
//
//		Producto producto = this.productRepository.findById(productId).get();
//	 
//		productos.add(producto);
//		
//		compraNueva.setProductos(productos);
//		compraNueva.setCantidad(datos.getCantidad());
//		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//
//		compraNueva.setDate(timeStamp);
//
//		return this.compraRepository.saveAndFlush(compraNueva);
//	}
//	
	
	
	@PostMapping("/{id}")
	public Compra aniadirCompra(@PathVariable("id") int id, @RequestBody CompraDatos datos) {
		Usuario usuario = this.usuarioRepository.findById(id).get();
		Compra compraNueva = this.compraRepository.save(new Compra());

		compraNueva.setUser(usuario);

		List<Producto> productos = new ArrayList<Producto>();

		datos.getProductos().forEach(product->{
			Producto producto = this.productRepository.findById(product.getId()).get();
			if(producto.getStock()>product.getCantidad()) {
			for(int i=0;i<product.getCantidad();i++) {
				productos.add(producto);
			}
			producto.setStock(producto.getStock()-product.getCantidad());
			}
			 

		});
	 
		compraNueva.setProductos(productos);
  		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		compraNueva.setDate(timeStamp);
		this.compraRepository.saveAndFlush(compraNueva);
 

		return this.compraRepository.saveAndFlush(compraNueva);
	}

}
