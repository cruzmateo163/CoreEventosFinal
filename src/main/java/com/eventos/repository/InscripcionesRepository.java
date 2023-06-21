package com.eventos.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eventos.model.Inscripciones;

public interface InscripcionesRepository extends JpaRepository<Inscripciones, Integer> {

	@Query("SELECT i FROM  Inscripciones i INNER JOIN Eventos e ON i.evento = e.idEvento WHERE "
			+ " CONCAT(i.evento,e.idEvento,e.nombre,e.descripcion)"
			+ " LIKE %?1%") 
	public List<Inscripciones> findAll(String palabraClave);
}
