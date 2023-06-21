package com.eventos.service;

<<<<<<< HEAD

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.eventos.dto.UsuarioRegistroDto;
import com.eventos.model.Tipos;
=======
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

>>>>>>> d53262b4b500b1f4cb96fa395772158359125048
import com.eventos.model.Usuarios;
import com.eventos.repository.UsuariosRepository;



@Service
public class UsuariosServiceImpl implements IUsuariosService {

<<<<<<< HEAD
	
=======
>>>>>>> d53262b4b500b1f4cb96fa395772158359125048
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	@Autowired
<<<<<<< HEAD
	private PasswordEncoder passwordEncoder; 
	
	
=======
	private SessionFactory sessionFactory;
>>>>>>> d53262b4b500b1f4cb96fa395772158359125048
	
	@Override
	public List<Usuarios> listaUser() {
		return (List<Usuarios>) usuariosRepository.findAll();
	}

	@Override
	public void guardarUser(Usuarios usuario) {
		usuariosRepository.save(usuario);
	}

	@Override
	public Usuarios buscarUserPorId(Integer id) {
		return usuariosRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminarUser(Integer id) {
		usuariosRepository.deleteById(id);

	}

<<<<<<< HEAD

	@Override
	public Usuarios save(UsuarioRegistroDto registroDto) {
		Usuarios user = new Usuarios(registroDto.getCedula(),
				registroDto.getNombre(),registroDto.getApellido(),
				registroDto.getEmail(),registroDto.getFechaNacimiento(),
				passwordEncoder.encode(registroDto.getContrasena()),
				registroDto.getGenero(), registroDto.getTipo());
	
		return usuariosRepository.save(user);
	}


=======
	@Override
	public Usuarios validar(String usuario, String clave) {
		
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(
				"Select US "
				+ " from Usuarios US"
				+ " Where US.cedula = : cedula and US.contrasena = : clave"
				,Usuarios.class);
		
		query.setParameter("cedula", usuario);
		query.setParameter("clave", clave);
		System.out.print(query.getSingleResult());
				
		return (Usuarios)query.getSingleResult();
	}

	
>>>>>>> d53262b4b500b1f4cb96fa395772158359125048
	
}
