package com.actividad.fp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.actividad.fp.entities.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>{
	boolean existsByCodigo(String codigo);
	List<Departamento> findByCodigo(String codigo);
	void deleteByCodigo(String codigo);
	int countByCodigo(String codigo);
}
