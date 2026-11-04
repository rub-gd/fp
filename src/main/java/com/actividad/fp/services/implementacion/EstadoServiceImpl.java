package com.actividad.fp.services.implementacion;

import java.util.List;

import com.actividad.fp.dtos.EstadoRequestDto;
import com.actividad.fp.dtos.EstadoResponseDto;
import com.actividad.fp.entities.Estado;
import com.actividad.fp.services.EstadoService;

public class EstadoServiceImpl implements EstadoService {

	@Override
	public List<EstadoResponseDto> listarTodosLosEstados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EstadoResponseDto buscarEstadoPorId(Integer id_estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EstadoResponseDto crearEstado(EstadoRequestDto creacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EstadoResponseDto editarEstadoPorId(Integer id_estado, EstadoRequestDto datosActualizados) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarEstadoPorId(Integer id_estado) {
		// TODO Auto-generated method stub

	}

	private EstadoResponseDto convertirEstadoCogido(Estado estadoCogido) {
		return new EstadoResponseDto(
			estadoCogido.getId_estado(),
			estadoCogido.getNombre(),
			estadoCogido.getDescripcion()
		);
	}
}
