package com.cibertec.models.entity;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "imagen")
public class Imagen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	private String codigoProducto;

	@Lob
	@Column(name = "imagen", columnDefinition = "LONGBLOB")
	private byte[] imagen;

	@ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

	public Imagen() {
		super();
	}

	public Imagen(String codigoProducto, byte[] imageBytes) {
		super();
		this.codigoProducto = codigoProducto;
		this.imagen = imageBytes;
	}

	public Imagen(int id, String codigoProducto, byte[] imageBytes) {
		super();
		this.id = id;
		this.codigoProducto = codigoProducto;
		this.imagen = imageBytes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public byte[] getImageBytes() {
		return imagen;
	}

	public void setImageBytes(byte[] imageBytes) {
		this.imagen = imageBytes;
	}

	@Override
	public String toString() {
		return "Imagen [id=" + id + ", codigoProducto=" + codigoProducto + ", imageBytes=" + Arrays.toString(imagen)
				+ "]";
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
}
