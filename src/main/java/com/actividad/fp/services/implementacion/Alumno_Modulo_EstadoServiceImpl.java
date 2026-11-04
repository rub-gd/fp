package com.actividad.fp.services.implementacion;

import java.util.List;

import com.actividad.fp.dtos.Alumno_Modulo_EstadoRequestDto;
import com.actividad.fp.dtos.Alumno_Modulo_EstadoResponseDto;
import com.actividad.fp.entities.Alumno_Modulo_Estado;
import com.actividad.fp.services.Alumno_Modulo_EstadoService;

public class Alumno_Modulo_EstadoServiceImpl implements Alumno_Modulo_EstadoService {

	@Override
	public List<Alumno_Modulo_EstadoResponseDto> listarTodosLosAlumno_Modulo_Estados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alumno_Modulo_EstadoResponseDto buscarAlumno_Modulo_EstadoPorId(Integer id_alumno_modulo_estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alumno_Modulo_EstadoResponseDto crearAlumno_Modulo_Estado(Alumno_Modulo_EstadoRequestDto creacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alumno_Modulo_EstadoResponseDto editarAlumno_Modulo_EstadoPorId(Integer id_alumno_modulo_estado,
			Alumno_Modulo_EstadoRequestDto datosActualizados) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarAlumno_Modulo_EstadoPorId(Integer id_alumno_modulo_estado) {
		// TODO Auto-generated method stub

	}

	private Alumno_Modulo_EstadoResponseDto convertirAlumno_Modulo_EstadoResponseCogido(Alumno_Modulo_Estado alumno_Modulo_EstadoCogido) {
		return new Alumno_Modulo_EstadoResponseDto(
			alumno_Modulo_EstadoCogido.getId_alumno_modulo_estado(),
			alumno_Modulo_EstadoCogido.getAlumno() == null ? null : alumno_Modulo_EstadoCogido.getAlumno().getId_alumno(),
			alumno_Modulo_EstadoCogido.getModulo() == null ? null : alumno_Modulo_EstadoCogido.getModulo().getId_modulo(),
			alumno_Modulo_EstadoCogido.getEstado() == null ? null : alumno_Modulo_EstadoCogido.getEstado().getId_estado()
		);
	}
}
