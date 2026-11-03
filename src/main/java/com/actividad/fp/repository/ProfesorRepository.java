package com.actividad.fp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.actividad.fp.entities.Alumno;
import com.actividad.fp.entities.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer>{
	boolean existsByDni(String dni);
	List<Alumno> findByDni(String dni);
	void deleteByDni(String dni);
	int countByDni(String dni);
}
