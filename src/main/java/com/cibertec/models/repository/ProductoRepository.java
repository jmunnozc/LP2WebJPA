package com.cibertec.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.models.entity.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Integer> {
	
	

}
