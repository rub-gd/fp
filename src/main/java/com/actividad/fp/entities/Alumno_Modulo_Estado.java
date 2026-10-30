package com.actividad.fp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Alumno_Modulo_Estado", schema = "fp")
public class Alumno_Modulo_Estado {
	@Id
	@Column(name = "id_alumno_modulo_estado")private Integer id_alumno_modulo_estado;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_alumno")private Alumno alumno;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_modulo")private Modulo modulo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estado")private Estado estado;

	public Integer getId_alumno_modulo_estado() {
		return id_alumno_modulo_estado;
	}
	public void setId_alumno_modulo_estado(Integer id_alumno_modulo_estado) {
		this.id_alumno_modulo_estado = id_alumno_modulo_estado;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Modulo getModulo() {
		return modulo;
	}
	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
