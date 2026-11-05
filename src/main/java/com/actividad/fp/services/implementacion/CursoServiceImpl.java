package com.actividad.fp.services.implementacion;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.actividad.fp.dtos.CursoRequestDto;
import com.actividad.fp.dtos.CursoResponseDto;
import com.actividad.fp.entities.Curso;
import com.actividad.fp.repository.CursoRepository;
import com.actividad.fp.services.CursoService;

@Service
public class CursoServiceImpl implements CursoService {
	private final CursoRepository cursoRepository;
	
	public CursoServiceImpl(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<CursoResponseDto> listarTodosLosCursos() {
		return cursoRepository.findAll().stream().map(this::convertirCursoCogido).toList();
	}

	@Override
	@Transactional(readOnly = true)
	public CursoResponseDto buscarCursoPorId(Integer id_curso) {
		Curso cursoEncontrado = cursoRepository.findById(id_curso).orElseThrow(() -> new RuntimeException("Curso no encontrado."));
			return convertirCursoCogido(cursoEncontrado);
	}

	@Override
	@Transactional(readOnly = true)
	public CursoResponseDto buscarCursoPorDiminutivo(String diminutivo) {
		Curso cursoEncontrado = cursoRepository.findByDiminutivo(diminutivo).orElseThrow(() -> new RuntimeException("Curso no encontrado."));
			return convertirCursoCogido(cursoEncontrado);
	}

	@Override
	@Transactional
	public CursoResponseDto crearCurso(CursoRequestDto creacion) {
		Curso nuevoCurso = new Curso();
			nuevoCurso.setDiminutivo(creacion.diminutivo());
			nuevoCurso.setDescripcion(creacion.descripcion());
				cursoRepository.save(nuevoCurso);
					return convertirCursoCogido(nuevoCurso);
	}

	@Override
	@Transactional
	public CursoResponseDto editarCursoPorId(Integer id_curso, CursoRequestDto datosActualizados) {
		Curso cursoEncontrado = cursoRepository.findById(id_curso).orElseThrow(() -> new RuntimeException("Curso no encontrado."));
			cursoEncontrado.setDiminutivo(datosActualizados.diminutivo());
			cursoEncontrado.setDescripcion(datosActualizados.descripcion());
				cursoRepository.save(cursoEncontrado);
					return convertirCursoCogido(cursoEncontrado);
	}

	@Override
	@Transactional
	public CursoResponseDto editarCursoPorDiminutivo(String diminutivo, CursoRequestDto datosActualizados) {
		Curso cursoEncontrado = cursoRepository.findByDiminutivo(diminutivo).orElseThrow(() -> new RuntimeException("Curso no encontrado."));
			cursoEncontrado.setDiminutivo(datosActualizados.diminutivo());
			cursoEncontrado.setDescripcion(datosActualizados.descripcion());
				cursoRepository.save(cursoEncontrado);
					return convertirCursoCogido(cursoEncontrado);
	}

	@Override
	@Transactional
	public void eliminarCursoPorId(Integer id_curso) {
		Curso cursoEncontrado = cursoRepository.findById(id_curso).orElseThrow(() -> new RuntimeException("Curso no encontrado."));
			cursoRepository.delete(cursoEncontrado);
	}

	@Override
	@Transactional
	public void eliminarCursoPorDiminutivo(String diminutivo) {
		Curso cursoEncontrado = cursoRepository.findByDiminutivo(diminutivo).orElseThrow(() -> new RuntimeException("Curso no encontrado."));
			cursoRepository.delete(cursoEncontrado);
	}
	
	private CursoResponseDto convertirCursoCogido(Curso cursoCogido) {
		return new CursoResponseDto(
			cursoCogido.getId_curso(),
			cursoCogido.getDiminutivo(),
			cursoCogido.getDescripcion()
		);
	}
}
