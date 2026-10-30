package com.actividad.fp.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "Alumno", schema = "fp", uniqueConstraints = {@UniqueConstraint(name = "uk_dni", columnNames = "dni")})
public class Alumno {
	@Id
	@Column(name = "id_alumno")private Integer id_alumno;
	@Column(name = "nombre", length = 30, nullable = false)private String nombre;
	@Column(name = "apellidos", length = 50, nullable = false)private String apellidos;
	@Column(name = "dni", length = 9, nullable = false, unique = true)private String dni;
	@Column(name = "numero_ss", length = 30, unique = true)private String numero_ss;
	@Column(name = "email_centro", length = 50)private String email_centro;
	@Column(name = "email_personal", length = 50)private String email_personal;
	@Column(name = "tlf_personal")private Integer tlf_personal;
	@Column(name = "fecha_alta", nullable = false)private LocalDate fecha_alta;
	@Column(name = "fecha_baja")private LocalDate fecha_baja;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_familia", foreignKey = @ForeignKey(name =  "fk_Alumno_Familia"))private Familia familia;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "alumno")private List<Alumno_Modulo_Estado> alumno_modulo_estado;
	
	public Integer getId_alumno() {
		return id_alumno;
	}
	public void setId_alumno(Integer id_alumno) {
		this.id_alumno = id_alumno;
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
	public String getNumero_ss() {
		return numero_ss;
	}
	public void setNumero_ss(String numero_ss) {
		this.numero_ss = numero_ss;
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
	public LocalDate getFecha_alta() {
		return fecha_alta;
	}
	public void setFecha_alta(LocalDate fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	public LocalDate getFecha_baja() {
		return fecha_baja;
	}
	public void setFecha_baja(LocalDate fecha_baja) {
		this.fecha_baja = fecha_baja;
	}
	public Familia getFamilia() {
		return familia;
	}
	public void setFamilia(Familia familia) {
		this.familia = familia;
	}
	public List<Alumno_Modulo_Estado> getAlumno_modulo_estado() {
		return alumno_modulo_estado;
	}
	public void setAlumno_modulo_estado(List<Alumno_Modulo_Estado> alumno_modulo_estado) {
		this.alumno_modulo_estado = alumno_modulo_estado;
	}
}
