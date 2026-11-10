package com.actividad.fp.exceptions;

public class CursoNotFoundException extends RuntimeException{
	public CursoNotFoundException(String mensaje) {
		super(mensaje);
	}
}
