package com.actividad.fp.dtos;

import java.time.LocalDate;

public record AlumnoResponseDto(
	Integer id_alumno,
	String nombre,
	String apellidos,
	String dni,
	String numero_ss,
	String email_centro,
	String email_personal,
	Integer tlf_personal,
	LocalDate fecha_alta,
	LocalDate fecha_baja,
	Integer id_familia
) {}