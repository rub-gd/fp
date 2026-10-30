package com.actividad.fp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "Titulacion", schema = "fp", uniqueConstraints = {@UniqueConstraint(name = "uk_codigo", columnNames = "codigo"), @UniqueConstraint(name = "uk_diminutivo", columnNames = "diminutivo")})
public class Titulacion {
	@Id
	@Column(name = "id_titulacion")private Integer id_titulacion;
	@Column(name = "codigo", length = 10, nullable = false, unique = true)private String codigo;
	@Column(name = "diminutivo", length = 5, nullable = false, unique = true)private String diminutivo;
	@Column(name = "horas_totales")private Integer horas_totales;
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "id_curso")private Curso curso;
	
	public Integer getId_titulacion() {
		return id_titulacion;
	}
	public void setId_titulacion(Integer id_titulacion) {
		this.id_titulacion = id_titulacion;
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
	public Integer getHoras_totales() {
		return horas_totales;
	}
	public void setHoras_totales(Integer horas_totales) {
		this.horas_totales = horas_totales;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
