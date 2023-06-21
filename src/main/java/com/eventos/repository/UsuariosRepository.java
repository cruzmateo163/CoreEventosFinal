package com.eventos.repository;


<<<<<<< HEAD

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
=======
>>>>>>> d53262b4b500b1f4cb96fa395772158359125048
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eventos.model.Usuarios;

@Repository
<<<<<<< HEAD
public interface UsuariosRepository extends JpaRepository <Usuarios, Integer > {
	
	Optional<Usuarios> findOneByEmail(String email);
	
=======
public interface UsuariosRepository extends CrudRepository <Usuarios,Integer > {
	

>>>>>>> d53262b4b500b1f4cb96fa395772158359125048
}
