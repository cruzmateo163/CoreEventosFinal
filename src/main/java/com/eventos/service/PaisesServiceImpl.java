package com.eventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventos.model.Paises;
import com.eventos.repository.PaisesRepository;

@Service
public class PaisesServiceImpl implements IPaisesService {

	@Autowired
	private PaisesRepository paisesRepository;
	
	@Override
	public List<Paises> listaPaises() {
		
		return (List<Paises>) paisesRepository.findAll();
	}

}
