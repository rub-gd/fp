package com.actividad.fp.services;

import java.util.List;
import com.actividad.fp.dtos.FamiliaRequestDto;
import com.actividad.fp.dtos.FamiliaResponseDto;

public interface FamiliaService {
	List<FamiliaResponseDto> listarTodasLasFamilias();
	
	FamiliaResponseDto buscarFamiliaPorId(Integer id_familia);
	
	FamiliaResponseDto crearFamilia(FamiliaRequestDto creacion);

	FamiliaResponseDto editarFamiliaPorId(Integer id_familia, FamiliaRequestDto datosActualizados);
	
	void eliminarFamiliaPorId(Integer id_familia);
}
