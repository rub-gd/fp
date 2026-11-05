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

import com.actividad.fp.dtos.Modulo_CursoRequestDto;
import com.actividad.fp.dtos.Modulo_CursoResponseDto;
import com.actividad.fp.services.Modulo_CursoService;

@RestController
@RequestMapping("/api/modulo_curso")
public class Modulo_CursoController {
	private final Modulo_CursoService modulo_CursoService;
	
	public Modulo_CursoController(Modulo_CursoService modulo_CursoService) {
		this.modulo_CursoService = modulo_CursoService;
	}
	
	@GetMapping
	public ResponseEntity<List<Modulo_CursoResponseDto>> listarTodosLosModulo_Cursos(){
		return ResponseEntity.ok(modulo_CursoService.listarTodosLosModulo_Cursos());
	}
	
	@GetMapping("/{id_modulo_curso}")
	public ResponseEntity<Modulo_CursoResponseDto> buscarModulo_CursoPorId(@PathVariable Integer id_modulo_curso){
		return ResponseEntity.ok(modulo_CursoService.buscarModulo_CursoPorId(id_modulo_curso));
	}
	
	@PostMapping
	public ResponseEntity<Modulo_CursoResponseDto> crearModulo_Curso(@RequestBody Modulo_CursoRequestDto creacion){
		return ResponseEntity.ok(modulo_CursoService.crearModulo_Curso(creacion));
	}
	
	@PutMapping("/{id_modulo_curso}")
	public ResponseEntity<Modulo_CursoResponseDto> editarModulo_CursoPorId(@PathVariable Integer id_modulo_curso, @RequestBody Modulo_CursoRequestDto datosActualizados){
		return ResponseEntity.ok(modulo_CursoService.editarModulo_CursoPorId(id_modulo_curso, datosActualizados));
	}
	
	@DeleteMapping("/{id_modulo_curso}")
	public ResponseEntity<Void> eliminarModulo_CursoPorId(@PathVariable Integer id_modulo_curso){
		modulo_CursoService.eliminarModulo_CursoPorId(id_modulo_curso);
			return ResponseEntity.noContent().build();
	}
}
