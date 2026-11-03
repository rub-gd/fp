package com.actividad.fp.dtos;

public record TitulacionResponseDto(
	Integer id_titulacion,
	String codigo,
	String diminutivo,
	Integer horas_totales,
	Integer id_curso
) {}