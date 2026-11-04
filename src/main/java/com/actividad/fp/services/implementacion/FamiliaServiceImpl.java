package com.actividad.fp.services.implementacion;

import java.util.List;

import com.actividad.fp.dtos.FamiliaRequestDto;
import com.actividad.fp.dtos.FamiliaResponseDto;
import com.actividad.fp.entities.Familia;
import com.actividad.fp.services.FamiliaService;

public class FamiliaServiceImpl implements FamiliaService {

	@Override
	public List<FamiliaResponseDto> listarTodasLasFamilias() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FamiliaResponseDto buscarFamiliaPorId(Integer id_familia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FamiliaResponseDto crearFamilia(FamiliaRequestDto creacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FamiliaResponseDto editarFamiliaPorId(Integer id_familia, FamiliaRequestDto datosActualizados) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarFamiliaPorId(Integer id_familia) {
		// TODO Auto-generated method stub

	}

	private FamiliaResponseDto convertirFamiliaCogida(Familia familiaCogida) {
		return new FamiliaResponseDto(
				familiaCogida.getId_familia(),
				familiaCogida.getNombre_padre(),
				familiaCogida.getApellidos_padre(),
				familiaCogida.getEmail_padre(),
				familiaCogida.getTlf_padre(),
				familiaCogida.getDireccion_padre(),
				familiaCogida.getCodigo_postal_padre(),
				familiaCogida.getProvincia_padre(),
				familiaCogida.getNombre_madre(),
				familiaCogida.getApellidos_madre(),
				familiaCogida.getEmail_madre(),
				familiaCogida.getTlf_madre(),
				familiaCogida.getDireccion_madre(),
				familiaCogida.getCodigo_postal_madre(),
				familiaCogida.getProvincia_madre(),
				familiaCogida.getSon_separados(),
				familiaCogida.getEs_compartida(),
				familiaCogida.getEs_padre(),
				familiaCogida.getEs_madre()
		);
	}
}
