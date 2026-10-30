package com.actividad.fp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Modulo_Curso", schema = "fp")
public class Modulo_Curso {
	@Id
	@Column(name = "id_modulo_curso")private Integer id_modulo_curso;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_modulo")private Modulo modulo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_curso")private Curso curso;
	
	public Integer getId_modulo_curso() {
		return id_modulo_curso;
	}
	public void setId_modulo_curso(Integer id_modulo_curso) {
		this.id_modulo_curso = id_modulo_curso;
	}
	public Modulo getModulo() {
		return modulo;
	}
	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
