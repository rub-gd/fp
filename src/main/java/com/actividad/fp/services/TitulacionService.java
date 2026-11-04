package com.actividad.fp.services;

import java.util.List;
import com.actividad.fp.dtos.TitulacionRequestDto;
import com.actividad.fp.dtos.TitulacionResponseDto;

public interface TitulacionService {
	List<TitulacionResponseDto> listarTodasLasTitulaciones();
	
	TitulacionResponseDto buscarTitulacionPorId(Integer id_titulacion);
	TitulacionResponseDto buscarTitulacionPorCodigo(String codigo);
	TitulacionResponseDto buscarTitulacionPorDiminutivo(String diminutivo);
	
	TitulacionResponseDto crearTitulacion(TitulacionRequestDto creacion);

	TitulacionResponseDto editarTitulacionPorId(Integer id_titulacion, TitulacionRequestDto datosActualizados);
	TitulacionResponseDto editarTitulacionPorCodigo(String codigo, TitulacionRequestDto datosActualizados);
	TitulacionResponseDto editarTitulacionPorDiminutivo(String diminutivo, TitulacionRequestDto datosActualizados);
	
	void eliminarTitulacionPorId(Integer id_titulacion);
	void eliminarTitulacionPorCodigo(String codigo);
	void eliminarTitulacionPorDiminutivo(String diminutivo);
}
