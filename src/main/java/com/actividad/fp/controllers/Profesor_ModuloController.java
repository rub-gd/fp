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

import com.actividad.fp.dtos.Profesor_ModuloRequestDto;
import com.actividad.fp.dtos.Profesor_ModuloResponseDto;
import com.actividad.fp.services.Profesor_ModuloService;

@RestController
@RequestMapping("/api/profesor_modulo")
public class Profesor_ModuloController {
	private final Profesor_ModuloService profesor_ModuloService;
	
	public Profesor_ModuloController(Profesor_ModuloService profesor_ModuloService) {
		this.profesor_ModuloService = profesor_ModuloService;
	}
	
	@GetMapping
	public ResponseEntity<List<Profesor_ModuloResponseDto>> listarTodosLosProfesor_Modulos(){
		return ResponseEntity.ok(profesor_ModuloService.listarTodosLosProfesor_Modulos());
	}
	
	@GetMapping("/{id_profesor_modulo}")
	public ResponseEntity<Profesor_ModuloResponseDto> buscarProfesor_ModuloPorId(@PathVariable Integer id_profesor_modulo){
		return ResponseEntity.ok(profesor_ModuloService.buscarProfesor_ModuloPorId(id_profesor_modulo));
	}
	
	@PostMapping
	public ResponseEntity<Profesor_ModuloResponseDto> crearProfesor_Modulo(@RequestBody Profesor_ModuloRequestDto creacion){
		return ResponseEntity.ok(profesor_ModuloService.crearProfesor_Modulo(creacion));
	}
	
	@PutMapping("/{id_profesor_modulo}")
	public ResponseEntity<Profesor_ModuloResponseDto> editarProfesor_ModuloPorId(@PathVariable Integer id_profesor_modulo, @RequestBody Profesor_ModuloRequestDto datosActualizados){
		return ResponseEntity.ok(profesor_ModuloService.editarProfesor_ModuloPorId(id_profesor_modulo, datosActualizados));
	}
	
	@DeleteMapping("/{id_profesor_modulo}")
	public ResponseEntity<Void> eliminarProfesor_ModuloPorId(@PathVariable Integer id_profesor_modulo){
		profesor_ModuloService.eliminarProfesor_ModuloPorId(id_profesor_modulo);
			return ResponseEntity.noContent().build();
	}
}
