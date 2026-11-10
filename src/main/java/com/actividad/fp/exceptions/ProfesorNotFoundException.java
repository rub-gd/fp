package com.actividad.fp.exceptions;

public class ProfesorNotFoundException extends RuntimeException{
	public ProfesorNotFoundException(String mensaje) {
		super(mensaje);
	}
}