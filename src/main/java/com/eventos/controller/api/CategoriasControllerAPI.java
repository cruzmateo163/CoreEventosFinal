package com.eventos.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eventos.model.Categorias;
import com.eventos.service.ICategoriasService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriasControllerAPI {

	@Autowired
	private ICategoriasService categoriasService;

	@GetMapping("")
	public List<Categorias> listarCategorias() {
		return categoriasService.listaCategorias();
	}

	@GetMapping("/{id}")
	public Categorias getCategoria(@PathVariable Integer id) {
		return categoriasService.buscarCatPorId(id);
	}

	@PostMapping("")
	public Categorias createCategoria(@RequestBody Categorias categoria) {
		categoriasService.guardarCategoria(categoria);
		return categoria;
	}

	@PutMapping("/{id}")
	public Categorias updateCategoria(@PathVariable Integer id, @RequestBody Categorias categoria) {
		categoria.setIdCategoria(id);
		categoriasService.guardarCategoria(categoria);
		return categoria;
	}

	@DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable Integer id) {
		Categorias categoria = categoriasService.buscarCatPorId(id);
		categoriasService.eliminarCategoria(id);
	}
}
