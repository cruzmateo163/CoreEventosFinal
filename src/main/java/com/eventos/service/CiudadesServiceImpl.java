package com.eventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventos.model.Ciudades;
import com.eventos.repository.CiudadesRepository;

@Service
public class CiudadesServiceImpl implements ICiudadesService {

	@Autowired
	private CiudadesRepository ciudadesRepository;
	
	@Override
	public List<Ciudades> listaCiudades() {
		
		return (List<Ciudades>) ciudadesRepository.findAll();
	}

}
