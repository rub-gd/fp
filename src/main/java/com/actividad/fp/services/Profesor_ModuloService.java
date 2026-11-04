package com.actividad.fp.services;

import java.util.List;
import com.actividad.fp.dtos.Profesor_ModuloRequestDto;
import com.actividad.fp.dtos.Profesor_ModuloResponseDto;

public interface Profesor_ModuloService {
	List<Profesor_ModuloResponseDto> listarTodosLosProfesor_Modulos();
	
	Profesor_ModuloResponseDto buscarProfesor_ModuloPorId(Integer id_profesor_modulo);
	
	Profesor_ModuloResponseDto crearProfesor_Modulo(Profesor_ModuloRequestDto creacion);

	Profesor_ModuloResponseDto editarProfesor_ModuloPorId(Integer id_profesor_modulo, Profesor_ModuloRequestDto datosActualizados);
	
	void eliminarProfesor_ModuloPorId(Integer id_profesor_modulo);
}
