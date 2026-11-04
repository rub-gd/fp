package com.actividad.fp.services;

import java.util.List;
import com.actividad.fp.dtos.DepartamentoRequestDto;
import com.actividad.fp.dtos.DepartamentoResponseDto;

public interface DepartamentoService {
	List<DepartamentoResponseDto> listarTodosLosDepartamentos();
	
	DepartamentoResponseDto buscarDepartamentoPorId(Integer id_departamento);
	DepartamentoResponseDto buscarDepartamentoPorCodigo(String codigo);
	
	DepartamentoResponseDto crearDepartamento(DepartamentoRequestDto creacion);

	DepartamentoResponseDto editarDepartamentoPorId(Integer id_departamento, DepartamentoRequestDto datosActualizados);
	DepartamentoResponseDto editarDepartamentoPorCodigo(String codigo, DepartamentoRequestDto datosActualizados);
	
	void eliminarDepartamentoPorId(Integer id_departamento);
	void eliminarDepartamentoPorCodigo(String codigo);
}
