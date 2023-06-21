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
import com.eventos.model.Eventos;
import com.eventos.model.Inscripciones;
import com.eventos.model.Registros;
import com.eventos.model.Usuarios;
import com.eventos.service.IEventosService;
import com.eventos.service.IInscripcionesService;
import com.eventos.service.IUsuariosService;

@Controller
@RequestMapping("/inscripciones")
public class InscripcionesController {
	
	@Autowired
	private IInscripcionesService inscripcionesService;
	
	@Autowired
	private IEventosService eventosService;
	
	@Autowired
	private IUsuariosService usuariosService;
	
	
	@GetMapping("")
	public String listarInscripciones(Model model) {
		
		List<Inscripciones> listadoInscripciones = inscripcionesService.listaInscripciones();
		
		model.addAttribute("titulo", "Lista de Inscripciones a Eventos");
		model.addAttribute("inscripciones", listadoInscripciones);		
		return "listar-inscripciones";
	}
	 
	
	@GetMapping("/create") 
	public String create(Model model) {
			
		Inscripciones inscripcion = new Inscripciones();
		List<Eventos> listEvento = eventosService.listaEventos();
		List<Usuarios> listUsuarios = usuariosService.listaUser();
		
		
		model.addAttribute("titulo", "Inscribete en un Evento");
		model.addAttribute("inscripcion", inscripcion);
		model.addAttribute("evento", listEvento);
		model.addAttribute("usuario", listUsuarios);
		return "agregar-inscripciones";
	}
	
	
	@PostMapping("/save")
	public String save (@ModelAttribute Inscripciones inscripcion) {
		
		inscripcionesService.guardarInscripciones(inscripcion);
		
		return "redirect:/inscripciones";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id ) {
		Inscripciones inscripcion = inscripcionesService.buscarInscripcionesPorId(id);
		inscripcionesService.eliminarInscripciones(id);
		return "redirect:/inscripciones";
	}
	
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer idInscripcion, Model model) {
		Inscripciones inscripcion = inscripcionesService.buscarInscripcionesPorId(idInscripcion);
		
		List<Eventos> listEvento = eventosService.listaEventos();
		List<Usuarios> listUsuarios = usuariosService.listaUser();
	
		model.addAttribute("titulo", "Formulario: Editar Inscripciones");
		model.addAttribute("inscripcion", inscripcion);
		model.addAttribute("evento", listEvento);
		model.addAttribute("usuario", listUsuarios);
		return "agregar-inscripciones";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
