package com.eventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eventos.model.Categorias;
import com.eventos.model.Tipos;
import com.eventos.model.Usuarios;
import com.eventos.service.ICategoriasService;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {

	@Autowired
	private ICategoriasService categoriasService;
	
	@GetMapping("")
	public String listarCategorias(Model model) {
		
		List<Categorias> listadoCategorias = categoriasService.listaCategorias();
		
		model.addAttribute("titulo", "Lista de categorias");
		model.addAttribute("categorias", listadoCategorias);
		
		return  "listar-categorias";
		
	}
	
	@GetMapping("/create") //http://localhost:8080/categorias/create
	public String create(Model model) {
			
		Categorias categorias = new Categorias();
		
		model.addAttribute("titulo", "Ingrese una Categoría");
		model.addAttribute("categoria", categorias);
		return "agregar-categorias";
	}
	
	
	
	@PostMapping("/save")
	public String save (@ModelAttribute Categorias categorias) {
		
		categoriasService.guardarCategoria(categorias);
		
		return "redirect:/categorias";
	}

	@GetMapping("/delete/{id}")
	public String delete (@PathVariable Integer id ) {
		Categorias categorias = categoriasService.buscarCatPorId(id);
		categoriasService.eliminarCategoria(id);
		
		return "redirect:/categorias";
	}
	
	@GetMapping("/edit/{id}")
	public String edit (@PathVariable("id") Integer id, Model model) {
		Categorias categoria = categoriasService.buscarCatPorId(id);
		
		
		model.addAttribute("titulo", "Formulario: Editar Categorías");
		model.addAttribute("categoria", categoria);

		return "agregar-categorias";
	}
	
	
}
