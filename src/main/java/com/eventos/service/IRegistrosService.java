package com.eventos.service;

import java.util.List;

import com.eventos.model.Registros;


public interface IRegistrosService {

	public List<Registros> listaRegistros();
	public void guardarRegistros(Registros registro);
	public Registros buscarRegistrosPorId(Integer id);
	public void eliminarRegistros(Integer id);
	
	
}
