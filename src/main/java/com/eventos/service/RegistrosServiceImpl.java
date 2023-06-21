package com.eventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventos.model.Registros;
import com.eventos.repository.RegistrosRepository;

@Service
public class RegistrosServiceImpl implements IRegistrosService {
	
	@Autowired
	private RegistrosRepository registrosRepository;
	

	@Override
	public List<Registros> listaRegistros() {
		
		return (List<Registros>) registrosRepository.findAll();
	}

	@Override
	public void guardarRegistros(Registros registro) {
		registrosRepository.save(registro);

	}

	@Override
	public Registros buscarRegistrosPorId(Integer id) {
		
		return registrosRepository.findById(id).orElseGet(null);
	}

	@Override
	public void eliminarRegistros(Integer id) {
		registrosRepository.deleteById(id);

	}

}
