package com.actividad.fp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Profesor_Modulo", schema = "fp")
public class Profesor_Modulo {
	@Id
	@Column(name = "id_profesor_modulo")private Integer id_profesor_modulo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_profesor")private Profesor profesor;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_modulo")private Modulo modulo;
	
	public Integer getId_profesor_modulo() {
		return id_profesor_modulo;
	}
	public void setId_profesor_modulo(Integer id_profesor_modulo) {
		this.id_profesor_modulo = id_profesor_modulo;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public Modulo getModulo() {
		return modulo;
	}
	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
}
