package com.actividad.fp.services.implementacion;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.actividad.fp.dtos.Profesor_ModuloRequestDto;
import com.actividad.fp.dtos.Profesor_ModuloResponseDto;
import com.actividad.fp.entities.Modulo;
import com.actividad.fp.entities.Profesor;
import com.actividad.fp.entities.Profesor_Modulo;
import com.actividad.fp.exceptions.ModuloNotFoundException;
import com.actividad.fp.exceptions.ProfesorNotFoundException;
import com.actividad.fp.exceptions.Profesor_ModuloNotFoundException;
import com.actividad.fp.repository.ModuloRepository;
import com.actividad.fp.repository.ProfesorRepository;
import com.actividad.fp.repository.Profesor_ModuloRepository;
import com.actividad.fp.services.Profesor_ModuloService;

@Service
public class Profesor_ModuloServiceImpl implements Profesor_ModuloService {
	private final Profesor_ModuloRepository profesor_ModuloRepository;
	private final ProfesorRepository profesorRepository;
	private final ModuloRepository moduloRepository;
	
	public Profesor_ModuloServiceImpl(Profesor_ModuloRepository profesor_ModuloRepository, ProfesorRepository profesorRepository, ModuloRepository moduloRepository) {
		this.profesor_ModuloRepository = profesor_ModuloRepository;
		this.profesorRepository = profesorRepository;
		this.moduloRepository = moduloRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Profesor_ModuloResponseDto> listarTodosLosProfesor_Modulos() {
		return profesor_ModuloRepository.findAll().stream().map(this::convertirProfesor_ModuloCogido).toList();
	}

	@Override
	@Transactional(readOnly = true)
	public Profesor_ModuloResponseDto buscarProfesor_ModuloPorId(Integer id_profesor_modulo) {
		Profesor_Modulo profesor_ModuloEncontrado = profesor_ModuloRepository.findById(id_profesor_modulo).orElseThrow(() -> new Profesor_ModuloNotFoundException("Profesor_Modulo no encontrado."));
			return convertirProfesor_ModuloCogido(profesor_ModuloEncontrado);
	}

	@Override
	@Transactional
	public Profesor_ModuloResponseDto crearProfesor_Modulo(Profesor_ModuloRequestDto creacion) {
		Profesor_Modulo nuevoProfesor_Modulo = new Profesor_Modulo();
			Profesor id_profesor = profesorRepository.findById(creacion.id_profesor()).orElseThrow(() -> new ProfesorNotFoundException("Profesor no encontrado."));
				nuevoProfesor_Modulo.setProfesor(id_profesor);
			Modulo id_modulo = moduloRepository.findById(creacion.id_modulo()).orElseThrow(() -> new ModuloNotFoundException("Modulo no encontrado."));
				nuevoProfesor_Modulo.setModulo(id_modulo);
					profesor_ModuloRepository.save(nuevoProfesor_Modulo);
						return convertirProfesor_ModuloCogido(nuevoProfesor_Modulo);
	}

	@Override
	@Transactional
	public Profesor_ModuloResponseDto editarProfesor_ModuloPorId(Integer id_profesor_modulo, Profesor_ModuloRequestDto datosActualizados) {
		Profesor_Modulo profesor_ModuloEncontrado = profesor_ModuloRepository.findById(id_profesor_modulo).orElseThrow(() -> new Profesor_ModuloNotFoundException("Profesor_Modulo no encontrado."));
			Profesor id_profesor = profesorRepository.findById(datosActualizados.id_profesor()).orElseThrow(() -> new ProfesorNotFoundException("Profesor no encontrado."));
				profesor_ModuloEncontrado.setProfesor(id_profesor);
			Modulo id_modulo = moduloRepository.findById(datosActualizados.id_modulo()).orElseThrow(() -> new ModuloNotFoundException("Modulo no encontrado."));
				profesor_ModuloEncontrado.setModulo(id_modulo);
					profesor_ModuloRepository.save(profesor_ModuloEncontrado);
						return convertirProfesor_ModuloCogido(profesor_ModuloEncontrado);
	}

	@Override
	@Transactional
	public void eliminarProfesor_ModuloPorId(Integer id_profesor_modulo) {
		Profesor_Modulo profesor_ModuloEncontrado = profesor_ModuloRepository.findById(id_profesor_modulo).orElseThrow(() -> new Profesor_ModuloNotFoundException("Profesor_Modulo no encontrado."));
			profesor_ModuloRepository.delete(profesor_ModuloEncontrado);
	}

	private Profesor_ModuloResponseDto convertirProfesor_ModuloCogido(Profesor_Modulo profesor_ModuloCogido) {
		return new Profesor_ModuloResponseDto(
			profesor_ModuloCogido.getId_profesor_modulo(),
			profesor_ModuloCogido.getProfesor() == null ? null : profesor_ModuloCogido.getProfesor().getId_profesor(),
			profesor_ModuloCogido.getModulo() == null ? null : profesor_ModuloCogido.getModulo().getId_modulo()
		);
	}
}
