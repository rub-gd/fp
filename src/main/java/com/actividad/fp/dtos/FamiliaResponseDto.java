package com.actividad.fp.dtos;

public record FamiliaResponseDto(
	Integer id_familia,
	String nombre_padre,
	String apellidos_padre,
	String email_padre,
	Integer tlf_padre,
	String direccion_padre,
	Integer codigo_postal_padre,
	Integer provincia_padre,
	String nombre_madre,
	String apellidos_madre,
	String email_madre,
	Integer tlf_madre,
	String direccion_madre,
	Integer codigo_postal_madre,
	Integer provincia_madre,
	Boolean son_separados,
	Boolean es_compartida,
	Boolean es_padre,
	Boolean es_madre
) {}