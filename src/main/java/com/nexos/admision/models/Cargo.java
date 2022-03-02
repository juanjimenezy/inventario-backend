package com.nexos.admision.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cargos")
public class Cargo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idCargoSequence")
	@SequenceGenerator(name = "idCargoSequence", sequenceName = "idCargo_Sequence", allocationSize = 1, initialValue = 4)
	@Column(name="id")
	private Long id;
	
	@Column(name="nombre_cargo")
	private String nombreCargo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreCargo() {
		return nombreCargo;
	}

	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo = nombreCargo;
	}
	
}
