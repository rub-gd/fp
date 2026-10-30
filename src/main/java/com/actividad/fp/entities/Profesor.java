package com.actividad.fp.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "Profesor", schema = "fp", uniqueConstraints = {@UniqueConstraint(name = "uk_dni", columnNames = "dni")})
public class Profesor {
	@Id
	@Column(name = "id_profesor")private Integer id_profesor;
	@Column(name = "nombre", length = 30, nullable = false)private String nombre;
	@Column(name = "apellidos", length = 50, nullable = false)private String apellidos;
	@Column(name = "dni", length = 9, unique = true)private String dni;
	@Column(name = "email_centro", length = 50)private String email_centro;
	@Column(name = "email_personal", length = 50)private String email_personal;
	@Column(name = "tlf_personal")private Integer tlf_personal;
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "id_departamento")private Departamento departamento;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "profesor")private List<Profesor_Modulo> profesor_modulo;
	
	public Integer getId_profesor() {
		return id_profesor;
	}
	public void setId_profesor(Integer id_profesor) {
		this.id_profesor = id_profesor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getEmail_centro() {
		return email_centro;
	}
	public void setEmail_centro(String email_centro) {
		this.email_centro = email_centro;
	}
	public String getEmail_personal() {
		return email_personal;
	}
	public void setEmail_personal(String email_personal) {
		this.email_personal = email_personal;
	}
	public Integer getTlf_personal() {
		return tlf_personal;
	}
	public void setTlf_personal(Integer tlf_personal) {
		this.tlf_personal = tlf_personal;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public List<Profesor_Modulo> getProfesor_modulo() {
		return profesor_modulo;
	}
	public void setProfesor_modulo(List<Profesor_Modulo> profesor_modulo) {
		this.profesor_modulo = profesor_modulo;
	}
}