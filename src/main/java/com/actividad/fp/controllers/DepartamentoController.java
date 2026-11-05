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

import com.actividad.fp.dtos.DepartamentoRequestDto;
import com.actividad.fp.dtos.DepartamentoResponseDto;
import com.actividad.fp.services.DepartamentoService;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {
	private final DepartamentoService departamentoService;
	
	public DepartamentoController(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}
	
	@GetMapping
	public ResponseEntity<List<DepartamentoResponseDto>> obtenerTodos(){
		return ResponseEntity.ok(departamentoService.listarTodosLosDepartamentos());
	}
	
	@GetMapping("/{id_departamento}")
	public ResponseEntity<DepartamentoResponseDto> buscarDepartamentoPorId(@PathVariable Integer id_departamento){
		return ResponseEntity.ok(departamentoService.buscarDepartamentoPorId(id_departamento));
	}
	
	@GetMapping("/codigo/{codigo}")
	public ResponseEntity<DepartamentoResponseDto> buscarDepartamentoPorCodigo(@PathVariable String codigo){
		return ResponseEntity.ok(departamentoService.buscarDepartamentoPorCodigo(codigo));
	}
	
	@PostMapping
	public ResponseEntity<DepartamentoResponseDto> crearDepartamento(@RequestBody DepartamentoRequestDto creacion){
		return ResponseEntity.ok(departamentoService.crearDepartamento(creacion));
	}
	
	@PutMapping("/{id_departamento}")
	public ResponseEntity<DepartamentoResponseDto> editarDepartamentoPorId(@PathVariable Integer id_departamento, @RequestBody DepartamentoRequestDto datosActualizados){
		return ResponseEntity.ok(departamentoService.editarDepartamentoPorId(id_departamento, datosActualizados));
	}
	
	@PutMapping("/codigo/{codigo}")
	public ResponseEntity<DepartamentoResponseDto> editarDepartamentoPorCodigo(@PathVariable String codigo, @RequestBody DepartamentoRequestDto datosActualizados){
		return ResponseEntity.ok(departamentoService.editarDepartamentoPorCodigo(codigo, datosActualizados));
	}
	
	@DeleteMapping("/{id_departamento}")
	public ResponseEntity<Void> eliminarDepartamentoPorId(@PathVariable Integer id_departamento){
		departamentoService.eliminarDepartamentoPorId(id_departamento);
			return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/codigo/{codigo}")
	public ResponseEntity<Void> eliminarDepartamentoPorCodigo(@PathVariable String codigo){
		departamentoService.eliminarDepartamentoPorCodigo(codigo);
			return ResponseEntity.noContent().build();
	}
}
