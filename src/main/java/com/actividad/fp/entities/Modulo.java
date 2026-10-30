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
@Table(name = "Modulo", schema = "fp", uniqueConstraints = {@UniqueConstraint(name = "uk_codigo", columnNames = "codigo"), @UniqueConstraint(name = "uk_diminutivo", columnNames = "diminutivo")})
public class Modulo {
	@Id
	@Column(name = "id_modulo")private Integer id_modulo;
	@Column(name = "codigo", length = 10, nullable = false, unique = true)private String codigo;
	@Column(name = "diminutivo", length = 5, nullable = false, unique = true)private String diminutivo;
	@Column(name = "nombre", length = 30, nullable = false)private String nombre;
	@Column(name = "descripcion", length = 200)private String descripcion;
	@Column(name = "horas_semanales")private Integer horas_semanales;
	@Column(name = "creditos")private Integer creditos;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "modulo")private List<Profesor_Modulo> profesor_modulo;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "modulo")private List<Modulo_Curso> modulo_curso;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "modulo")private List<Alumno_Modulo_Estado> alumno_modulo_estado;
	
	public Integer getId_modulo() {
		return id_modulo;
	}
	public void setId_modulo(Integer id_modulo) {
		this.id_modulo = id_modulo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDiminutivo() {
		return diminutivo;
	}
	public void setDiminutivo(String diminutivo) {
		this.diminutivo = diminutivo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getHoras_semanales() {
		return horas_semanales;
	}
	public void setHoras_semanales(Integer horas_semanales) {
		this.horas_semanales = horas_semanales;
	}
	public Integer getCreditos() {
		return creditos;
	}
	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}
	public List<Profesor_Modulo> getProfesor_modulo() {
		return profesor_modulo;
	}
	public void setProfesor_modulo(List<Profesor_Modulo> profesor_modulo) {
		this.profesor_modulo = profesor_modulo;
	}
	public List<Alumno_Modulo_Estado> getAlumno_modulo_estado() {
		return alumno_modulo_estado;
	}
	public void setAlumno_modulo_estado(List<Alumno_Modulo_Estado> alumno_modulo_estado) {
		this.alumno_modulo_estado = alumno_modulo_estado;
	}
}
