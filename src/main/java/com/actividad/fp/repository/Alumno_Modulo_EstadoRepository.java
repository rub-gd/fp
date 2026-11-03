package com.actividad.fp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.actividad.fp.entities.Alumno_Modulo_Estado;

@Repository
public interface Alumno_Modulo_EstadoRepository extends JpaRepository<Alumno_Modulo_Estado, Integer>{

}
