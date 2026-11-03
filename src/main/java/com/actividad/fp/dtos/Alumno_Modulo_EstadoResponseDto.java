package com.actividad.fp.dtos;

public record Alumno_Modulo_EstadoResponseDto(
	Integer id_alumno_modulo_estado,
	Integer id_alumno,
	Integer id_modulo,
	Integer id_estado
) {}