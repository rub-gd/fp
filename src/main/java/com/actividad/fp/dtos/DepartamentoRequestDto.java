package com.actividad.fp.dtos;

public record DepartamentoRequestDto(
	String codigo,
	String nombre,
	String descripcion,
	Integer tlf
) {}