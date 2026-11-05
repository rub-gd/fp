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

import com.actividad.fp.dtos.ModuloRequestDto;
import com.actividad.fp.dtos.ModuloResponseDto;
import com.actividad.fp.services.ModuloService;

@RestController
@RequestMapping("/api/modulos")
public class ModuloController {
	private final ModuloService moduloService;
	
	public ModuloController(ModuloService moduloService) {
		this.moduloService = moduloService;
	}
	
	@GetMapping
	public ResponseEntity<List<ModuloResponseDto>> obtenerTodos(){
		return ResponseEntity.ok(moduloService.listarTodosLosModulos());
	}
	
	@GetMapping("/{id_modulo}")
	public ResponseEntity<ModuloResponseDto> buscarModuloPorId(@PathVariable Integer id_modulo){
		return ResponseEntity.ok(moduloService.buscarModuloPorId(id_modulo));
	}
	
	@GetMapping("/codigo/{codigo}")
	public ResponseEntity<ModuloResponseDto> buscarModuloPorCodigo(@PathVariable String codigo){
		return ResponseEntity.ok(moduloService.buscarModuloPorCodigo(codigo));
	}
	
	@GetMapping("/diminutivo/{diminutivo}")
	public ResponseEntity<ModuloResponseDto> buscarModuloPorDiminutivo(@PathVariable String diminutivo){
		return ResponseEntity.ok(moduloService.buscarModuloPorDiminutivo(diminutivo));
	}
	
	@PostMapping
	public ResponseEntity<ModuloResponseDto> crearModulo(@RequestBody ModuloRequestDto creacion){
		return ResponseEntity.ok(moduloService.crearModulo(creacion));
	}
	
	@PutMapping("/{id_modulo}")
	public ResponseEntity<ModuloResponseDto> editarModuloPorId(@PathVariable Integer id_modulo, @RequestBody ModuloRequestDto datosActualizados){
		return ResponseEntity.ok(moduloService.editarModuloPorId(id_modulo, datosActualizados));
	}
	
	@PutMapping("/codigo/{codigo}")
	public ResponseEntity<ModuloResponseDto> editarModuloPorCodigo(@PathVariable String codigo, @RequestBody ModuloRequestDto datosActualizados){
		return ResponseEntity.ok(moduloService.editarModuloPorCodigo(codigo, datosActualizados));
	}
	
	@PutMapping("/diminutivo/{diminutivo}")
	public ResponseEntity<ModuloResponseDto> editarModuloPorDiminutivo(@PathVariable String diminutivo, @RequestBody ModuloRequestDto datosActualizados){
		return ResponseEntity.ok(moduloService.editarModuloPorDiminutivo(diminutivo, datosActualizados));
	}
	
	@DeleteMapping("/{id_modulo}")
	public ResponseEntity<Void> eliminarModuloPorId(@PathVariable Integer id_modulo){
		moduloService.eliminarModuloPorId(id_modulo);
			return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/codigo/{codigo}")
	public ResponseEntity<Void> eliminarModuloPorCodigo(@PathVariable String codigo){
		moduloService.eliminarModuloPorCodigo(codigo);
			return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/diminutivo/{diminutivo}")
	public ResponseEntity<Void> eliminarModuloPorDiminutivo(@PathVariable String diminutivo){
		moduloService.eliminarModuloPorDiminutivo(diminutivo);
			return ResponseEntity.noContent().build();
	}
}
