package com.actividad.fp.services;

import java.util.List;
import com.actividad.fp.dtos.AlumnoRequestDto;
import com.actividad.fp.dtos.AlumnoResponseDto;

public interface AlumnoService {
	List<AlumnoResponseDto> listarTodosLosAlumnos();
	
	AlumnoResponseDto buscarAlumnoPorId(Integer id_alumno);
	AlumnoResponseDto buscarAlumnoPorDni(String dni);
	
	AlumnoResponseDto crearAlumno(AlumnoRequestDto creacion);
	
	AlumnoResponseDto actualizarAlumnoPorId(Integer id_alumno, AlumnoRequestDto datos_actualizados);
	AlumnoResponseDto actualizarAlumnoPorDni(String dni, AlumnoRequestDto datos_actualizados);
	
	void eliminarAlumnoPorId(Integer id_alumno);
	void eliminarAlumnoPorDni(String dni);
}
