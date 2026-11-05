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

import com.actividad.fp.dtos.EstadoRequestDto;
import com.actividad.fp.dtos.EstadoResponseDto;
import com.actividad.fp.services.EstadoService;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {
	private final EstadoService estadoService;
	
	public EstadoController(EstadoService estadoService) {
		this.estadoService = estadoService;
	}
	
	@GetMapping
	public ResponseEntity<List<EstadoResponseDto>> obtenerTodos(){
		return ResponseEntity.ok(estadoService.listarTodosLosEstados());
	}
	
	@GetMapping("/{id_estado}")
	public ResponseEntity<EstadoResponseDto> buscarEstadoPorId(@PathVariable Integer id_estado){
		return ResponseEntity.ok(estadoService.buscarEstadoPorId(id_estado));
	}
	
	@PostMapping
	public ResponseEntity<EstadoResponseDto> crearEstado(@RequestBody EstadoRequestDto creacion){
		return ResponseEntity.ok(estadoService.crearEstado(creacion));
	}
	
	@PutMapping("/{id_estado}")
	public ResponseEntity<EstadoResponseDto> editarEstadoPorId(@PathVariable Integer id_estado, @RequestBody EstadoRequestDto datosActualizados){
		return ResponseEntity.ok(estadoService.editarEstadoPorId(id_estado, datosActualizados));
	}
	
	@DeleteMapping("/{id_estado}")
	public ResponseEntity<Void> eliminarEstadoPorId(@PathVariable Integer id_estado){
		estadoService.eliminarEstadoPorId(id_estado);
			return ResponseEntity.noContent().build();
	}
}
