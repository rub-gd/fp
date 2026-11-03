package com.actividad.fp.dtos;

public record DepartamentoResponseDto(
	Integer id_departamento,
	String codigo,
	String nombre,
	String descripcion,
	Integer tlf
) {}