package com.eventos.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eventos.model.Ciudades;
import com.eventos.model.Eventos;
import com.eventos.model.Paises;
import com.eventos.model.Provincias;
import com.eventos.model.Tipos;
import com.eventos.service.ICiudadesService;
import com.eventos.service.IEventosService;
import com.eventos.service.IPaisesService;
import com.eventos.service.IProvinciasService;

@Controller
@RequestMapping("/eventos")
public class EventosController {

	private final Logger logg= LoggerFactory.getLogger(Tipos.class);
	
	@Autowired
	private IEventosService eventosService;
	
	@Autowired
	private IPaisesService paisesService;
	
	@Autowired
	private IProvinciasService provinciasService;
	
	@Autowired
	private ICiudadesService ciudadesService;
	
	
	@GetMapping("")
	public String listarEventos(Model model) {
		
		List<Eventos> listadoEventos = eventosService.listaEventos();
		
		model.addAttribute("titulo", "Lista de Eventos");
		model.addAttribute("eventos", listadoEventos);
		return "listar-eventos";
	}
	
	
	
	@GetMapping("/create") 
	public String create(Model model) {
			
		Eventos evento = new Eventos();
		List<Paises> listPais = paisesService.listaPaises();
		List<Provincias> listProvincia = provinciasService.listaProvincias();
		List<Ciudades> listCiudad = ciudadesService.listaCiudades();
		
		model.addAttribute("titulo", "Ingrese un Evento");
		model.addAttribute("evento", evento);
		model.addAttribute("pais", listPais);
		model.addAttribute("provincia", listProvincia);
		model.addAttribute("ciudad", listCiudad);
		return "agregar-eventos";
	}
	
	@PostMapping("/save")
	public String save (@ModelAttribute Eventos evento) {
		
		eventosService.guardarEventos(evento);
		
		return "redirect:/eventos";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id ) {
		Eventos evento = eventosService.buscarEventoPorId(id);
		logg.info("Objeto eliminado {}", evento);
		eventosService.eliminarEvento(id);
		
		return "redirect:/eventos";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer idEvento, Model model) {
		Eventos evento = eventosService.buscarEventoPorId(idEvento);
		logg.info("Objeto recuperado {}", evento);
		List<Paises> listPais = paisesService.listaPaises();
		List<Provincias> listProvincia = provinciasService.listaProvincias();
		List<Ciudades> listCiudad = ciudadesService.listaCiudades();
		
		model.addAttribute("titulo", "Formulario: Editar Eventos");
		model.addAttribute("evento", evento);
		model.addAttribute("pais", listPais);
		model.addAttribute("provincia", listProvincia);
		model.addAttribute("ciudad", listCiudad);
		return "agregar-eventos";
		
	}
	
	
}
