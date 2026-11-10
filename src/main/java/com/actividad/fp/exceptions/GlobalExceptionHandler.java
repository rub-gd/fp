package com.actividad.fp.exceptions;

import java.net.URI;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

		@ExceptionHandler(Alumno_Modulo_EstadpNotFoundException.class)
		public ProblemDetail Alumno_Modulo_EstadpEncontrado(Alumno_Modulo_EstadpNotFoundException excepcion) {
			ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, excepcion.getMessage());
	        problem.setTitle("Alumno_Modulo_Estado no encontrado.");
	        problem.setType(URI.create("https://fp.actividad.com/errors/not-found"));
	        problem.setProperty("timestamp", Instant.now());
	        	return problem;
	    }
		
		@ExceptionHandler(AlumnoNotFoundException.class)
		public ProblemDetail manejarAlumnoNoEncontrado(AlumnoNotFoundException excepcion) {
			ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, excepcion.getMessage());
	        problem.setTitle("Alumno no encontrado.");
	        problem.setType(URI.create("https://fp.actividad.com/errors/not-found"));
	        problem.setProperty("timestamp", Instant.now());
	        	return problem;
	    }
		
		@ExceptionHandler(CursoNotFoundException.class)
		public ProblemDetail manejarCursoNoEncontrado(CursoNotFoundException excepcion) {
			ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, excepcion.getMessage());
	        problem.setTitle("Curso no encontrado.");
	        problem.setType(URI.create("https://fp.actividad.com/errors/not-found"));
	        problem.setProperty("timestamp", Instant.now());
	        	return problem;
	    }
		
		@ExceptionHandler(DepartamentoNotFoundException.class)
		public ProblemDetail manejarDepartamentoNoEncontrado(DepartamentoNotFoundException excepcion) {
			ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, excepcion.getMessage());
	        problem.setTitle("Departamento no encontrado.");
	        problem.setType(URI.create("https://fp.actividad.com/errors/not-found"));
	        problem.setProperty("timestamp", Instant.now());
	        	return problem;
	    }
		
		@ExceptionHandler(EstadoNotFoundException.class)
		public ProblemDetail manejarEstadoNoEncontrado(EstadoNotFoundException excepcion) {
			ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, excepcion.getMessage());
	        problem.setTitle("Estado no encontrado.");
	        problem.setType(URI.create("https://fp.actividad.com/errors/not-found"));
	        problem.setProperty("timestamp", Instant.now());
	        	return problem;
	    }
		
		@ExceptionHandler(FamiliaNotFoundException.class)
		public ProblemDetail manejarFamiliaNoEncontrada(FamiliaNotFoundException excepcion) {
			ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, excepcion.getMessage());
	        problem.setTitle("Familia no encontrada.");
	        problem.setType(URI.create("https://fp.actividad.com/errors/not-found"));
	        problem.setProperty("timestamp", Instant.now());
	        	return problem;
	    }
		
		@ExceptionHandler(Modulo_CursoNotFoundException.class)
		public ProblemDetail manejarModulo_CursoNoEncontrado(Modulo_CursoNotFoundException excepcion) {
			ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, excepcion.getMessage());
	        problem.setTitle("Modulo_Curso no encontrado.");
	        problem.setType(URI.create("https://fp.actividad.com/errors/not-found"));
	        problem.setProperty("timestamp", Instant.now());
	        	return problem;
	    }
		
		@ExceptionHandler(ModuloNotFoundException.class)
		public ProblemDetail manejarModuloNoEncontrado(ModuloNotFoundException excepcion) {
			ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, excepcion.getMessage());
	        problem.setTitle("Módulo no encontrado.");
	        problem.setType(URI.create("https://fp.actividad.com/errors/not-found"));
	        problem.setProperty("timestamp", Instant.now());
	        	return problem;
	    }
		
		@ExceptionHandler(Profesor_ModuloNotFoundException.class)
		public ProblemDetail manejarProfesor_ModuloNoEncontrado(Profesor_ModuloNotFoundException excepcion) {
			ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, excepcion.getMessage());
	        problem.setTitle("Profesor_Modulo no encontrado.");
	        problem.setType(URI.create("https://fp.actividad.com/errors/not-found"));
	        problem.setProperty("timestamp", Instant.now());
	        	return problem;
	    }
		
		@ExceptionHandler(ProfesorNotFoundException.class)
		public ProblemDetail manejarProfesorNoEncontrado(ProfesorNotFoundException excepcion) {
			ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, excepcion.getMessage());
	        problem.setTitle("Profesor no encontrado.");
	        problem.setType(URI.create("https://fp.actividad.com/errors/not-found"));
	        problem.setProperty("timestamp", Instant.now());
	        	return problem;
	    }
		
		@ExceptionHandler(TitulacionNotFoundException.class)
		public ProblemDetail manejarTitulacionNoEncontrado(TitulacionNotFoundException excepcion) {
			ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, excepcion.getMessage());
	        problem.setTitle("Titulación no encontrada.");
	        problem.setType(URI.create("https://fp.actividad.com/errors/not-found"));
	        problem.setProperty("timestamp", Instant.now());
	        	return problem;
	    }
}
