package com.actividad.fp.services;

import java.util.List;
import com.actividad.fp.dtos.ModuloRequestDto;
import com.actividad.fp.dtos.ModuloResponseDto;

public interface ModuloService {
	List<ModuloResponseDto> listarTodosLosModulos();
	
	ModuloResponseDto buscarModuloPorId(Integer id_modulo);
	ModuloResponseDto buscarModuloPorCodigo(String codigo);
	ModuloResponseDto buscarModuloPorDiminutivo(String diminutivo);
	
	ModuloResponseDto crearModulo(ModuloRequestDto creacion);

	ModuloResponseDto editarModuloPorId(Integer id_modulo, ModuloRequestDto datosActualizados);
	ModuloResponseDto editarModuloPorCodigo(String codigo, ModuloRequestDto datosActualizados);
	ModuloResponseDto editarModuloPorDiminutivo(String diminutivo, ModuloRequestDto datosActualizados);
	
	void eliminarModuloPorId(Integer id_modulo);
	void eliminarModuloPorCodigo(String codigo);
	void eliminarModuloPorDiminutivo(String diminutivo);
}
