package com.actividad.fp.services.implementacion;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.actividad.fp.dtos.ProfesorRequestDto;
import com.actividad.fp.dtos.ProfesorResponseDto;
import com.actividad.fp.entities.Departamento;
import com.actividad.fp.entities.Profesor;
import com.actividad.fp.repository.DepartamentoRepository;
import com.actividad.fp.repository.ProfesorRepository;
import com.actividad.fp.services.ProfesorService;

@Service
public class ProfesorServiceImpl implements ProfesorService {
	private final ProfesorRepository profesorRepository;
	private final DepartamentoRepository departamentoRepository;
	
	public ProfesorServiceImpl(ProfesorRepository profesorRepository, DepartamentoRepository departamentoRepository) {
		this.profesorRepository = profesorRepository;
		this.departamentoRepository = departamentoRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ProfesorResponseDto> listarTodosLosProfesores() {
		return profesorRepository.findAll().stream().map(this::convertirProfesorCogido).toList();
	}

	@Override
	@Transactional(readOnly = true)
	public ProfesorResponseDto buscarProfesorPorId(Integer id_profesor) {
		Profesor profesorEncontrado = profesorRepository.findById(id_profesor).orElseThrow(() -> new RuntimeException("Profesor no encontrado."));
			return convertirProfesorCogido(profesorEncontrado);
	}

	@Override
	@Transactional(readOnly = true)
	public ProfesorResponseDto buscarProfesorPorDni(String dni) {
		Profesor profesorEncontrado = profesorRepository.findByDni(dni).stream().findFirst().orElseThrow(() -> new RuntimeException("Profesor no encontrado."));
			return convertirProfesorCogido(profesorEncontrado);
	}

	@Override
	@Transactional
	public ProfesorResponseDto crearProfesor(ProfesorRequestDto creacion) {
		Profesor nuevoProfesor = new Profesor();
			nuevoProfesor.setNombre(creacion.nombre());
			nuevoProfesor.setApellidos(creacion.apellidos());
			nuevoProfesor.setDni(creacion.dni());
			nuevoProfesor.setEmail_centro(creacion.email_centro());
			nuevoProfesor.setEmail_personal(creacion.email_personal());
			nuevoProfesor.setTlf_personal(creacion.tlf_personal());
			Departamento id_departamento = departamentoRepository.findById(creacion.id_departamento()).orElseThrow(() -> new RuntimeException("Departamento no encontrado."));
				nuevoProfesor.setDepartamento(id_departamento);
					profesorRepository.save(nuevoProfesor);
						return convertirProfesorCogido(nuevoProfesor);
	}

	@Override
	@Transactional
	public ProfesorResponseDto editarProfesorPorId(Integer id_profesor, ProfesorRequestDto datosActualizados) {
		Profesor profesorEncontrado = profesorRepository.findById(id_profesor).orElseThrow(() -> new RuntimeException("Profesor no encontrado."));
			profesorEncontrado.setNombre(datosActualizados.nombre());
			profesorEncontrado.setApellidos(datosActualizados.apellidos());
			profesorEncontrado.setDni(datosActualizados.dni());
			profesorEncontrado.setEmail_centro(datosActualizados.email_centro());
			profesorEncontrado.setEmail_personal(datosActualizados.email_personal());
			profesorEncontrado.setTlf_personal(datosActualizados.tlf_personal());
			Departamento id_departamento = departamentoRepository.findById(datosActualizados.id_departamento()).orElseThrow(() -> new RuntimeException("Departamento no encontrado."));
				profesorEncontrado.setDepartamento(id_departamento);
					profesorRepository.save(profesorEncontrado);
						return convertirProfesorCogido(profesorEncontrado);
	}

	@Override
	@Transactional
	public ProfesorResponseDto editarProfesorPorDni(String dni, ProfesorRequestDto datosActualizados) {
		Profesor profesorEncontrado = profesorRepository.findByDni(dni).stream().findFirst().orElseThrow(() -> new RuntimeException("Profesor no encontrado."));
			profesorEncontrado.setNombre(datosActualizados.nombre());
			profesorEncontrado.setApellidos(datosActualizados.apellidos());
			profesorEncontrado.setDni(datosActualizados.dni());
			profesorEncontrado.setEmail_centro(datosActualizados.email_centro());
			profesorEncontrado.setEmail_personal(datosActualizados.email_personal());
			profesorEncontrado.setTlf_personal(datosActualizados.tlf_personal());
			Departamento id_departamento = departamentoRepository.findById(datosActualizados.id_departamento()).orElseThrow(() -> new RuntimeException("Departamento no encontrado."));
				profesorEncontrado.setDepartamento(id_departamento);
					profesorRepository.save(profesorEncontrado);
						return convertirProfesorCogido(profesorEncontrado);
	}

	@Override
	@Transactional
	public void eliminarProfesorPorId(Integer id_profesor) {
		Profesor profesorEncontrado = profesorRepository.findById(id_profesor).orElseThrow(() -> new RuntimeException("Profesor no encontrado."));
			profesorRepository.delete(profesorEncontrado);
	}

	@Override
	@Transactional
	public void eliminarProfesorPorDni(String dni) {
		Profesor profesorEncontrado = profesorRepository.findByDni(dni).stream().findFirst().orElseThrow(() -> new RuntimeException("Profesor no encontrado."));
			profesorRepository.delete(profesorEncontrado);
	}

	private ProfesorResponseDto convertirProfesorCogido(Profesor profesorCogido) {
		return new ProfesorResponseDto(
			profesorCogido.getId_profesor(),
			profesorCogido.getNombre(),
			profesorCogido.getApellidos(),
			profesorCogido.getDni(),
			profesorCogido.getEmail_centro(),
			profesorCogido.getEmail_personal(),
			profesorCogido.getTlf_personal(),
			profesorCogido.getDepartamento() == null ? null : profesorCogido.getDepartamento().getId_departamento()
		);
	}
}
