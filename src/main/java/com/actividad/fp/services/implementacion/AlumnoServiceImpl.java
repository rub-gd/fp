package com.actividad.fp.services.implementacion;

import java.util.List;
import org.springframework.stereotype.Service;
import com.actividad.fp.dtos.AlumnoRequestDto;
import com.actividad.fp.dtos.AlumnoResponseDto;
import com.actividad.fp.entities.Alumno;
import com.actividad.fp.repository.AlumnoRepository;
import com.actividad.fp.services.AlumnoService;

@Service //Se pone para indicarle a Spring boot que es un componente de la capa servicio y que debe gestionarlo como un bean.	
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;
    
    public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

	@Override
	public List<AlumnoResponseDto> listarTodosLosAlumnos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlumnoResponseDto buscarAlumnoPorId(Integer id_alumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlumnoResponseDto buscarAlumnoPorDni(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlumnoResponseDto crearAlumno(AlumnoRequestDto creacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlumnoResponseDto actualizarAlumnoPorId(Integer id_alumno, AlumnoRequestDto datos_actualizados) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlumnoResponseDto actualizarAlumnoPorDni(String dni, AlumnoRequestDto datos_actualizados) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarAlumnoPorId(Integer id_alumno) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarAlumnoPorDni(String dni) {
		// TODO Auto-generated method stub

	}
	
	private AlumnoResponseDto convertirAlumnoCogido(Alumno alumnoCogido) {
		return new AlumnoResponseDto(
			alumnoCogido.getId_alumno(),
			alumnoCogido.getNombre(),
			alumnoCogido.getApellidos(),
			alumnoCogido.getDni(),
			alumnoCogido.getNumero_ss(),
			alumnoCogido.getEmail_centro(),
			alumnoCogido.getEmail_personal(),
			alumnoCogido.getTlf_personal(),
			alumnoCogido.getFecha_alta(),
			alumnoCogido.getFecha_baja(),
			alumnoCogido.getFamilia() == null ? null : alumnoCogido.getFamilia().getId_familia()
		);
	}
	
}
