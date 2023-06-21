package com.eventos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.eventos.model.Ciudades;

@Repository
public interface CiudadesRepository extends CrudRepository<Ciudades, Integer> {

}
