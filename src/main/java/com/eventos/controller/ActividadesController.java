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

import com.eventos.model.Actividades;
import com.eventos.model.Categorias;
import com.eventos.model.Usuarios;
import com.eventos.service.IActividadesService;
import com.eventos.service.ICategoriasService;
import com.eventos.service.IUsuariosService;

@Controller
@RequestMapping("/actividades")
public class ActividadesController {
	
	@Autowired
	private IActividadesService actividadesService;
	@Autowired
	private IUsuariosService usuariosService;
	@Autowired
	private ICategoriasService categoriasService;
	
	@GetMapping("")
	public String listarActividades(Model model) {
		
		List<Actividades> listadoActividades = actividadesService.listaActividades();
		
		model.addAttribute("titulo", "Lista de Actividades");
		model.addAttribute("actividades", listadoActividades);		
		return "listar-actividades";
	}
	
	@GetMapping("/create") 
	public String create(Model model) {
			
		Actividades actividad = new Actividades();
		List<Usuarios> listUsuario = usuariosService.listaUser();
		List<Categorias> listCategoria = categoriasService.listaCategorias();
		
		
		model.addAttribute("titulo", "Ingrese una Actividad");
		model.addAttribute("actividad", actividad);
		model.addAttribute("usuario", listUsuario);
		model.addAttribute("categoria", listCategoria);
		return "agregar-actividades";
	}
	
	@PostMapping("/save")
	public String save (@ModelAttribute Actividades actividad) {
		
		actividadesService.guardarActividades(actividad);
		
		return "redirect:/actividades";
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id ) {
		Actividades actividad = actividadesService.buscarActividadesPorId(id);
		actividadesService.eliminarActividad(id);
		return "redirect:/actividades";
	}
	
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer idActividad, Model model) {
		Actividades actividad = actividadesService.buscarActividadesPorId(idActividad);
		
		List<Usuarios> listUsuario = usuariosService.listaUser();
		List<Categorias> listCategoria = categoriasService.listaCategorias();
		
		model.addAttribute("titulo", "Formulario: Editar Actividades");
		model.addAttribute("actividad", actividad);
		model.addAttribute("usuario", listUsuario);
		model.addAttribute("categoria", listCategoria);
		return "agregar-actividades";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
