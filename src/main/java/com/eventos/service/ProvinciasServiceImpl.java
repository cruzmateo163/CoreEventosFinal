package com.eventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventos.model.Provincias;
<<<<<<< HEAD

=======
import com.eventos.repository.PaisesRepository;
>>>>>>> d53262b4b500b1f4cb96fa395772158359125048
import com.eventos.repository.ProvinciasRepository;

@Service
public class ProvinciasServiceImpl implements IProvinciasService {

	@Autowired
	private ProvinciasRepository provinciasRepository;
	
	@Override
	public List<Provincias> listaProvincias() {
		
		return (List<Provincias>) provinciasRepository.findAll();
	}

}
