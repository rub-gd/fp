package com.actividad.fp.services;

import java.util.List;
import com.actividad.fp.dtos.ProfesorRequestDto;
import com.actividad.fp.dtos.ProfesorResponseDto;

public interface ProfesorService {
	List<ProfesorResponseDto> listarTodosLosProfesores();
	
	ProfesorResponseDto buscarProfesorPorId(Integer id_profesor);
	ProfesorResponseDto buscarProfesorPorDni(String dni);
	
	ProfesorResponseDto crearProfesor(ProfesorRequestDto creacion);

	ProfesorResponseDto editarProfesorPorId(Integer id_profesor, ProfesorRequestDto datosActualizados);
	ProfesorResponseDto editarProfesorPorDni(String dni, ProfesorRequestDto datosActualizados);
	
	void eliminarProfesorPorId(Integer id_profesor);
	void eliminarProfesorPorDni(String dni);
}
