package com.eventos.service;

<<<<<<< HEAD
import java.time.LocalDate;
import java.util.List;
import com.eventos.model.Eventos;
import com.eventos.model.Inscripciones;
=======
import java.util.List;
import com.eventos.model.Eventos;
>>>>>>> d53262b4b500b1f4cb96fa395772158359125048


public interface IEventosService {

	public List<Eventos> listaEventos();
	public void guardarEventos(Eventos evento);
	public Eventos buscarEventoPorId(Integer id);
	public void eliminarEvento(Integer id);
<<<<<<< HEAD


=======
>>>>>>> d53262b4b500b1f4cb96fa395772158359125048
	
}
