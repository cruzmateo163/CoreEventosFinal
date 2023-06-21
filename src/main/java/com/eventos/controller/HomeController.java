package com.eventos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@GetMapping({"/inicio"})
	public String index() {
		
		return "index";
		
	}

	
	@GetMapping({"/end"})
	public String salir() {
		
		return "login";
	}

	
	@GetMapping({"/logout"})
	public String logout() {
		
		return "";
	}

	
}

