package com.actividad.fp.services.implementacion;

import java.util.List;

import com.actividad.fp.dtos.AlumnoRequestDto;
import com.actividad.fp.dtos.AlumnoResponseDto;
import com.actividad.fp.services.AlumnoService;

public class AlumnoServiceImpl implements AlumnoService {

	@Override
	public List<AlumnoResponseDto> listarTodosLosAlumnos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlumnoResponseDto buscarAlumnoPorId(Integer id_alumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlumnoResponseDto buscarAlumnoPorDni(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlumnoResponseDto crearAlumno(AlumnoRequestDto creacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlumnoResponseDto actualizarAlumnoPorId(Integer id_alumno, AlumnoRequestDto datos_actualizados) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlumnoResponseDto actualizarAlumnoPorDni(String dni, AlumnoRequestDto datos_actualizados) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarAlumnoPorId(Integer id_alumno) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarAlumnoPorDni(String dni) {
		// TODO Auto-generated method stub

	}

}
