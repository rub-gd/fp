package com.actividad.fp.services.implementacion;

import java.util.List;

import org.springframework.stereotype.Service;

import com.actividad.fp.dtos.DepartamentoRequestDto;
import com.actividad.fp.dtos.DepartamentoResponseDto;
import com.actividad.fp.entities.Departamento;
import com.actividad.fp.repository.DepartamentoRepository;
import com.actividad.fp.services.DepartamentoService;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	private final DepartamentoRepository departamentoRepository;
	
	public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}
	
	@Override
	public List<DepartamentoResponseDto> listarTodosLosDepartamentos() {
		return departamentoRepository.findAll().stream().map(this::convertirDepartamentoCogido).toList();
	}

	@Override
	public DepartamentoResponseDto buscarDepartamentoPorId(Integer id_departamento) {
		Departamento departamentoEncontrado = departamentoRepository.findById(id_departamento).orElseThrow(() -> new RuntimeException("Departamento no encontrado."));
			return convertirDepartamentoCogido(departamentoEncontrado);
	}

	@Override
	public DepartamentoResponseDto buscarDepartamentoPorCodigo(String codigo) {
		Departamento departamentoEncontrado = departamentoRepository.findByCodigo(codigo).orElseThrow(() -> new RuntimeException("Departamento no encontrado."));
			return convertirDepartamentoCogido(departamentoEncontrado);
	}

	@Override
	public DepartamentoResponseDto crearDepartamento(DepartamentoRequestDto creacion) {
		Departamento nuevoDepartamento = new Departamento();
			nuevoDepartamento.setCodigo(creacion.codigo());
			nuevoDepartamento.setNombre(creacion.nombre());
			nuevoDepartamento.setDescripcion(creacion.descripcion());
			nuevoDepartamento.setTlf(creacion.tlf());
				departamentoRepository.save(nuevoDepartamento);
					return convertirDepartamentoCogido(nuevoDepartamento);
	}

	@Override
	public DepartamentoResponseDto editarDepartamentoPorId(Integer id_departamento, DepartamentoRequestDto datosActualizados) {
		Departamento departamentoEncontrado = departamentoRepository.findById(id_departamento).orElseThrow(() -> new RuntimeException("Departamento no encontrado."));
			departamentoEncontrado.setCodigo(datosActualizados.codigo());
			departamentoEncontrado.setNombre(datosActualizados.nombre());
			departamentoEncontrado.setDescripcion(datosActualizados.descripcion());
			departamentoEncontrado.setTlf(datosActualizados.tlf());
				departamentoRepository.save(departamentoEncontrado);
					return convertirDepartamentoCogido(departamentoEncontrado);
	}

	@Override
	public DepartamentoResponseDto editarDepartamentoPorCodigo(String codigo, DepartamentoRequestDto datosActualizados) {
		Departamento departamentoEncontrado = departamentoRepository.findByCodigo(codigo).orElseThrow(() -> new RuntimeException("Departamento no encontrado."));
			departamentoEncontrado.setCodigo(datosActualizados.codigo());
			departamentoEncontrado.setNombre(datosActualizados.nombre());
			departamentoEncontrado.setDescripcion(datosActualizados.descripcion());
			departamentoEncontrado.setTlf(datosActualizados.tlf());
				departamentoRepository.save(departamentoEncontrado);
					return convertirDepartamentoCogido(departamentoEncontrado);
	}

	@Override
	public void eliminarDepartamentoPorId(Integer id_departamento) {
		Departamento departamentoEncontrado = departamentoRepository.findById(id_departamento).orElseThrow(() -> new RuntimeException("Departamento no encontrado."));
			departamentoRepository.delete(departamentoEncontrado);
	}

	@Override
	public void eliminarDepartamentoPorCodigo(String codigo) {
		Departamento departamentoEncontrado = departamentoRepository.findByCodigo(codigo).orElseThrow(() -> new RuntimeException("Departamento no encontrado."));
			departamentoRepository.delete(departamentoEncontrado);
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
