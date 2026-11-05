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

import com.actividad.fp.dtos.FamiliaRequestDto;
import com.actividad.fp.dtos.FamiliaResponseDto;
import com.actividad.fp.services.FamiliaService;

@RestController
@RequestMapping("/api/familias")
public class FamiliaController {
	private final FamiliaService familiaService;
	
	public FamiliaController(FamiliaService familiaService) {
		this.familiaService = familiaService;
	}
	
	@GetMapping
	public ResponseEntity<List<FamiliaResponseDto>> obtenerTodas(){
		return ResponseEntity.ok(familiaService.listarTodasLasFamilias());
	}
	
	@GetMapping("/{id_familia}")
	public ResponseEntity<FamiliaResponseDto> buscarFamiliaPorId(@PathVariable Integer id_familia){
		return ResponseEntity.ok(familiaService.buscarFamiliaPorId(id_familia));
	}
	
	@PostMapping
	public ResponseEntity<FamiliaResponseDto> crearFamilia(@RequestBody FamiliaRequestDto creacion){
		return ResponseEntity.ok(familiaService.crearFamilia(creacion));
	}
	
	@PutMapping("/{id_familia}")
	public ResponseEntity<FamiliaResponseDto> editarFamiliaPorId(@PathVariable Integer id_familia, @RequestBody FamiliaRequestDto datosActualizados){
		return ResponseEntity.ok(familiaService.editarFamiliaPorId(id_familia, datosActualizados));
	}
	
	@DeleteMapping("/{id_familia}")
	public ResponseEntity<Void> eliminarFamiliaPorId(@PathVariable Integer id_familia){
		familiaService.eliminarFamiliaPorId(id_familia);
			return ResponseEntity.noContent().build();
	}
}
