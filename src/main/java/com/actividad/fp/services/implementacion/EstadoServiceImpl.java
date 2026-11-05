package com.actividad.fp.services.implementacion;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.actividad.fp.dtos.EstadoRequestDto;
import com.actividad.fp.dtos.EstadoResponseDto;
import com.actividad.fp.entities.Estado;
import com.actividad.fp.repository.EstadoRepository;
import com.actividad.fp.services.EstadoService;

@Service
public class EstadoServiceImpl implements EstadoService {
	private final EstadoRepository estadoRepository;
	
	public EstadoServiceImpl(EstadoRepository estadoRepository) {
		this.estadoRepository = estadoRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<EstadoResponseDto> listarTodosLosEstados() {
		return estadoRepository.findAll().stream().map(this::convertirEstadoCogido).toList();
	}

	@Override
	@Transactional(readOnly = true)
	public EstadoResponseDto buscarEstadoPorId(Integer id_estado) {
		Estado estadoEncontrado = estadoRepository.findById(id_estado).orElseThrow(() -> new RuntimeException("Estado no encontrado."));
			return convertirEstadoCogido(estadoEncontrado);
	}

	@Override
	@Transactional
	public EstadoResponseDto crearEstado(EstadoRequestDto creacion) {
		Estado nuevoEstado = new Estado();
			nuevoEstado.setNombre(creacion.nombre());
			nuevoEstado.setDescripcion(creacion.descripcion());
				estadoRepository.save(nuevoEstado);
					return convertirEstadoCogido(nuevoEstado);
	}

	@Override
	@Transactional
	public EstadoResponseDto editarEstadoPorId(Integer id_estado, EstadoRequestDto datosActualizados) {
		Estado estadoEncontrado = estadoRepository.findById(id_estado).orElseThrow(() -> new RuntimeException("Estado no encontrado."));
			estadoEncontrado.setNombre(datosActualizados.nombre());
			estadoEncontrado.setDescripcion(datosActualizados.descripcion());
				estadoRepository.save(estadoEncontrado);
					return convertirEstadoCogido(estadoEncontrado);
	}

	@Override
	@Transactional
	public void eliminarEstadoPorId(Integer id_estado) {
		Estado estadoEncontrado = estadoRepository.findById(id_estado).orElseThrow(() -> new RuntimeException("Estado no encontrado."));
			estadoRepository.delete(estadoEncontrado);
	}

	private EstadoResponseDto convertirEstadoCogido(Estado estadoCogido) {
		return new EstadoResponseDto(
			estadoCogido.getId_estado(),
			estadoCogido.getNombre(),
			estadoCogido.getDescripcion()
		);
	}
}
