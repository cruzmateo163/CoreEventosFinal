package com.eventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventos.model.Categorias;

import com.eventos.repository.CategoriasRepository;

@Service
public class CategoriasServiceImpl implements ICategoriasService {

	
	@Autowired
	private CategoriasRepository categoriasRepository;
	
	
	@Override
	public List<Categorias> listaCategorias() {
	
		return (List<Categorias>) categoriasRepository.findAll();
	}


	@Override
	public void guardarCategoria(Categorias categoria) {
		
		categoriasRepository.save(categoria);
	}


	@Override
	public Categorias buscarCatPorId(Integer id) {
		
		return categoriasRepository.findById(id).orElse(null);
	}


	@Override
	public void eliminarCategoria(Integer id) {
		categoriasRepository.deleteById(id);
		
	}

}
