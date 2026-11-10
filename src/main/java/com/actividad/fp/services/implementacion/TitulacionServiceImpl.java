package com.actividad.fp.services.implementacion;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.actividad.fp.dtos.TitulacionRequestDto;
import com.actividad.fp.dtos.TitulacionResponseDto;
import com.actividad.fp.entities.Curso;
import com.actividad.fp.entities.Titulacion;
import com.actividad.fp.exceptions.CursoNotFoundException;
import com.actividad.fp.exceptions.TitulacionNotFoundException;
import com.actividad.fp.repository.CursoRepository;
import com.actividad.fp.repository.TitulacionRepository;
import com.actividad.fp.services.TitulacionService;

@Service
public class TitulacionServiceImpl implements TitulacionService {
	private final TitulacionRepository titulacionRepository;
	private final CursoRepository cursoRepository;
	
	public TitulacionServiceImpl(TitulacionRepository titulacionRepository, CursoRepository cursoRepository) {
		this.titulacionRepository = titulacionRepository;
		this.cursoRepository = cursoRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<TitulacionResponseDto> listarTodasLasTitulaciones() {
		return titulacionRepository.findAll().stream().map(this::convertirTitulacionCogida).toList();
	}

	@Override
	@Transactional(readOnly = true)
	public TitulacionResponseDto buscarTitulacionPorId(Integer id_titulacion) {
		Titulacion titulacionEncontrada = titulacionRepository.findById(id_titulacion).orElseThrow(() -> new TitulacionNotFoundException("Titulacion no encontrada."));
			return convertirTitulacionCogida(titulacionEncontrada);
	}

	@Override
	@Transactional(readOnly = true)
	public TitulacionResponseDto buscarTitulacionPorCodigo(String codigo) {
		Titulacion titulacionEncontrada = titulacionRepository.findByCodigo(codigo).stream().findFirst().orElseThrow(() -> new TitulacionNotFoundException("Titulacion no encontrada."));
			return convertirTitulacionCogida(titulacionEncontrada);
	}

	@Override
	@Transactional(readOnly = true)
	public TitulacionResponseDto buscarTitulacionPorDiminutivo(String diminutivo) {
		Titulacion titulacionEncontrada = titulacionRepository.findByDiminutivo(diminutivo).stream().findFirst().orElseThrow(() -> new TitulacionNotFoundException("Titulacion no encontrada."));
			return convertirTitulacionCogida(titulacionEncontrada);
	}

	@Override
	@Transactional
	public TitulacionResponseDto crearTitulacion(TitulacionRequestDto creacion) {
		Titulacion nuevaTitulacion = new Titulacion();
			nuevaTitulacion.setCodigo(creacion.codigo());
			nuevaTitulacion.setDiminutivo(creacion.diminutivo());
			nuevaTitulacion.setHoras_totales(creacion.horas_totales());
			Curso id_curso = cursoRepository.findById(creacion.id_curso()).orElseThrow(() -> new CursoNotFoundException("Curso no encontrado."));
				nuevaTitulacion.setCurso(id_curso);
					titulacionRepository.save(nuevaTitulacion);
						return convertirTitulacionCogida(nuevaTitulacion);
	}

	@Override
	@Transactional
	public TitulacionResponseDto editarTitulacionPorId(Integer id_titulacion, TitulacionRequestDto datosActualizados) {
		Titulacion titulacionEncontrada = titulacionRepository.findById(id_titulacion).orElseThrow(() -> new TitulacionNotFoundException("Titulacion no encontrada."));
			titulacionEncontrada.setCodigo(datosActualizados.codigo());
			titulacionEncontrada.setDiminutivo(datosActualizados.diminutivo());
			titulacionEncontrada.setHoras_totales(datosActualizados.horas_totales());
			Curso id_curso = cursoRepository.findById(datosActualizados.id_curso()).orElseThrow(() -> new CursoNotFoundException("Curso no encontrado."));
				titulacionEncontrada.setCurso(id_curso);
					titulacionRepository.save(titulacionEncontrada);
						return convertirTitulacionCogida(titulacionEncontrada);
	}

	@Override
	@Transactional
	public TitulacionResponseDto editarTitulacionPorCodigo(String codigo, TitulacionRequestDto datosActualizados) {
		Titulacion titulacionEncontrada = titulacionRepository.findByCodigo(codigo).stream().findFirst().orElseThrow(() -> new TitulacionNotFoundException("Titulacion no encontrada."));
			titulacionEncontrada.setCodigo(datosActualizados.codigo());
			titulacionEncontrada.setDiminutivo(datosActualizados.diminutivo());
			titulacionEncontrada.setHoras_totales(datosActualizados.horas_totales());
			Curso id_curso = cursoRepository.findById(datosActualizados.id_curso()).orElseThrow(() -> new CursoNotFoundException("Curso no encontrado."));
				titulacionEncontrada.setCurso(id_curso);
					titulacionRepository.save(titulacionEncontrada);
						return convertirTitulacionCogida(titulacionEncontrada);
	}

	@Override
	@Transactional
	public TitulacionResponseDto editarTitulacionPorDiminutivo(String diminutivo, TitulacionRequestDto datosActualizados) {
		Titulacion titulacionEncontrada = titulacionRepository.findByDiminutivo(diminutivo).stream().findFirst().orElseThrow(() -> new TitulacionNotFoundException("Titulacion no encontrada."));
			titulacionEncontrada.setCodigo(datosActualizados.codigo());
			titulacionEncontrada.setDiminutivo(datosActualizados.diminutivo());
			titulacionEncontrada.setHoras_totales(datosActualizados.horas_totales());
			Curso id_curso = cursoRepository.findById(datosActualizados.id_curso()).orElseThrow(() -> new CursoNotFoundException("Curso no encontrado."));
				titulacionEncontrada.setCurso(id_curso);
					titulacionRepository.save(titulacionEncontrada);
						return convertirTitulacionCogida(titulacionEncontrada);
	}

	@Override
	@Transactional
	public void eliminarTitulacionPorId(Integer id_titulacion) {
		Titulacion titulacionEncontrada = titulacionRepository.findById(id_titulacion).orElseThrow(() -> new TitulacionNotFoundException("Titulacion no encontrada."));
			titulacionRepository.delete(titulacionEncontrada);
	}

	@Override
	@Transactional
	public void eliminarTitulacionPorCodigo(String codigo) {
		Titulacion titulacionEncontrada = titulacionRepository.findByCodigo(codigo).stream().findFirst().orElseThrow(() -> new TitulacionNotFoundException("Titulacion no encontrada."));
			titulacionRepository.delete(titulacionEncontrada);
	}

	@Override
	@Transactional
	public void eliminarTitulacionPorDiminutivo(String diminutivo) {
		Titulacion titulacionEncontrada = titulacionRepository.findByDiminutivo(diminutivo).stream().findFirst().orElseThrow(() -> new TitulacionNotFoundException("Titulacion no encontrada."));
			titulacionRepository.delete(titulacionEncontrada);
	}

	private TitulacionResponseDto convertirTitulacionCogida(Titulacion titulacionCogida) {
		return new TitulacionResponseDto(
			titulacionCogida.getId_titulacion(),
			titulacionCogida.getCodigo(),
			titulacionCogida.getDiminutivo(),
			titulacionCogida.getHoras_totales(),
			titulacionCogida.getCurso() == null ? null : titulacionCogida.getCurso().getId_curso()
		);
	}
}
