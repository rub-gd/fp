package com.actividad.fp.exceptions;

public class FamiliaNotFoundException extends RuntimeException{
	public FamiliaNotFoundException(String mensaje) {
		super(mensaje);
	}
}
