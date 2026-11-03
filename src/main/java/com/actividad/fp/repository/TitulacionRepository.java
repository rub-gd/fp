package com.actividad.fp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.actividad.fp.entities.Alumno;
import com.actividad.fp.entities.Titulacion;

@Repository
public interface TitulacionRepository extends JpaRepository<Titulacion, Integer>{
	boolean existsBycodigo(String codigo);
	List<Alumno> findByCodigo(String codigo);
	void deleteBycodigo(String codigo);
	int countBycodigo(String codigo);
	
	boolean existsByDiminutivo(String diminutivo);
	List<Alumno> findByDiminutivo(String diminutivo);
	void deleteByDiminutivo(String diminutivo);
	int countByDiminutivo(String diminutivo);
}
