package com.nexos.admision.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "articulos")
public class Articulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idArticulo_Sequence")
	@SequenceGenerator(name = "idArticulo_Sequence", sequenceName = "idarticulo_sequence", allocationSize = 1, initialValue = 7)
	@Column(name= "id", nullable=false)
	private Long id;
	
	@Column(name= "nombre")
	private String nombre;
	
	@Column(name= "producto")
	private String producto;
	
	@Column(name= "cantidad")
	private int cantidad;
	
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	@Column(name= "fecha_ing")
	private Date fechaIng;
	
//	@JsonFormat(pattern="dd-MM-yyyy HH:mm")
	@Column(name= "fecha_act")
	private Date fechaAct;

	@ManyToOne()
	@JoinColumn(name= "username_ing")
	private Usuario usernameIng;
	
	@ManyToOne
	@JoinColumn(name = "username_act")
	private Usuario usernameAct;
	
	@PrePersist
	public void prePersist() {
		this.fechaAct = new Date();
	}
	
	@PreUpdate
	public void preUpdate(){
		this.fechaAct = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaIng() {
		return fechaIng;
	}

	public void setFechaIng(Date fechaIng) {
		this.fechaIng = fechaIng;
	}

	public Date getFechaAct() {
		return fechaAct;
	}

	public void setFechaAct(Date fechaAct) {
		this.fechaAct = fechaAct;
	}

	public Usuario getUsernameIng() {
		return usernameIng;
	}

	public void setUsernameIng(Usuario usernameIng) {
		this.usernameIng = usernameIng;
	}

	public Usuario getUsernameAct() {
		return usernameAct;
	}

	public void setUsernameAct(Usuario usernameAct) {
		this.usernameAct = usernameAct;
	}
	
}
