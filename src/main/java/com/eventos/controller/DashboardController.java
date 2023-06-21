package com.eventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eventos.model.Inscripciones;
import com.eventos.service.IInscripcionesService;


@Controller
public class DashboardController {

	@Autowired
	private IInscripcionesService inscripcionesService;
	
	
	@RequestMapping("/")
    public String obtenerEventoFiltrados(@Param("palabraClave") String palabraClave, Model model) {
		
		List<Inscripciones> listIncripciones = inscripcionesService.listaInscripcionesTexto(palabraClave);
	
		model.addAttribute("titulo", "Dashboard - Filtrar Usuarios Inscritos por Evento");
		model.addAttribute("inscripcion", listIncripciones);
		model.addAttribute("palabraClave", palabraClave);

        return "dashboard"; 
    }
}
