package com.actividad.fp.dtos;

public record ModuloRequestDto(
	String codigo,
	String diminutivo,
	String nombre,
	String descripcion,
	Integer horas_semanales,
	Integer creditos
) {}