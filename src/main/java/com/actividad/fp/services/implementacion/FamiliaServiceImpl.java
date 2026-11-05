package com.actividad.fp.services.implementacion;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.actividad.fp.dtos.FamiliaRequestDto;
import com.actividad.fp.dtos.FamiliaResponseDto;
import com.actividad.fp.entities.Familia;
import com.actividad.fp.repository.FamiliaRepository;
import com.actividad.fp.services.FamiliaService;

@Service
public class FamiliaServiceImpl implements FamiliaService {
	private final FamiliaRepository familiaRepository;
	
	public FamiliaServiceImpl(FamiliaRepository familiaRepository) {
		this.familiaRepository = familiaRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<FamiliaResponseDto> listarTodasLasFamilias() {
		return familiaRepository.findAll().stream().map(this::convertirFamiliaCogida).toList();
	}

	@Override
	@Transactional(readOnly = true)
	public FamiliaResponseDto buscarFamiliaPorId(Integer id_familia) {
		Familia familiaEncontrada = familiaRepository.findById(id_familia).orElseThrow(() -> new RuntimeException("Familia no encontrada."));
			return convertirFamiliaCogida(familiaEncontrada);
	}

	@Override
	@Transactional
	public FamiliaResponseDto crearFamilia(FamiliaRequestDto creacion) {
		Familia nuevaFamilia = new Familia();
			nuevaFamilia.setNombre_padre(creacion.nombre_padre());
			nuevaFamilia.setApellidos_padre(creacion.apellidos_padre());
			nuevaFamilia.setEmail_padre(creacion.email_padre());
			nuevaFamilia.setTlf_padre(creacion.tlf_padre());
			nuevaFamilia.setDireccion_padre(creacion.direccion_padre());
			nuevaFamilia.setCodigo_postal_padre(creacion.codigo_postal_padre());
			nuevaFamilia.setProvincia_padre(creacion.provincia_padre());
			nuevaFamilia.setNombre_madre(creacion.nombre_madre());
			nuevaFamilia.setApellidos_madre(creacion.apellidos_madre());
			nuevaFamilia.setEmail_madre(creacion.email_madre());
			nuevaFamilia.setTlf_madre(creacion.tlf_madre());
			nuevaFamilia.setDireccion_madre(creacion.direccion_madre());
			nuevaFamilia.setCodigo_postal_madre(creacion.codigo_postal_madre());
			nuevaFamilia.setProvincia_madre(creacion.provincia_madre());
			nuevaFamilia.setSon_separados(creacion.son_separados());
			nuevaFamilia.setEs_compartida(creacion.es_compartida());
			nuevaFamilia.setEs_padre(creacion.es_padre());
			nuevaFamilia.setEs_madre(creacion.es_madre());
				familiaRepository.save(nuevaFamilia);
					return convertirFamiliaCogida(nuevaFamilia);
	}

	@Override
	@Transactional
	public FamiliaResponseDto editarFamiliaPorId(Integer id_familia, FamiliaRequestDto datosActualizados) {
		Familia familiaEncontrada = familiaRepository.findById(id_familia).orElseThrow(() -> new RuntimeException("Familia no encontrada."));
			familiaEncontrada.setNombre_padre(datosActualizados.nombre_padre());
			familiaEncontrada.setApellidos_padre(datosActualizados.apellidos_padre());
			familiaEncontrada.setEmail_padre(datosActualizados.email_padre());
			familiaEncontrada.setTlf_padre(datosActualizados.tlf_padre());
			familiaEncontrada.setDireccion_padre(datosActualizados.direccion_padre());
			familiaEncontrada.setCodigo_postal_padre(datosActualizados.codigo_postal_padre());
			familiaEncontrada.setProvincia_padre(datosActualizados.provincia_padre());
			familiaEncontrada.setNombre_madre(datosActualizados.nombre_madre());
			familiaEncontrada.setApellidos_madre(datosActualizados.apellidos_madre());
			familiaEncontrada.setEmail_madre(datosActualizados.email_madre());
			familiaEncontrada.setTlf_madre(datosActualizados.tlf_madre());
			familiaEncontrada.setDireccion_madre(datosActualizados.direccion_madre());
			familiaEncontrada.setCodigo_postal_madre(datosActualizados.codigo_postal_madre());
			familiaEncontrada.setProvincia_madre(datosActualizados.provincia_madre());
			familiaEncontrada.setSon_separados(datosActualizados.son_separados());
			familiaEncontrada.setEs_compartida(datosActualizados.es_compartida());
			familiaEncontrada.setEs_padre(datosActualizados.es_padre());
			familiaEncontrada.setEs_madre(datosActualizados.es_madre());
				familiaRepository.save(familiaEncontrada);
					return convertirFamiliaCogida(familiaEncontrada);
	}

	@Override
	@Transactional
	public void eliminarFamiliaPorId(Integer id_familia) {
		Familia familiaEncontrada = familiaRepository.findById(id_familia).orElseThrow(() -> new RuntimeException("Familia no encontrada."));
			familiaRepository.delete(familiaEncontrada);
	}

	private FamiliaResponseDto convertirFamiliaCogida(Familia familiaCogida) {
		return new FamiliaResponseDto(
				familiaCogida.getId_familia(),
				familiaCogida.getNombre_padre(),
				familiaCogida.getApellidos_padre(),
				familiaCogida.getEmail_padre(),
				familiaCogida.getTlf_padre(),
				familiaCogida.getDireccion_padre(),
				familiaCogida.getCodigo_postal_padre(),
				familiaCogida.getProvincia_padre(),
				familiaCogida.getNombre_madre(),
				familiaCogida.getApellidos_madre(),
				familiaCogida.getEmail_madre(),
				familiaCogida.getTlf_madre(),
				familiaCogida.getDireccion_madre(),
				familiaCogida.getCodigo_postal_madre(),
				familiaCogida.getProvincia_madre(),
				familiaCogida.getSon_separados(),
				familiaCogida.getEs_compartida(),
				familiaCogida.getEs_padre(),
				familiaCogida.getEs_madre()
		);
	}
}
