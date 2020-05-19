package com.api.services;

import java.util.List;

import com.api.clases.Compra;

public interface ComprasService {

	List<Compra> getComprasByUserId(int id);

}
