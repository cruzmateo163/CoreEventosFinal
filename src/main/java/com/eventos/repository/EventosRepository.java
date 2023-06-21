package com.eventos.repository;

<<<<<<< HEAD
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
=======
>>>>>>> d53262b4b500b1f4cb96fa395772158359125048
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eventos.model.Eventos;

@Repository
<<<<<<< HEAD
public interface EventosRepository extends JpaRepository<Eventos, Integer> {
	
	//List<Eventos> findByFecha(LocalDate fechaInicio);
=======
public interface EventosRepository extends CrudRepository<Eventos, Integer> {
>>>>>>> d53262b4b500b1f4cb96fa395772158359125048

}
