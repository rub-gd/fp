package com.actividad.fp.services.implementacion;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.actividad.fp.dtos.AlumnoRequestDto;
import com.actividad.fp.dtos.AlumnoResponseDto;
import com.actividad.fp.entities.Alumno;
import com.actividad.fp.entities.Familia;
import com.actividad.fp.exceptions.AlumnoNotFoundException;
import com.actividad.fp.exceptions.FamiliaNotFoundException;
import com.actividad.fp.repository.AlumnoRepository;
import com.actividad.fp.repository.FamiliaRepository;
import com.actividad.fp.services.AlumnoService;
@Service //Se pone para indicarle a Spring boot que es un componente de la capa servicio y que debe gestionarlo como un bean.	
public class AlumnoServiceImpl implements AlumnoService {
   private final AlumnoRepository alumnoRepository;
   private final FamiliaRepository familiaRepository;
  
   public AlumnoServiceImpl(AlumnoRepository alumnoRepository, FamiliaRepository familiaRepository) {
       this.alumnoRepository = alumnoRepository;
       this.familiaRepository = familiaRepository;
   }
	@Override
	@Transactional(readOnly = true)
	public List<AlumnoResponseDto> listarTodosLosAlumnos() {
		return alumnoRepository.findAll().stream().map(this::convertirAlumnoCogido).toList();
	}
	@Override
	@Transactional(readOnly = true)
	public AlumnoResponseDto buscarAlumnoPorId(Integer id_alumno) {
		Alumno alumnoEncontrado = alumnoRepository.findById(id_alumno).orElseThrow(() -> new AlumnoNotFoundException("Alumno no encontrado"));
			return convertirAlumnoCogido(alumnoEncontrado);
	}
	@Override
	@Transactional(readOnly = true)
	public AlumnoResponseDto buscarAlumnoPorDni(String dni) {
		Alumno alumnoEncontrado = alumnoRepository.findByDni(dni).orElseThrow(() -> new AlumnoNotFoundException("Alumno no encontrado"));
			return convertirAlumnoCogido(alumnoEncontrado);
	}
	@Override
	@Transactional
	public AlumnoResponseDto crearAlumno(AlumnoRequestDto creacion) {
		Alumno nuevoAlumno = new Alumno();
		 	//nuevoAlumno.setId_alunno(creacion.id_alumno()); Esto no se hace porque el id se debe crear automáticamente.
			nuevoAlumno.setNombre(creacion.nombre());
			nuevoAlumno.setApellidos(creacion.apellidos());
			nuevoAlumno.setDni(creacion.dni());
			nuevoAlumno.setNumero_ss(creacion.numero_ss());
			nuevoAlumno.setEmail_centro(creacion.email_centro());
			nuevoAlumno.setEmail_personal(creacion.email_personal());
			nuevoAlumno.setTlf_personal(creacion.tlf_personal());
			nuevoAlumno.setFecha_alta(creacion.fecha_alta());
			nuevoAlumno.setFecha_baja(creacion.fecha_baja());
			Familia id_familia = familiaRepository.findById(creacion.id_familia()).orElseThrow(() -> new FamiliaNotFoundException("Familia no encontrada."));
				nuevoAlumno.setFamilia(id_familia);
					alumnoRepository.save(nuevoAlumno);
						return convertirAlumnoCogido(nuevoAlumno);
	}
	@Override
	@Transactional
	public AlumnoResponseDto actualizarAlumnoPorId(Integer id_alumno, AlumnoRequestDto datos_actualizados) {
		Alumno alumnoEncontrado = alumnoRepository.findById(id_alumno).orElseThrow(() -> new AlumnoNotFoundException("Alumno no encontrado."));
		//alumnoEncontrado.setId_alumno(datos_actualizados.id_alumno()); Esto no se hace ya que no se debe poder cambiar el identificador.
		alumnoEncontrado.setNombre(datos_actualizados.nombre());
		alumnoEncontrado.setApellidos(datos_actualizados.apellidos());
		alumnoEncontrado.setDni(datos_actualizados.dni());
		alumnoEncontrado.setNumero_ss(datos_actualizados.numero_ss());
		alumnoEncontrado.setEmail_centro(datos_actualizados.email_centro());
		alumnoEncontrado.setEmail_personal(datos_actualizados.email_personal());
		alumnoEncontrado.setTlf_personal(datos_actualizados.tlf_personal());
		alumnoEncontrado.setFecha_alta(datos_actualizados.fecha_alta());
		alumnoEncontrado.setFecha_baja(datos_actualizados.fecha_baja());
		Familia id_familia = familiaRepository.findById(datos_actualizados.id_familia()).orElseThrow(() -> new FamiliaNotFoundException("Familia no encontrada."));
			alumnoEncontrado.setFamilia(id_familia);
				alumnoRepository.save(alumnoEncontrado);
					return convertirAlumnoCogido(alumnoEncontrado);
	}
	@Override
	@Transactional
	public AlumnoResponseDto actualizarAlumnoPorDni(String dni, AlumnoRequestDto datos_actualizados) {
		Alumno alumnoEncontrado = alumnoRepository.findByDni(dni).orElseThrow(() -> new AlumnoNotFoundException("Alumno no encontrado."));
			//alumnoEncontrado.setId_alumno(datos_actualizados.id_alumno()); Esto no se hace ya que no se debe poder cambiar el identificador.
			alumnoEncontrado.setNombre(datos_actualizados.nombre());
			alumnoEncontrado.setApellidos(datos_actualizados.apellidos());
			alumnoEncontrado.setDni(datos_actualizados.dni());
			alumnoEncontrado.setNumero_ss(datos_actualizados.numero_ss());
			alumnoEncontrado.setEmail_centro(datos_actualizados.email_centro());
			alumnoEncontrado.setEmail_personal(datos_actualizados.email_personal());
			alumnoEncontrado.setTlf_personal(datos_actualizados.tlf_personal());
			alumnoEncontrado.setFecha_alta(datos_actualizados.fecha_alta());
			alumnoEncontrado.setFecha_baja(datos_actualizados.fecha_baja());
			Familia id_familia = familiaRepository.findById(datos_actualizados.id_familia()).orElseThrow(() -> new FamiliaNotFoundException("Familia no encontrada."));
				alumnoEncontrado.setFamilia(id_familia);
					alumnoRepository.save(alumnoEncontrado);
						return convertirAlumnoCogido(alumnoEncontrado);
	}
	@Override
	@Transactional
	public void eliminarAlumnoPorId(Integer id_alumno) {
		Alumno alumnoEncontrado = alumnoRepository.findById(id_alumno).orElseThrow(() -> new AlumnoNotFoundException("Alumno no encontrado."));
			alumnoRepository.delete(alumnoEncontrado);
	}
	@Override
	@Transactional
	public void eliminarAlumnoPorDni(String dni) {
		Alumno alumnoEncontrado = alumnoRepository.findByDni(dni).orElseThrow(() -> new AlumnoNotFoundException("Alumno no encontrado."));
			alumnoRepository.delete(alumnoEncontrado);
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