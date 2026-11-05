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

import com.actividad.fp.dtos.ProfesorRequestDto;
import com.actividad.fp.dtos.ProfesorResponseDto;
import com.actividad.fp.services.ProfesorService;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {
	private final ProfesorService profesorService;
	
	public ProfesorController(ProfesorService profesorService) {
		this.profesorService = profesorService;
	}
	
	@GetMapping
	public ResponseEntity<List<ProfesorResponseDto>> obtenerTodos(){
		return ResponseEntity.ok(profesorService.listarTodosLosProfesores());
	}
	
	@GetMapping("/{id_profesor}")
	public ResponseEntity<ProfesorResponseDto> buscarProfesorPorId(@PathVariable Integer id_profesor){
		return ResponseEntity.ok(profesorService.buscarProfesorPorId(id_profesor));
	}
	
	@GetMapping("/dni/{dni}")
	public ResponseEntity<ProfesorResponseDto> buscarProfesorPorDni(@PathVariable String dni){
		return ResponseEntity.ok(profesorService.buscarProfesorPorDni(dni));
	}
	
	@PostMapping
	public ResponseEntity<ProfesorResponseDto> crearProfesor(@RequestBody ProfesorRequestDto creacion){
		return ResponseEntity.ok(profesorService.crearProfesor(creacion));
	}
	
	@PutMapping("/{id_profesor}")
	public ResponseEntity<ProfesorResponseDto> editarProfesorPorId(@PathVariable Integer id_profesor, @RequestBody ProfesorRequestDto datosActualizados){
		return ResponseEntity.ok(profesorService.editarProfesorPorId(id_profesor, datosActualizados));
	}
	
	@PutMapping("/dni/{dni}")
	public ResponseEntity<ProfesorResponseDto> editarProfesorPorDni(@PathVariable String dni, @RequestBody ProfesorRequestDto datosActualizados){
		return ResponseEntity.ok(profesorService.editarProfesorPorDni(dni, datosActualizados));
	}
	
	@DeleteMapping("/{id_profesor}")
	public ResponseEntity<Void> eliminarProfesorPorId(@PathVariable Integer id_profesor){
		profesorService.eliminarProfesorPorId(id_profesor);
			return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/dni/{dni}")
	public ResponseEntity<Void> eliminarProfesorPorDni(@PathVariable String dni){
		profesorService.eliminarProfesorPorDni(dni);
			return ResponseEntity.noContent().build();
	}
}
