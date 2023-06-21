package com.eventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eventos.dto.UsuarioRegistroDto;
import com.eventos.model.Tipos;
import com.eventos.service.ITiposService;
import com.eventos.service.IUsuariosService;

@Controller
@RequestMapping("/registrar-visitante")
public class UsuarioRegistroController {
	
	@Autowired
	private IUsuariosService usuariosService;
	
	@Autowired
	private ITiposService tiposService;
	
	@ModelAttribute("user")
	public UsuarioRegistroDto usuarioRegistroDto() {
		return new UsuarioRegistroDto();
	}
	
	
	@GetMapping
	public String mostrarFormularioRegistroVisitante(Model model) {
		List<Tipos> listTipos = tiposService.listaTipos();
		
		model.addAttribute("titulo", "Registro de Usuarios");
		model.addAttribute("user", new UsuarioRegistroDto());
		model.addAttribute("tipos", listTipos);
		return "registrar-visitante";
	}
	
	@PostMapping
	public String registroUsuarioVisitante(@ModelAttribute("user") UsuarioRegistroDto registroDto ) {
		usuariosService.save(registroDto);

		//return "redirect:/registrar-visitante?exito";
		return "redirect:/usuarios?exito";
	}
	
	

}
