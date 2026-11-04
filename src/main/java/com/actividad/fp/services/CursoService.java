package com.actividad.fp.services;

import java.util.List;

import com.actividad.fp.dtos.CursoRequestDto;
import com.actividad.fp.dtos.CursoResponseDto;

public interface CursoService {
	List<CursoResponseDto> listarTodosLosCursos();
	
	CursoResponseDto buscarCursoPorId(Integer id_curso);
	CursoResponseDto buscarCursoPorDiminutivo(String diminutivo);
	
	CursoResponseDto crearCurso(CursoRequestDto creacion);

	CursoResponseDto editarCursoPorId(Integer id_curso, CursoRequestDto datosActualizados);
	CursoResponseDto editarCursoPorDiminutivo(String diminutivo, CursoRequestDto datosActualizados);
	
	void eliminarCursoPorId(Integer id_curso);
	void eliminarCursoPorDiminutivo(String diminutivo);
}
