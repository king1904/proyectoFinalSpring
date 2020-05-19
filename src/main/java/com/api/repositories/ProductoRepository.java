package com.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.clases.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

	@Query(value = "select p from Producto p where p.categoria= :categoria ")
	List<Producto> getProductosByCategoria(@Param("categoria") String categoria);
	
	
 }
