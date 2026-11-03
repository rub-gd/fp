package com.actividad.fp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.actividad.fp.entities.Familia;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, Integer>{

}
