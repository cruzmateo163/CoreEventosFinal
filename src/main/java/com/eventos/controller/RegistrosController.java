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
import com.eventos.model.Registros;
import com.eventos.service.IActividadesService;
import com.eventos.service.IEventosService;
import com.eventos.service.IRegistrosService;

@Controller
@RequestMapping("/registros")
public class RegistrosController {

	@Autowired
	private IRegistrosService registrosService;
	
	@Autowired
	private IEventosService eventosService;
	
	@Autowired
	private IActividadesService actividadesService;
	
	
	@GetMapping("")
	public String listarRegistros(Model model) {
		
		List<Registros> listadoRegistros = registrosService.listaRegistros();
		
		model.addAttribute("titulo", "Lista de Registros en Evento");
		model.addAttribute("registros", listadoRegistros);		
		return "listar-registros";
	}
	
	
	@GetMapping("/create") 
	public String create(Model model) {
			
		Registros registro = new Registros();
		List<Eventos> listEvento = eventosService.listaEventos();
		List<Actividades> listActividades = actividadesService.listaActividades();
		
		
		model.addAttribute("titulo", "Registrese en un Evento");
		model.addAttribute("registro", registro);
		model.addAttribute("evento", listEvento);
		model.addAttribute("actividad", listActividades);
		return "agregar-registros";
	}
	
	
	@PostMapping("/save")
	public String save (@ModelAttribute Registros registro) {
		
		registrosService.guardarRegistros(registro);
		
		return "redirect:/registros";
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id ) {
		Registros registro = registrosService.buscarRegistrosPorId(id);
		registrosService.eliminarRegistros(id);
		return "redirect:/registros";
	}
	
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer idRegistro, Model model) {
		Registros registro =  registrosService.buscarRegistrosPorId(idRegistro);
		
		List<Eventos> listEvento = eventosService.listaEventos();
		List<Actividades> listActividades = actividadesService.listaActividades();
		
		model.addAttribute("titulo", "Formulario: Editar Registros");
		model.addAttribute("registro", registro);
		model.addAttribute("evento", listEvento);
		model.addAttribute("actividad", listActividades);
		return "agregar-registros";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
