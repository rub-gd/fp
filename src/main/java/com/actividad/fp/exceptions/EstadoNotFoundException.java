package com.actividad.fp.exceptions;

public class EstadoNotFoundException extends RuntimeException{
	public EstadoNotFoundException(String mensaje) {
		super(mensaje);
	}
}