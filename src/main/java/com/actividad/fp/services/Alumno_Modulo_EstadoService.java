package com.actividad.fp.services;

import java.util.List;
import com.actividad.fp.dtos.Alumno_Modulo_EstadoRequestDto;
import com.actividad.fp.dtos.Alumno_Modulo_EstadoResponseDto;

public interface Alumno_Modulo_EstadoService {
	List<Alumno_Modulo_EstadoResponseDto> listarTodosLosAlumno_Modulo_Estados();
	
	Alumno_Modulo_EstadoResponseDto buscarAlumno_Modulo_EstadoPorId(Integer id_alumno_modulo_estado);
	
	Alumno_Modulo_EstadoResponseDto crearAlumno_Modulo_Estado(Alumno_Modulo_EstadoRequestDto creacion);

	Alumno_Modulo_EstadoResponseDto editarAlumno_Modulo_EstadoPorId(Integer id_alumno_modulo_estado, Alumno_Modulo_EstadoRequestDto datosActualizados);
	
	void eliminarAlumno_Modulo_EstadoPorId(Integer id_alumno_modulo_estado);
}
