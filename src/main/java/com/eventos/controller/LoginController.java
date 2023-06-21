package com.eventos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eventos.model.Usuarios;
import com.eventos.service.IUsuariosService;

@Controller
@RequestMapping
public class LoginController {
	
	private IUsuariosService usuariosService;
	
	@PostMapping("/login")
	public String login(@RequestParam String usuario, @RequestParam String contrasena, Model model) {
		
		System.out.print(usuario+ " " +contrasena);
		
		Usuarios user = usuariosService.validar(usuario, contrasena);
		model.addAttribute("usuario", user.getCedula());

		return "menu";
		
		
	}

}
