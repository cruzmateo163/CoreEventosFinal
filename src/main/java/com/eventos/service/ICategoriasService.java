package com.eventos.service;

import java.util.List;

import com.eventos.model.Categorias;
import com.eventos.model.Usuarios;


public interface ICategoriasService {

	public List<Categorias> listaCategorias();
	public void guardarCategoria(Categorias categoria);
	public Categorias buscarCatPorId(Integer id);
	public void eliminarCategoria(Integer id);
	

}
