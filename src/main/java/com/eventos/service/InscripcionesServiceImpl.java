package com.eventos.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventos.model.Eventos;
import com.eventos.model.Inscripciones;
import com.eventos.repository.EventosRepository;
import com.eventos.repository.InscripcionesRepository;

@Service
public class InscripcionesServiceImpl implements IInscripcionesService {
	
	@Autowired
	private InscripcionesRepository inscripcionesRepository;

	
	@Override
	public List<Inscripciones> listaInscripciones() {

		return (List<Inscripciones>) inscripcionesRepository.findAll();
	}

	
	@Override
	public List<Inscripciones> listaInscripcionesTexto(String palabraClave) {
		if(palabraClave != null) {
			return (List<Inscripciones>) inscripcionesRepository.findAll(palabraClave);
		}
		
		return (List<Inscripciones>) inscripcionesRepository.findAll();
	}
	
	@Override
	public void guardarInscripciones(Inscripciones inscripcion) {
		inscripcionesRepository.save(inscripcion);
	}

	@Override
	public Inscripciones buscarInscripcionesPorId(Integer id) {
		
		return inscripcionesRepository.findById(id).orElseGet(null);
	}

	@Override
	public void eliminarInscripciones(Integer id) {
		inscripcionesRepository.deleteById(id);

	}





	

}
