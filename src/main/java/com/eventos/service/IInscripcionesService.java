package com.eventos.service;

import java.time.LocalDate;
import java.util.List;

import com.eventos.model.Eventos;
import com.eventos.model.Inscripciones;

public interface IInscripcionesService {

	public List<Inscripciones> listaInscripciones();
	public List<Inscripciones> listaInscripcionesTexto(String palabraClave);
	public void guardarInscripciones(Inscripciones inscripcion);
	public Inscripciones buscarInscripcionesPorId(Integer id);
	public void eliminarInscripciones(Integer id);
	
	
	
}
