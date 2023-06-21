package com.eventos.service;

import java.util.List;

import com.eventos.model.Actividades;


public interface IActividadesService {

	public List<Actividades> listaActividades();
	public void guardarActividades(Actividades actividad);
	public Actividades buscarActividadesPorId(Integer id);
	public void eliminarActividad(Integer id);
	
}
