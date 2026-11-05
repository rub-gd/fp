package com.actividad.fp.services.implementacion;
import java.util.List;
import org.springframework.stereotype.Service;
import com.actividad.fp.dtos.Alumno_Modulo_EstadoRequestDto;
import com.actividad.fp.dtos.Alumno_Modulo_EstadoResponseDto;
import com.actividad.fp.entities.Alumno;
import com.actividad.fp.entities.Alumno_Modulo_Estado;
import com.actividad.fp.entities.Estado;
import com.actividad.fp.entities.Modulo;
import com.actividad.fp.repository.AlumnoRepository;
import com.actividad.fp.repository.Alumno_Modulo_EstadoRepository;
import com.actividad.fp.repository.EstadoRepository;
import com.actividad.fp.repository.ModuloRepository;
import com.actividad.fp.services.Alumno_Modulo_EstadoService;
@Service
public class Alumno_Modulo_EstadoServiceImpl implements Alumno_Modulo_EstadoService {
	private final Alumno_Modulo_EstadoRepository alumno_Modulo_EstadoRepository;
	private final AlumnoRepository alumnoRepository;
	private final ModuloRepository moduloRepository;
	private final EstadoRepository estadoRepository;
	
	public Alumno_Modulo_EstadoServiceImpl(Alumno_Modulo_EstadoRepository alumno_Modulo_EstadoRepository, AlumnoRepository alumnoRepository, ModuloRepository moduloRepository, EstadoRepository estadoRepository) {
       this.alumno_Modulo_EstadoRepository = alumno_Modulo_EstadoRepository;
       this.alumnoRepository = alumnoRepository;
       this.moduloRepository = moduloRepository;
       this.estadoRepository = estadoRepository;
   }
	
	@Override
	public List<Alumno_Modulo_EstadoResponseDto> listarTodosLosAlumno_Modulo_Estados() {
		return alumno_Modulo_EstadoRepository.findAll().stream().map(this::convertirAlumno_Modulo_EstadoCogido).toList();
	}
	@Override
	public Alumno_Modulo_EstadoResponseDto buscarAlumno_Modulo_EstadoPorId(Integer id_alumno_modulo_estado) {
		Alumno_Modulo_Estado alumno_Modulo_EstadoEncontrado = alumno_Modulo_EstadoRepository.findById(id_alumno_modulo_estado).orElseThrow(() -> new RuntimeException("Alumno_Modulo_Estado no encontrado."));
			return convertirAlumno_Modulo_EstadoCogido(alumno_Modulo_EstadoEncontrado);
	}
	@Override
	public Alumno_Modulo_EstadoResponseDto crearAlumno_Modulo_Estado(Alumno_Modulo_EstadoRequestDto creacion) {
		Alumno_Modulo_Estado alumno_Modulo_EstadoCreado = new Alumno_Modulo_Estado();
			//alumno_Modulo_EstadoCreado.setId_alumno_modulo_estado(creacion.id_alumno_Modulo_Estado()); Esto no se hace porque el id se debe crear automáticamente.
			Alumno id_alumno = alumnoRepository.findById(creacion.id_alumno()).orElseThrow(() -> new RuntimeException("Alumno no encontrado."));
				alumno_Modulo_EstadoCreado.setAlumno(id_alumno);
			Modulo id_modulo = moduloRepository.findById(creacion.id_modulo()).orElseThrow(() -> new RuntimeException("Módulo no encontrado."));
				alumno_Modulo_EstadoCreado.setModulo(id_modulo);
			Estado id_estado = estadoRepository.findById(creacion.id_estado()).orElseThrow(() -> new RuntimeException("Estado no encontrado."));
				alumno_Modulo_EstadoCreado.setEstado(id_estado);
					alumno_Modulo_EstadoRepository.save(alumno_Modulo_EstadoCreado);
						return convertirAlumno_Modulo_EstadoCogido(alumno_Modulo_EstadoCreado);
	}
	@Override
	public Alumno_Modulo_EstadoResponseDto editarAlumno_Modulo_EstadoPorId(Integer id_alumno_modulo_estado, Alumno_Modulo_EstadoRequestDto datosActualizados) {
		Alumno_Modulo_Estado alumno_Modulo_EstadoEncontrado = alumno_Modulo_EstadoRepository.findById(id_alumno_modulo_estado).orElseThrow(() -> new RuntimeException("Alumno_Modulo_EstadoRepository no encontrado."));
			//alumno_Modulo_EstadoEncontrado.setId_alumno_modulo_estado(id_alumno_modulo_estado.id_alumno_Modulo_Estado); Esto no se hace ya que no se debe poder cambiar el identificador.
			Alumno id_alumno = alumnoRepository.findById(datosActualizados.id_alumno()).orElseThrow(() -> new RuntimeException("Alumno no encontrado."));
				alumno_Modulo_EstadoEncontrado.setAlumno(id_alumno);
			Modulo id_modulo = moduloRepository.findById(datosActualizados.id_modulo()).orElseThrow(() -> new RuntimeException("Módulo no encontrado."));
				alumno_Modulo_EstadoEncontrado.setModulo(id_modulo);
			Estado id_estado = estadoRepository.findById(datosActualizados.id_estado()).orElseThrow(() -> new RuntimeException("Estado no encontrado."));
				alumno_Modulo_EstadoEncontrado.setEstado(id_estado);
					alumno_Modulo_EstadoRepository.save(alumno_Modulo_EstadoEncontrado);
						return convertirAlumno_Modulo_EstadoCogido(alumno_Modulo_EstadoEncontrado);
	}
	@Override
	public void eliminarAlumno_Modulo_EstadoPorId(Integer id_alumno_modulo_estado) {
		Alumno_Modulo_Estado alumno_Modulo_EstadoEncontrado = alumno_Modulo_EstadoRepository.findById(id_alumno_modulo_estado).orElseThrow(() -> new RuntimeException("Alumno_Modulo_EstadoRepository no encontrado."));
			alumno_Modulo_EstadoRepository.delete(alumno_Modulo_EstadoEncontrado);
	}
	private Alumno_Modulo_EstadoResponseDto convertirAlumno_Modulo_EstadoCogido(Alumno_Modulo_Estado alumno_Modulo_EstadoCogido) {
		return new Alumno_Modulo_EstadoResponseDto(
			alumno_Modulo_EstadoCogido.getId_alumno_modulo_estado(),
			alumno_Modulo_EstadoCogido.getAlumno() == null ? null : alumno_Modulo_EstadoCogido.getAlumno().getId_alumno(),
			alumno_Modulo_EstadoCogido.getModulo() == null ? null : alumno_Modulo_EstadoCogido.getModulo().getId_modulo(),
			alumno_Modulo_EstadoCogido.getEstado() == null ? null : alumno_Modulo_EstadoCogido.getEstado().getId_estado()
		);
	}
}