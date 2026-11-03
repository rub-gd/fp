package com.actividad.fp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.actividad.fp.entities.Modulo_Curso;

@Repository
public interface Modulo_CursoRepository extends JpaRepository<Modulo_Curso, Integer>{

}
