package com.eventos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eventos.model.Provincias;

@Repository
public interface ProvinciasRepository extends CrudRepository<Provincias, Integer>{

}
