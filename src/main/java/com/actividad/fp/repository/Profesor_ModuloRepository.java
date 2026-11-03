package com.actividad.fp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.actividad.fp.entities.Profesor_Modulo;

@Repository
public interface Profesor_ModuloRepository extends JpaRepository<Profesor_Modulo, Integer>{

}
