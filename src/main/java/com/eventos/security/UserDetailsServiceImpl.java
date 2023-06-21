package com.eventos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.eventos.model.Usuarios;
import com.eventos.repository.UsuariosRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuarios usuario = usuariosRepository
				.findOneByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("El usuario con email "+ email + "no existe"));
		    	
		return new UserDetailsImpl(usuario);
	}

}
