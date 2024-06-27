package com.cibertec.models.service;

import java.util.List;

import com.cibertec.models.entity.Producto;

public interface IProductoService {
	
	public List<Producto> listarTodos();
	
	public void guardar(Producto producto);

	public Producto buscarPorId(Integer Id);
	
	public void eliminar(Integer Id);
}
