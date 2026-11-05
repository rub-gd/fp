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

import com.actividad.fp.dtos.TitulacionRequestDto;
import com.actividad.fp.dtos.TitulacionResponseDto;
import com.actividad.fp.services.TitulacionService;

@RestController
@RequestMapping("/api/titulaciones")
public class TitulacionController {
	private final TitulacionService titulacionService;
	
	public TitulacionController(TitulacionService titulacionService) {
		this.titulacionService = titulacionService;
	}
	
	@GetMapping
	public ResponseEntity<List<TitulacionResponseDto>> obtenerTodas(){
		return ResponseEntity.ok(titulacionService.listarTodasLasTitulaciones());
	}
	
	@GetMapping("/{id_titulacion}")
	public ResponseEntity<TitulacionResponseDto> buscarTitulacionPorId(@PathVariable Integer id_titulacion){
		return ResponseEntity.ok(titulacionService.buscarTitulacionPorId(id_titulacion));
	}
	
	@GetMapping("/codigo/{codigo}")
	public ResponseEntity<TitulacionResponseDto> buscarTitulacionPorCodigo(@PathVariable String codigo){
		return ResponseEntity.ok(titulacionService.buscarTitulacionPorCodigo(codigo));
	}
	
	@GetMapping("/diminutivo/{diminutivo}")
	public ResponseEntity<TitulacionResponseDto> buscarTitulacionPorDiminutivo(@PathVariable String diminutivo){
		return ResponseEntity.ok(titulacionService.buscarTitulacionPorDiminutivo(diminutivo));
	}
	
	@PostMapping
	public ResponseEntity<TitulacionResponseDto> crearTitulacion(@RequestBody TitulacionRequestDto creacion){
		return ResponseEntity.ok(titulacionService.crearTitulacion(creacion));
	}
	
	@PutMapping("/{id_titulacion}")
	public ResponseEntity<TitulacionResponseDto> editarTitulacionPorId(@PathVariable Integer id_titulacion, @RequestBody TitulacionRequestDto datosActualizados){
		return ResponseEntity.ok(titulacionService.editarTitulacionPorId(id_titulacion, datosActualizados));
	}
	
	@PutMapping("/codigo/{codigo}")
	public ResponseEntity<TitulacionResponseDto> editarTitulacionPorCodigo(@PathVariable String codigo, @RequestBody TitulacionRequestDto datosActualizados){
		return ResponseEntity.ok(titulacionService.editarTitulacionPorCodigo(codigo, datosActualizados));
	}
	
	@PutMapping("/diminutivo/{diminutivo}")
	public ResponseEntity<TitulacionResponseDto> editarTitulacionPorDiminutivo(@PathVariable String diminutivo, @RequestBody TitulacionRequestDto datosActualizados){
		return ResponseEntity.ok(titulacionService.editarTitulacionPorDiminutivo(diminutivo, datosActualizados));
	}
	
	@DeleteMapping("/{id_titulacion}")
	public ResponseEntity<Void> eliminarTitulacionPorId(@PathVariable Integer id_titulacion){
		titulacionService.eliminarTitulacionPorId(id_titulacion);
			return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/codigo/{codigo}")
	public ResponseEntity<Void> eliminarTitulacionPorCodigo(@PathVariable String codigo){
		titulacionService.eliminarTitulacionPorCodigo(codigo);
			return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/diminutivo/{diminutivo}")
	public ResponseEntity<Void> eliminarTitulacionPorDiminutivo(@PathVariable String diminutivo){
		titulacionService.eliminarTitulacionPorDiminutivo(diminutivo);
			return ResponseEntity.noContent().build();
	}
}
