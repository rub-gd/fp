package com.actividad.fp.services.implementacion;

import java.util.List;

import com.actividad.fp.dtos.Modulo_CursoRequestDto;
import com.actividad.fp.dtos.Modulo_CursoResponseDto;
import com.actividad.fp.entities.Modulo_Curso;
import com.actividad.fp.services.Modulo_CursoService;

public class Modulo_CursoServiceImpl implements Modulo_CursoService {

	@Override
	public List<Modulo_CursoResponseDto> listarTodosLosModulo_Cursos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Modulo_CursoResponseDto buscarModulo_CursoPorId(Integer id_modulo_curso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Modulo_CursoResponseDto crearModulo_Curso(Modulo_CursoRequestDto creacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Modulo_CursoResponseDto editarModulo_CursoPorId(Integer id_modulo_curso,
			Modulo_CursoRequestDto datosActualizados) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarModulo_CursoPorId(Integer id_modulo_curso) {
		// TODO Auto-generated method stub

	}

	private Modulo_CursoResponseDto convertirModulo_CursoCogido(Modulo_Curso modulo_CursoCogido) {
		return new Modulo_CursoResponseDto(
				modulo_CursoCogido.getId_modulo_curso(),
				modulo_CursoCogido.getModulo() == null ? null : modulo_CursoCogido.getModulo().getId_modulo(),
				modulo_CursoCogido.getCurso() == null ? null : modulo_CursoCogido.getCurso().getId_curso()
		);
	}
}
