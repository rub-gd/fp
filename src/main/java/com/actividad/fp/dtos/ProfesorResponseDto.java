package com.actividad.fp.dtos;

public record ProfesorResponseDto(
	Integer id_profesor,
	String nombre,
	String apellidos,
	String dni,
	String email_centro,
	String email_personal,
	Integer tlf_personal,
	Integer id_departamento
) {}