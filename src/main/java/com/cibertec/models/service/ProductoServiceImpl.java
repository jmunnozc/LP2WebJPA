package com.cibertec.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.models.entity.Producto;
import com.cibertec.models.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public List<Producto> listarTodos() {
		return (List<Producto>) productoRepository.findAll();
	}

	@Override
	public void guardar(Producto producto) {
		productoRepository.save(producto);
	}

	@Override
	public Producto buscarPorId(Integer Id) {
		return productoRepository.findById(Id).orElse(null);
	}

	@Override
	public void eliminar(Integer Id) {
		productoRepository.deleteById(Id);
	}

}
