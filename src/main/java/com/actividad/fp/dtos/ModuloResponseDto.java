package com.actividad.fp.dtos;

public record ModuloResponseDto(
	Integer id_modulo,
	String codigo,
	String diminutivo,
	String nombre,
	String descripcion,
	Integer horas_semanales,
	Integer creditos
) {}