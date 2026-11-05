package com.actividad.fp.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.actividad.fp.dtos.Alumno_Modulo_EstadoRequestDto;
import com.actividad.fp.dtos.Alumno_Modulo_EstadoResponseDto;
import com.actividad.fp.services.Alumno_Modulo_EstadoService;

@RestController
@RequestMapping("/api/alumno_modulo_estado")
public class Alumno_Modulo_EstadoController {
	private final Alumno_Modulo_EstadoService alumno_Modulo_EstadoService;
	
	public Alumno_Modulo_EstadoController(Alumno_Modulo_EstadoService alumno_Modulo_EstadoService) {
		this.alumno_Modulo_EstadoService = alumno_Modulo_EstadoService;
	}
	
	@GetMapping
	public ResponseEntity<List<Alumno_Modulo_EstadoResponseDto>> listarTodosLosAlumno_Modulo_Estados(){
		return ResponseEntity.ok(alumno_Modulo_EstadoService.listarTodosLosAlumno_Modulo_Estados());
	}
	
	@GetMapping("/{id_alumno_modulo_estado}")
	public ResponseEntity<Alumno_Modulo_EstadoResponseDto> buscarAlumno_Modulo_EstadoPorId(@PathVariable Integer id_alumno_modulo_estado){
		return ResponseEntity.ok(alumno_Modulo_EstadoService.buscarAlumno_Modulo_EstadoPorId(id_alumno_modulo_estado));
	}
	
	@PostMapping
	public ResponseEntity<Alumno_Modulo_EstadoResponseDto> crearAlumno_Modulo_Estado(@RequestBody Alumno_Modulo_EstadoRequestDto creacion){
		return ResponseEntity.ok(alumno_Modulo_EstadoService.crearAlumno_Modulo_Estado(creacion));
	}
	
	@PutMapping("/{id_alumno_modulo_estado}")
	public ResponseEntity<Alumno_Modulo_EstadoResponseDto> editarAlumno_Modulo_EstadoPorId(@PathVariable Integer id_alumno_modulo_estado,@RequestBody Alumno_Modulo_EstadoRequestDto datosActualizados){
		return ResponseEntity.ok(alumno_Modulo_EstadoService.editarAlumno_Modulo_EstadoPorId(id_alumno_modulo_estado, datosActualizados));
	}
	
	@DeleteMapping("/{id_alumno_modulo_estado}")
	public ResponseEntity<Void> eliminarAlumno_Modulo_EstadoPorId(@PathVariable Integer id_alumno_modulo_estado){
		alumno_Modulo_EstadoService.eliminarAlumno_Modulo_EstadoPorId(id_alumno_modulo_estado);
			return ResponseEntity.noContent().build();
	}
}
