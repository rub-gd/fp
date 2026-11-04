package com.actividad.fp.services.implementacion;

import java.util.List;

import com.actividad.fp.dtos.DepartamentoRequestDto;
import com.actividad.fp.dtos.DepartamentoResponseDto;
import com.actividad.fp.entities.Departamento;
import com.actividad.fp.services.DepartamentoService;

public class DepartamentoServiceImpl implements DepartamentoService {

	@Override
	public List<DepartamentoResponseDto> listarTodosLosDepartamentos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartamentoResponseDto buscarDepartamentoPorId(Integer id_departamento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartamentoResponseDto buscarDepartamentoPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartamentoResponseDto crearDepartamento(DepartamentoRequestDto creacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartamentoResponseDto editarDepartamentoPorId(Integer id_departamento,
			DepartamentoRequestDto datosActualizados) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartamentoResponseDto editarDepartamentoPorCodigo(String codigo,
			DepartamentoRequestDto datosActualizados) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarDepartamentoPorId(Integer id_departamento) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarDepartamentoPorCodigo(String codigo) {
		// TODO Auto-generated method stub

	}

	private DepartamentoResponseDto convertirDepartamentoCogido(Departamento departamentoCogido) {
		return new DepartamentoResponseDto(
			departamentoCogido.getId_departamento(),
			departamentoCogido.getCodigo(),
			departamentoCogido.getNombre(),
			departamentoCogido.getDescripcion(),
			departamentoCogido.getTlf()
		);
	}
}
