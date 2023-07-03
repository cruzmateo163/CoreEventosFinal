package com.eventos.controller.api;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eventos.model.Actividades;
import com.eventos.model.Categorias;
import com.eventos.model.Usuarios;
import com.eventos.service.IActividadesService;
import com.eventos.service.ICategoriasService;
import com.eventos.service.IUsuariosService;

@RestController
@RequestMapping("/api/actividades")
public class ActividadesControllerAPI {

	@Autowired
	private IActividadesService actividadesService;

	@Autowired
	private IUsuariosService usuariosService;

	@Autowired
	private ICategoriasService categoriasService;

	@GetMapping("")
	public List<Actividades> listarActividades() {
		return actividadesService.listaActividades();
	}

	@GetMapping("/{id}")
	public Actividades getActividad(@PathVariable Integer id) {
		return actividadesService.buscarActividadesPorId(id);
	}

	@PostMapping("")
	public Actividades createActividad(@RequestBody Actividades actividad) {
		actividadesService.guardarActividades(actividad);
		return actividad;
	}

	@PutMapping("/{id}")
	public Actividades updateActividad(@PathVariable Integer id, @RequestBody Actividades actividad) {
		actividad.setIdActividad(id);
		actividadesService.guardarActividades(actividad);
		return actividad;
	}

	@DeleteMapping("/{id}")
	public void deleteActividad(@PathVariable Integer id) {
		Actividades actividad = actividadesService.buscarActividadesPorId(id);
		actividadesService.eliminarActividad(id);
	}

	@GetMapping("/filtrar")
	public List<Actividades> filtrarActividadesPorFecha1(
			@RequestParam("fechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaInicio,
			@RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaFin) {

		return actividadesService.listaActividadesPorFecha(fechaInicio, fechaFin);
	}

	@GetMapping("/filtraractividades")
	public ResponseEntity<List<Actividades>> filtrarActividadesPorFecha(
			@RequestParam("fechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaInicio,
			@RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaFin) {

		List<Actividades> actividadesFiltradas = actividadesService.listaActividadesPorFecha(fechaInicio, fechaFin);
		return ResponseEntity.ok(actividadesFiltradas);
	}

}
