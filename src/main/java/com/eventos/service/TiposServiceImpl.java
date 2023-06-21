package com.eventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventos.model.Tipos;
import com.eventos.repository.TiposRepository;

@Service
public class TiposServiceImpl implements ITiposService {

	@Autowired
	private TiposRepository tiposRepository;
	
	@Override
	public List<Tipos> listaTipos() {
		return (List<Tipos>) tiposRepository.findAll();
	}

}
