package com.eventos.service;

import java.util.List;

<<<<<<< HEAD
import org.springframework.security.core.userdetails.UserDetailsService;

import com.eventos.dto.UsuarioRegistroDto;
=======
>>>>>>> d53262b4b500b1f4cb96fa395772158359125048
import com.eventos.model.Usuarios;

public interface IUsuariosService {

	public List<Usuarios> listaUser();
	public void guardarUser(Usuarios usuario);
	public Usuarios buscarUserPorId(Integer id);
	public void eliminarUser(Integer id);
<<<<<<< HEAD
	
	Usuarios save(UsuarioRegistroDto registroDto);
=======
	public Usuarios validar(String usuario, String clave);
>>>>>>> d53262b4b500b1f4cb96fa395772158359125048
	
}
