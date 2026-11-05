package com.actividad.fp.services.implementacion;

import java.util.List;

import org.springframework.stereotype.Service;

import com.actividad.fp.dtos.ModuloRequestDto;
import com.actividad.fp.dtos.ModuloResponseDto;
import com.actividad.fp.entities.Modulo;
import com.actividad.fp.repository.ModuloRepository;
import com.actividad.fp.services.ModuloService;

@Service
public class ModuloServiceImpl implements ModuloService {
	private final ModuloRepository moduloRepository;
	
	public ModuloServiceImpl(ModuloRepository moduloRepository) {
		this.moduloRepository = moduloRepository;
	}
	
	@Override
	public List<ModuloResponseDto> listarTodosLosModulos() {
		return moduloRepository.findAll().stream().map(this::convertirModuloCogido).toList();
	}

	@Override
	public ModuloResponseDto buscarModuloPorId(Integer id_modulo) {
		Modulo moduloEncontrado = moduloRepository.findById(id_modulo).orElseThrow(() -> new RuntimeException("Modulo no encontrado."));
			return convertirModuloCogido(moduloEncontrado);
	}

	@Override
	public ModuloResponseDto buscarModuloPorCodigo(String codigo) {
		Modulo moduloEncontrado = moduloRepository.findByCodigo(codigo).stream().findFirst().orElseThrow(() -> new RuntimeException("Modulo no encontrado."));
			return convertirModuloCogido(moduloEncontrado);
	}

	@Override
	public ModuloResponseDto buscarModuloPorDiminutivo(String diminutivo) {
		Modulo moduloEncontrado = moduloRepository.findByDiminutivo(diminutivo).stream().findFirst().orElseThrow(() -> new RuntimeException("Modulo no encontrado."));
			return convertirModuloCogido(moduloEncontrado);
	}

	@Override
	public ModuloResponseDto crearModulo(ModuloRequestDto creacion) {
		Modulo nuevoModulo = new Modulo();
			nuevoModulo.setCodigo(creacion.codigo());
			nuevoModulo.setDiminutivo(creacion.diminutivo());
			nuevoModulo.setNombre(creacion.nombre());
			nuevoModulo.setDescripcion(creacion.descripcion());
			nuevoModulo.setHoras_semanales(creacion.horas_semanales());
			nuevoModulo.setCreditos(creacion.creditos());
				moduloRepository.save(nuevoModulo);
					return convertirModuloCogido(nuevoModulo);
	}

	@Override
	public ModuloResponseDto editarModuloPorId(Integer id_modulo, ModuloRequestDto datosActualizados) {
		Modulo moduloEncontrado = moduloRepository.findById(id_modulo).orElseThrow(() -> new RuntimeException("Modulo no encontrado."));
			moduloEncontrado.setCodigo(datosActualizados.codigo());
			moduloEncontrado.setDiminutivo(datosActualizados.diminutivo());
			moduloEncontrado.setNombre(datosActualizados.nombre());
			moduloEncontrado.setDescripcion(datosActualizados.descripcion());
			moduloEncontrado.setHoras_semanales(datosActualizados.horas_semanales());
			moduloEncontrado.setCreditos(datosActualizados.creditos());
				moduloRepository.save(moduloEncontrado);
					return convertirModuloCogido(moduloEncontrado);
	}

	@Override
	public ModuloResponseDto editarModuloPorCodigo(String codigo, ModuloRequestDto datosActualizados) {
		Modulo moduloEncontrado = moduloRepository.findByCodigo(codigo).stream().findFirst().orElseThrow(() -> new RuntimeException("Modulo no encontrado."));
			moduloEncontrado.setCodigo(datosActualizados.codigo());
			moduloEncontrado.setDiminutivo(datosActualizados.diminutivo());
			moduloEncontrado.setNombre(datosActualizados.nombre());
			moduloEncontrado.setDescripcion(datosActualizados.descripcion());
			moduloEncontrado.setHoras_semanales(datosActualizados.horas_semanales());
			moduloEncontrado.setCreditos(datosActualizados.creditos());
				moduloRepository.save(moduloEncontrado);
					return convertirModuloCogido(moduloEncontrado);
	}

	@Override
	public ModuloResponseDto editarModuloPorDiminutivo(String diminutivo, ModuloRequestDto datosActualizados) {
		Modulo moduloEncontrado = moduloRepository.findByDiminutivo(diminutivo).stream().findFirst().orElseThrow(() -> new RuntimeException("Modulo no encontrado."));
			moduloEncontrado.setCodigo(datosActualizados.codigo());
			moduloEncontrado.setDiminutivo(datosActualizados.diminutivo());
			moduloEncontrado.setNombre(datosActualizados.nombre());
			moduloEncontrado.setDescripcion(datosActualizados.descripcion());
			moduloEncontrado.setHoras_semanales(datosActualizados.horas_semanales());
			moduloEncontrado.setCreditos(datosActualizados.creditos());
				moduloRepository.save(moduloEncontrado);
					return convertirModuloCogido(moduloEncontrado);
	}

	@Override
	public void eliminarModuloPorId(Integer id_modulo) {
		Modulo moduloEncontrado = moduloRepository.findById(id_modulo).orElseThrow(() -> new RuntimeException("Modulo no encontrado."));
			moduloRepository.delete(moduloEncontrado);
	}

	@Override
	public void eliminarModuloPorCodigo(String codigo) {
		Modulo moduloEncontrado = moduloRepository.findByCodigo(codigo).stream().findFirst().orElseThrow(() -> new RuntimeException("Modulo no encontrado."));
			moduloRepository.delete(moduloEncontrado);
	}

	@Override
	public void eliminarModuloPorDiminutivo(String diminutivo) {
		Modulo moduloEncontrado = moduloRepository.findByDiminutivo(diminutivo).stream().findFirst().orElseThrow(() -> new RuntimeException("Modulo no encontrado."));
			moduloRepository.delete(moduloEncontrado);
	}

	private ModuloResponseDto convertirModuloCogido(Modulo moduloCogido) {
		return new ModuloResponseDto(
			moduloCogido.getId_modulo(),
			moduloCogido.getCodigo(),
			moduloCogido.getDiminutivo(),
			moduloCogido.getNombre(),
			moduloCogido.getDescripcion(),
			moduloCogido.getHoras_semanales(),
			moduloCogido.getCreditos()
		);
	}
}
