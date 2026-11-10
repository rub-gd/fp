package com.actividad.fp.services.implementacion;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.actividad.fp.dtos.Modulo_CursoRequestDto;
import com.actividad.fp.dtos.Modulo_CursoResponseDto;
import com.actividad.fp.entities.Curso;
import com.actividad.fp.entities.Modulo;
import com.actividad.fp.entities.Modulo_Curso;
import com.actividad.fp.exceptions.CursoNotFoundException;
import com.actividad.fp.exceptions.ModuloNotFoundException;
import com.actividad.fp.exceptions.Modulo_CursoNotFoundException;
import com.actividad.fp.repository.CursoRepository;
import com.actividad.fp.repository.ModuloRepository;
import com.actividad.fp.repository.Modulo_CursoRepository;
import com.actividad.fp.services.Modulo_CursoService;

@Service
public class Modulo_CursoServiceImpl implements Modulo_CursoService {
	private Modulo_CursoRepository modulo_CursoRepository;
	private ModuloRepository moduloRepository;
	private CursoRepository cursoRepository;
	
	public Modulo_CursoServiceImpl(Modulo_CursoRepository modulo_CursoRepository, ModuloRepository moduloRepository, CursoRepository cursoRepository) {
		this.modulo_CursoRepository = modulo_CursoRepository;
		this.moduloRepository = moduloRepository;
		this.cursoRepository = cursoRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Modulo_CursoResponseDto> listarTodosLosModulo_Cursos() {
		return modulo_CursoRepository.findAll().stream().map(this::convertirModulo_CursoCogido).toList();
	}

	@Override
	@Transactional(readOnly = true)
	public Modulo_CursoResponseDto buscarModulo_CursoPorId(Integer id_modulo_curso) {
		Modulo_Curso modulo_CursoEncontrado = modulo_CursoRepository.findById(id_modulo_curso).orElseThrow(() -> new Modulo_CursoNotFoundException("Modulo_Curso no encontrado."));
			return convertirModulo_CursoCogido(modulo_CursoEncontrado);
	}

	@Override
	@Transactional
	public Modulo_CursoResponseDto crearModulo_Curso(Modulo_CursoRequestDto creacion) {
		Modulo_Curso nuevoModulo_Curso = new Modulo_Curso();
			Modulo id_modulo = moduloRepository.findById(creacion.id_modulo()).orElseThrow(() -> new ModuloNotFoundException("Modulo no encontrado."));
				nuevoModulo_Curso.setModulo(id_modulo);
			Curso id_curso = cursoRepository.findById(creacion.id_curso()).orElseThrow(()-> new CursoNotFoundException("Curso no encontrado."));
				nuevoModulo_Curso.setCurso(id_curso);
					modulo_CursoRepository.save(nuevoModulo_Curso);
						return convertirModulo_CursoCogido(nuevoModulo_Curso);
	}

	@Override
	@Transactional
	public Modulo_CursoResponseDto editarModulo_CursoPorId(Integer id_modulo_curso, Modulo_CursoRequestDto datosActualizados) {
		Modulo_Curso modulo_CursoEncontrado = modulo_CursoRepository.findById(id_modulo_curso).orElseThrow(() -> new Modulo_CursoNotFoundException("Modulo_Curso no encontrado."));
			Modulo id_modulo = moduloRepository.findById(datosActualizados.id_modulo()).orElseThrow(() -> new ModuloNotFoundException("Modulo no encontrado."));
				modulo_CursoEncontrado.setModulo(id_modulo);
			Curso id_curso = cursoRepository.findById(datosActualizados.id_curso()).orElseThrow(()-> new CursoNotFoundException("Curso no encontrado."));
				modulo_CursoEncontrado.setCurso(id_curso);
					modulo_CursoRepository.save(modulo_CursoEncontrado);
						return convertirModulo_CursoCogido(modulo_CursoEncontrado);
	}

	@Override
	@Transactional
	public void eliminarModulo_CursoPorId(Integer id_modulo_curso) {
		Modulo_Curso modulo_CursoEncontrado = modulo_CursoRepository.findById(id_modulo_curso).orElseThrow(() -> new Modulo_CursoNotFoundException("Modulo_Curso no encontrado."));
			modulo_CursoRepository.delete(modulo_CursoEncontrado);
	}

	private Modulo_CursoResponseDto convertirModulo_CursoCogido(Modulo_Curso modulo_CursoCogido) {
		return new Modulo_CursoResponseDto(
				modulo_CursoCogido.getId_modulo_curso(),
				modulo_CursoCogido.getModulo() == null ? null : modulo_CursoCogido.getModulo().getId_modulo(),
				modulo_CursoCogido.getCurso() == null ? null : modulo_CursoCogido.getCurso().getId_curso()
		);
	}
}
