package com.actividad.fp.exceptions;

public class DepartamentoNotFoundException extends RuntimeException{
	public DepartamentoNotFoundException(String mensaje) {
		super(mensaje);
	}
}