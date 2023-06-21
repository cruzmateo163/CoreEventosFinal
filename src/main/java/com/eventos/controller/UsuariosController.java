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

import com.eventos.model.Tipos;
import com.eventos.model.Usuarios;
import com.eventos.repository.UsuariosRepository;
import com.eventos.service.ITiposService;
import com.eventos.service.IUsuariosService;

@Controller
@RequestMapping("/usuarios")  //http://localhost:8080/usuarios
public class UsuariosController {
	
	@Autowired
	private IUsuariosService usuariosService;
	
	@Autowired
	private ITiposService tiposService;
	
	@GetMapping("")
	public String listarUsuarios(Model model) {
		
		List<Usuarios> listadoUsuarios = usuariosService.listaUser();
		
		model.addAttribute("titulo", "Lista de Usuarios");
		model.addAttribute("usuarios", listadoUsuarios);
		return "listar-usuarios";
	}
	
	
	
	@GetMapping("/create") //http://localhost:8080/usuarios/create
	public String create(Model model) {
			
		Usuarios usuario = new Usuarios();
		List<Tipos> listTipos = tiposService.listaTipos();
		
		model.addAttribute("titulo", "Ingrese un Usuario");
		model.addAttribute("usuario", usuario);
		model.addAttribute("tipos", listTipos);
		return "agregar-usuarios";
	}
	
	@PostMapping("/save")
	public String save (@ModelAttribute Usuarios usuario) {
		
		usuariosService.guardarUser(usuario);
		
		return "redirect:/usuarios";
	}

	@GetMapping("/delete/{id}")
	public String delete (@PathVariable Integer id ) {
		Usuarios usuario = usuariosService.buscarUserPorId(id);
		usuariosService.eliminarUser(id);
		
		return "redirect:/usuarios";
	}
	
<<<<<<< HEAD

	
=======
>>>>>>> d53262b4b500b1f4cb96fa395772158359125048
	@GetMapping("/edit/{id}")
	public String edit (@PathVariable("id") Integer id, Model model) {
		Usuarios usuario = usuariosService.buscarUserPorId(id);
		
		List<Tipos> listTipos = tiposService.listaTipos();
		
		model.addAttribute("titulo", "Formulario: Editar Cliente");
		model.addAttribute("usuario", usuario);
		model.addAttribute("tipos", listTipos);
		return "agregar-usuarios";
	}
	
<<<<<<< HEAD
=======

>>>>>>> d53262b4b500b1f4cb96fa395772158359125048
	
}
