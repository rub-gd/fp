package com.actividad.fp.entities;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Estado", schema = "fp")
public class Estado {
	@Id
	@Column(name = "id_estado")private Integer id_estado;
	@Column(name = "nombre", nullable = false)private String nombre;
	@Column(name = "descripcion")private String descripcion;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")private List<Alumno_Modulo_Estado> alumno_modulo_estado;

	public Integer getId_estado() {
		return id_estado;
	}
	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
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
	public List<Alumno_Modulo_Estado> getAlumno_modulo_estado() {
		return alumno_modulo_estado;
	}
	public void setAlumno_modulo_estado(List<Alumno_Modulo_Estado> alumno_modulo_estado) {
		this.alumno_modulo_estado = alumno_modulo_estado;
	}
}
