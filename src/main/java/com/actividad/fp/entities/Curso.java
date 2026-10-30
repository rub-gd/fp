package com.actividad.fp.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "Curso", schema = "fp", uniqueConstraints = {@UniqueConstraint(name = "uk_diminutivo", columnNames = "diminutivo")})
public class Curso {
	@Id
	@Column(name = "id_curso")private Integer id_curso;
	@Column(name = "diminutivo", length = 5, nullable = false, unique = true)private String diminutivo;
	@Column(name = "descripcion", length = 200)private String descripcion;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "curso")private List<Modulo_Curso> modulo_curso;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "curso")private List<Titulacion> titulacion;
	
	public Integer getId_curso() {
		return id_curso;
	}
	public void setId_curso(Integer id_curso) {
		this.id_curso = id_curso;
	}
	public String getDiminutivo() {
		return diminutivo;
	}
	public void setDiminutivo(String diminutivo) {
		this.diminutivo = diminutivo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Modulo_Curso> getModulo_curso() {
		return modulo_curso;
	}
	public void setModulo_curso(List<Modulo_Curso> modulo_curso) {
		this.modulo_curso = modulo_curso;
	}
	public List<Titulacion> getTitulacion() {
		return titulacion;
	}
	public void setTitulacion(List<Titulacion> titulacion) {
		this.titulacion = titulacion;
	}
}
