package com.actividad.fp.services;

import java.util.List;
import com.actividad.fp.dtos.Modulo_CursoRequestDto;
import com.actividad.fp.dtos.Modulo_CursoResponseDto;

public interface Modulo_CursoService {
	List<Modulo_CursoResponseDto> listarTodosLosModulo_Cursos();
	
	Modulo_CursoResponseDto buscarModulo_CursoPorId(Integer id_modulo_curso);
	
	Modulo_CursoResponseDto crearModulo_Curso(Modulo_CursoRequestDto creacion);

	Modulo_CursoResponseDto editarModulo_CursoPorId(Integer id_modulo_curso, Modulo_CursoRequestDto datosActualizados);
	
	void eliminarModulo_CursoPorId(Integer id_modulo_curso);
}
