package com.actividad.fp.services.implementacion;

import java.util.List;
import com.actividad.fp.dtos.CursoRequestDto;
import com.actividad.fp.dtos.CursoResponseDto;
import com.actividad.fp.entities.Curso;
import com.actividad.fp.services.CursoService;

public class CursoServiceImpl implements CursoService {

	@Override
	public List<CursoResponseDto> listarTodosLosCursos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CursoResponseDto buscarCursoPorId(Integer id_curso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CursoResponseDto buscarCursoPorDiminutivo(String diminutivo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CursoResponseDto crearCurso(CursoRequestDto creacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CursoResponseDto editarCursoPorId(Integer id_curso, CursoRequestDto datosActualizados) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CursoResponseDto editarCursoPorDiminutivo(String diminutivo, CursoRequestDto datosActualizados) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarCursoPorId(Integer id_curso) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarCursoPorDiminutivo(String diminutivo) {
		// TODO Auto-generated method stub

	}
	
	private CursoResponseDto convertirCursoCogido(Curso cursoCogido) {
		return new CursoResponseDto(
			cursoCogido.getId_curso(),
			cursoCogido.getDiminutivo(),
			cursoCogido.getDescripcion()
		);
	}
}
