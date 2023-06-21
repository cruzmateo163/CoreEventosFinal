package com.eventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventos.model.Actividades;
import com.eventos.repository.ActividadesRepository;


@Service
public class ActividadesServiceImpl implements IActividadesService {

	@Autowired
	private ActividadesRepository actividadesRepository;
	
	
	@Override
	public List<Actividades> listaActividades() {
		return (List<Actividades>) actividadesRepository.findAll();
	}

	@Override
	public void guardarActividades(Actividades actividad) {
		actividadesRepository.save(actividad);
	}

	@Override
	public Actividades buscarActividadesPorId(Integer id) {
		return actividadesRepository.findById(id).orElseGet(null);
	}

	@Override
	public void eliminarActividad(Integer id) {
		actividadesRepository.deleteById(id);
	}

}
