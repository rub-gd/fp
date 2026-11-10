package com.actividad.fp.exceptions;

public class AlumnoNotFoundException extends RuntimeException{
	public AlumnoNotFoundException(String mensaje) {
		super(mensaje);
	}
}
