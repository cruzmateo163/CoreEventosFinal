package com.eventos.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eventos.model.Tipos;

@Repository
public interface TiposRepository extends CrudRepository<Tipos, Integer> {

}
