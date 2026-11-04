package com.actividad.fp.services;

import java.util.List;
import com.actividad.fp.dtos.EstadoRequestDto;
import com.actividad.fp.dtos.EstadoResponseDto;

public interface EstadoService {
	List<EstadoResponseDto> listarTodosLosEstados();
	
	EstadoResponseDto buscarEstadoPorId(Integer id_estado);
	
	EstadoResponseDto crearEstado(EstadoRequestDto creacion);

	EstadoResponseDto editarEstadoPorId(Integer id_estado, EstadoRequestDto datosActualizados);
	
	void eliminarEstadoPorId(Integer id_estado);
}
