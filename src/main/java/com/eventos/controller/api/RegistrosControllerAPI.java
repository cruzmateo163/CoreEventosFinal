package com.eventos.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eventos.model.Actividades;
import com.eventos.model.Eventos;
import com.eventos.model.Registros;
import com.eventos.service.IActividadesService;
import com.eventos.service.IEventosService;
import com.eventos.service.IRegistrosService;

@RestController
@RequestMapping("/api/registros")
public class RegistrosControllerAPI {

	@Autowired
	private IRegistrosService registrosService;
	
	@Autowired
	private IEventosService eventosService;
	
	@Autowired
	private IActividadesService actividadesService;
	
	@GetMapping("")
	public List<Registros> listarRegistros() {
		return registrosService.listaRegistros();
	}

	@GetMapping("/{id}")
	public Registros getRegistro(@PathVariable Integer id) {
		return registrosService.buscarRegistrosPorId(id);
	}

	@PostMapping("")
	public Registros createRegistro(@RequestBody Registros registro) {
		registrosService.guardarRegistros(registro);
		return registro;
	}

	@PutMapping("/{id}")
	public Registros updateRegistro(@PathVariable Integer id, @RequestBody Registros registro) {
		registro.setIdRegistro(id);
		registrosService.guardarRegistros(registro);
		return registro;
	}

	@DeleteMapping("/{id}")
	public void deleteRegistro(@PathVariable Integer id) {
		Registros registro = registrosService.buscarRegistrosPorId(id);
		registrosService.eliminarRegistros(id);
	}

	@GetMapping("/{idRegistro}/eventos")
	public Eventos getEvento(@PathVariable Integer idRegistro) {
		Registros registro = registrosService.buscarRegistrosPorId(idRegistro);
		return registro.getEvento();
	}

	@GetMapping("/{idRegistro}/actividades")
	public List<Actividades> getActividades(@PathVariable Integer idRegistro) {
		Registros registro = registrosService.buscarRegistrosPorId(idRegistro);
		return (List<Actividades>) registro.getActividad();
	}
}

	
	
	
	

