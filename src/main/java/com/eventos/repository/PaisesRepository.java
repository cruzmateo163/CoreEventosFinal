package com.eventos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eventos.model.Paises;

@Repository
public interface PaisesRepository extends CrudRepository<Paises, Integer> {

}
