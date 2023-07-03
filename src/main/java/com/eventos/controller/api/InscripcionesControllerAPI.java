package com.eventos.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eventos.model.Eventos;
import com.eventos.model.Inscripciones;
import com.eventos.model.Usuarios;
import com.eventos.service.IEventosService;
import com.eventos.service.IInscripcionesService;
import com.eventos.service.IUsuariosService;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionesControllerAPI {

	@Autowired
	private IInscripcionesService inscripcionesService;

	@Autowired
	private IEventosService eventosService;

	@Autowired
	private IUsuariosService usuariosService;

	@GetMapping("")
	public List<Inscripciones> listarInscripciones() {
		return inscripcionesService.listaInscripciones();
	}

	@GetMapping("/{id}")
	public Inscripciones getInscripcion(@PathVariable Integer id) {
		return inscripcionesService.buscarInscripcionesPorId(id);
	}

	@PostMapping("")
	public Inscripciones createInscripcion(@RequestBody Inscripciones inscripcion) {
		inscripcionesService.guardarInscripciones(inscripcion);
		return inscripcion;
	}

	@PutMapping("/{id}")
	public Inscripciones updateInscripcion(@PathVariable Integer id, @RequestBody Inscripciones inscripcion) {
		inscripcion.setIdInscripcion(id);
		inscripcionesService.guardarInscripciones(inscripcion);
		return inscripcion;
	}

	@DeleteMapping("/{id}")
	public void deleteInscripcion(@PathVariable Integer id) {
		Inscripciones inscripcion = inscripcionesService.buscarInscripcionesPorId(id);
		inscripcionesService.eliminarInscripciones(id);
	}

	@GetMapping("/{idInscripcion}/evento")
	public Eventos getEvento(@PathVariable Integer idInscripcion) {
		Inscripciones inscripcion = inscripcionesService.buscarInscripcionesPorId(idInscripcion);
		return inscripcion.getEvento();
	}

	@GetMapping("/{idInscripcion}/usuario")
	public Usuarios getUsuario(@PathVariable Integer idInscripcion) {
		Inscripciones inscripcion = inscripcionesService.buscarInscripcionesPorId(idInscripcion);
		return inscripcion.getUsuario();
	}
}
