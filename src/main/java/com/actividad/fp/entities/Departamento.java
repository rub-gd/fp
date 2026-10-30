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
@Table(name = "Departamento", schema = "fp", uniqueConstraints = {@UniqueConstraint(name = "uk_codigo", columnNames = "codigo")})
public class Departamento {
	@Id
	@Column(name = "id_departamento")private Integer id_departamento;
	@Column(name = "codigo", length = 20, nullable = false, unique = true)private String codigo;
	@Column(name = "nombre", length = 30, nullable = false)private String nombre;
	@Column(name = "descripcion", length = 200)private String descripcion;
	@Column(name = "tlf")private Integer tlf;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento")private List<Profesor> profesor;
	
	public Integer getId_departamento() {
		return id_departamento;
	}
	public void setId_departamento(Integer id_departamento) {
		this.id_departamento = id_departamento;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getTlf() {
		return tlf;
	}
	public void setTlf(Integer tlf) {
		this.tlf = tlf;
	}
	public List<Profesor> getProfesor() {
		return profesor;
	}
	public void setProfesor(List<Profesor> profesor) {
		this.profesor = profesor;
	}
}