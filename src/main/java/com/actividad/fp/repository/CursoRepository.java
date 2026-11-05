package com.actividad.fp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.actividad.fp.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{
	boolean existsByDiminutivo(String diminutivo);
	Optional<Curso> findByDiminutivo(String diminutivo);
	void deleteByDiminutivo(String diminutivo);
	int countByDiminutivo(String diminutivo);
}
