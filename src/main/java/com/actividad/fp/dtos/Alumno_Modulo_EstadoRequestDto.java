package com.actividad.fp.dtos;

public record Alumno_Modulo_EstadoRequestDto(
	Integer id_alumno,
	Integer id_modulo,
	Integer id_estado
) {}