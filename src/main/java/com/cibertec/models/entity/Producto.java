package com.cibertec.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "producto")
@NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotEmpty(message = "EL codigo no debe ser vacio")
	@Size(min = 4, max = 4)
	// @Column(name = "codigo", length = 20)
	private String codigo;

	@NotEmpty(message = "El nombre es obligatorio")
	// @Column(name = "nombre", length = 100)
	private String nombre;

	@Min(value = 1, message = "El valor minimo es 1")
	@Max(value = 1000, message = "El valor maximo es 1000")
	// @Column(name = "precio", length = 10)
	private BigDecimal precio;

//	@Temporal(TemporalType.TIMESTAMP)
//	private Date createdAt;
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date updatedAt;


	// bi-directional many-to-one association to Imagen
	@OneToMany(mappedBy = "producto")
	private List<Imagen> imagens;
	

	public Producto() {

	}

	public Producto(String codigo, String nombre, BigDecimal precio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}

	public Producto(int id, String codigo, String nombre, BigDecimal precio) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}

//	@PrePersist
//	public void prePersist() {
//		this.createdAt = new Date();
//	}
//	
//	@PreUpdate
//	public void preUpdate() {
//		this.updatedAt = new Date();
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + "]";
	}

	public List<Imagen> getImagens() {
		return imagens;
	}

	public void setImagens(List<Imagen> imagens) {
		this.imagens = imagens;
	}
	
	



}
