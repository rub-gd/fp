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

import com.actividad.fp.dtos.CursoRequestDto;
import com.actividad.fp.dtos.CursoResponseDto;
import com.actividad.fp.services.CursoService;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
	private final CursoService cursoService;
	
	public CursoController(CursoService cursoService) {
		this.cursoService = cursoService;
	}
	
	@GetMapping
	public ResponseEntity<List<CursoResponseDto>> obtenerTodos(){
		return ResponseEntity.ok(cursoService.listarTodosLosCursos());
	}
	
	@GetMapping("/{id_curso}")
	public ResponseEntity<CursoResponseDto> buscarCursoPorId(@PathVariable Integer id_curso){
		return ResponseEntity.ok(cursoService.buscarCursoPorId(id_curso));
	}
	
	@GetMapping("/diminutivo/{diminutivo}")
	public ResponseEntity<CursoResponseDto> buscarCursoPorDiminutivo(@PathVariable String diminutivo){
		return ResponseEntity.ok(cursoService.buscarCursoPorDiminutivo(diminutivo));
	}
	
	@PostMapping
	public ResponseEntity<CursoResponseDto> crearCurso(@RequestBody CursoRequestDto creacion){
		return ResponseEntity.ok(cursoService.crearCurso(creacion));
	}
	
	@PutMapping("/{id_curso}")
	public ResponseEntity<CursoResponseDto> editarCursoPorId(@PathVariable Integer id_curso, @RequestBody CursoRequestDto datosActualizados){
		return ResponseEntity.ok(cursoService.editarCursoPorId(id_curso, datosActualizados));
	}
	
	@PutMapping("/diminutivo/{diminutivo}")
	public ResponseEntity<CursoResponseDto> editarCursoPorDiminutivo(@PathVariable String diminutivo, @RequestBody CursoRequestDto datosActualizados){
		return ResponseEntity.ok(cursoService.editarCursoPorDiminutivo(diminutivo, datosActualizados));
	}
	
	@DeleteMapping("/{id_curso}")
	public ResponseEntity<Void> eliminarCursoPorId(@PathVariable Integer id_curso){
		cursoService.eliminarCursoPorId(id_curso);
			return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/diminutivo/{diminutivo}")
	public ResponseEntity<Void> eliminarCursoPorDiminutivo(@PathVariable String diminutivo){
		cursoService.eliminarCursoPorDiminutivo(diminutivo);
			return ResponseEntity.noContent().build();
	}
}
