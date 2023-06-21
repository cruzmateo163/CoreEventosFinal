package com.eventos.service;

<<<<<<< HEAD
import java.time.LocalDate;
=======
>>>>>>> d53262b4b500b1f4cb96fa395772158359125048
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventos.model.Eventos;
<<<<<<< HEAD
import com.eventos.model.Inscripciones;
=======
>>>>>>> d53262b4b500b1f4cb96fa395772158359125048
import com.eventos.repository.EventosRepository;


@Service
public class EventosServiceImpl implements IEventosService {

	@Autowired
	private EventosRepository eventosRepository;
	
	@Override
	public List<Eventos> listaEventos() {
		return (List<Eventos>) eventosRepository.findAll();
	}

	@Override
	public void guardarEventos(Eventos evento) {
		eventosRepository.save(evento);

	}

	@Override
	public Eventos buscarEventoPorId(Integer id) {
		return eventosRepository.findById(id).orElseGet(null);
	}

	@Override
	public void eliminarEvento(Integer id) {
		eventosRepository.deleteById(id);
	}

<<<<<<< HEAD

=======
>>>>>>> d53262b4b500b1f4cb96fa395772158359125048
}
