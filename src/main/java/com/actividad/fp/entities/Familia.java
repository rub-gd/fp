package com.actividad.fp.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Familia", schema = "fp")
public class Familia {
	@Id
	@Column(name = "id_familia")private Integer id_familia;
	@Column(name = "nombre_padre", length = 30)private String nombre_padre;
	@Column(name = "apellidos_padre", length = 30)private String apellidos_padre;
	@Column(name = "email_padre", length = 50)private String email_padre;
	@Column(name = "tlf_padre")private Integer tlf_padre;
	@Column(name = "direccion_padre", length = 100)private String direccion_padre;
	@Column(name = "codigo_postal_padre")private Integer codigo_postal_padre;
	@Column(name = "provincia_padre")private Integer provincia_padre;
	@Column(name = "nombre_madre", length = 30)private String nombre_madre;
	@Column(name = "apellidos_madre", length = 30)private String apellidos_madre;
	@Column(name = "email_madre", length = 50)private String email_madre;
	@Column(name = "tlf_madre")private Integer tlf_madre;
	@Column(name = "direccion_madre", length = 100)private String direccion_madre;
	@Column(name = "codigo_postal_madre")private Integer codigo_postal_madre;
	@Column(name = "provincia_madre")private Integer provincia_madre;
	@Column(name = "son_separados")private Boolean son_separados;
	@Column(name = "es_compartida")private Boolean es_compartida;
	@Column(name = "es_padre")private Boolean es_padre;
	@Column(name = "es_madre")private Boolean es_madre;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "familia")private List<Alumno> alumno;
	
	public Integer getId_familia() {
		return id_familia;
	}
	public void setId_familia(Integer id_familia) {
		this.id_familia = id_familia;
	}
	public String getNombre_padre() {
		return nombre_padre;
	}
	public void setNombre_padre(String nombre_padre) {
		this.nombre_padre = nombre_padre;
	}
	public String getApellidos_padre() {
		return apellidos_padre;
	}
	public void setApellidos_padre(String apellidos_padre) {
		this.apellidos_padre = apellidos_padre;
	}
	public String getEmail_padre() {
		return email_padre;
	}
	public void setEmail_padre(String email_padre) {
		this.email_padre = email_padre;
	}
	public Integer getTlf_padre() {
		return tlf_padre;
	}
	public void setTlf_padre(Integer tlf_padre) {
		this.tlf_padre = tlf_padre;
	}
	public String getDireccion_padre() {
		return direccion_padre;
	}
	public void setDireccion_padre(String direccion_padre) {
		this.direccion_padre = direccion_padre;
	}
	public Integer getCodigo_postal_padre() {
		return codigo_postal_padre;
	}
	public void setCodigo_postal_padre(Integer codigo_postal_padre) {
		this.codigo_postal_padre = codigo_postal_padre;
	}
	public Integer getProvincia_padre() {
		return provincia_padre;
	}
	public void setProvincia_padre(Integer provincia_padre) {
		this.provincia_padre = provincia_padre;
	}
	public String getNombre_madre() {
		return nombre_madre;
	}
	public void setNombre_madre(String nombre_madre) {
		this.nombre_madre = nombre_madre;
	}
	public String getApellidos_madre() {
		return apellidos_madre;
	}
	public void setApellidos_madre(String apellidos_madre) {
		this.apellidos_madre = apellidos_madre;
	}
	public String getEmail_madre() {
		return email_madre;
	}
	public void setEmail_madre(String email_madre) {
		this.email_madre = email_madre;
	}
	public Integer getTlf_madre() {
		return tlf_madre;
	}
	public void setTlf_madre(Integer tlf_madre) {
		this.tlf_madre = tlf_madre;
	}
	public String getDireccion_madre() {
		return direccion_madre;
	}
	public void setDireccion_madre(String direccion_madre) {
		this.direccion_madre = direccion_madre;
	}
	public Integer getCodigo_postal_madre() {
		return codigo_postal_madre;
	}
	public void setCodigo_postal_madre(Integer codigo_postal_madre) {
		this.codigo_postal_madre = codigo_postal_madre;
	}
	public Integer getProvincia_madre() {
		return provincia_madre;
	}
	public void setProvincia_madre(Integer provincia_madre) {
		this.provincia_madre = provincia_madre;
	}
	public Boolean getSon_separados() {
		return son_separados;
	}
	public void setSon_separados(Boolean son_separados) {
		this.son_separados = son_separados;
	}
	public Boolean getEs_compartida() {
		return es_compartida;
	}
	public void setEs_compartida(Boolean es_compartida) {
		this.es_compartida = es_compartida;
	}
	public Boolean getEs_padre() {
		return es_padre;
	}
	public void setEs_padre(Boolean es_padre) {
		this.es_padre = es_padre;
	}
	public Boolean getEs_madre() {
		return es_madre;
	}
	public void setEs_madre(Boolean es_madre) {
		this.es_madre = es_madre;
	}
	public List<Alumno> getAlumno() {
		return alumno;
	}
	public void setAlumno(List<Alumno> alumno) {
		this.alumno = alumno;
	}
}
