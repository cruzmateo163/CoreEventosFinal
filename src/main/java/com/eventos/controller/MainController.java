package com.eventos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class MainController {
	
	@RequestMapping("/login")
	public String login() {				
			return "login";
		}
			
	


}
