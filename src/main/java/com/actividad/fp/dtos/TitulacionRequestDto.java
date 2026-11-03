package com.actividad.fp.dtos;

public record TitulacionRequestDto(
	String codigo,
	String diminutivo,
	Integer horas_totales,
	Integer id_curso
) {}