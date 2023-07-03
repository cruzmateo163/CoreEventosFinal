package com.eventos.controller.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.eventos.model.Tipos;
import com.eventos.model.Ciudades;
import com.eventos.model.Eventos;
import com.eventos.model.Paises;
import com.eventos.model.Provincias;
import com.eventos.service.ICiudadesService;
import com.eventos.service.IEventosService;
import com.eventos.service.IPaisesService;
import com.eventos.service.IProvinciasService;

@RestController
@RequestMapping("/api/eventos")
public class EventosControllerAPI {

	private final Logger logg = LoggerFactory.getLogger(Tipos.class);

	@Autowired
	private IEventosService eventosService;

	@Autowired
	private IPaisesService paisesService;

	@Autowired
	private IProvinciasService provinciasService;

	@Autowired
	private ICiudadesService ciudadesService;

	@GetMapping("")
	public List<Eventos> listarEventos() {
		return eventosService.listaEventos();
	}

	@GetMapping("/{id}")
	public Eventos getEvento(@PathVariable Integer id) {
		return eventosService.buscarEventoPorId(id);
	}

	@PostMapping("")
	public Eventos createEvento(@RequestBody Eventos evento) {
		eventosService.guardarEventos(evento);
		return evento;
	}

	@PutMapping("/{id}")
	public Eventos updateEvento(@PathVariable Integer id, @RequestBody Eventos evento) {
		evento.setIdEvento(id);
		eventosService.guardarEventos(evento);
		return evento;
	}

	@DeleteMapping("/{id}")
	public void deleteEvento(@PathVariable Integer id) {
		Eventos evento = eventosService.buscarEventoPorId(id);
		logg.info("Objeto eliminado {}", evento);
		eventosService.eliminarEvento(id);
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
