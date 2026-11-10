package com.actividad.fp.exceptions;

public class TitulacionNotFoundException extends RuntimeException{
	public TitulacionNotFoundException(String mensaje) {
		super(mensaje);
	}
}