package com.eventos.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.eventos.model.Tipos;

public class UsuarioRegistroDto {
	
	private String cedula;
	private String nombre;
	private String apellido;
	private String email;
	@DateTimeFormat(pattern="yyy-MM-dd")
	private Date fechaNacimiento;
	private String contrasena;
	private String genero;
	private Tipos tipo;
	
	
	public UsuarioRegistroDto() {
		
	}

	
	public UsuarioRegistroDto(String cedula, String nombre, String apellido, String email, Date fechaNacimiento,
			String contrasena, String genero, Tipos tipo) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.contrasena = contrasena;
		this.genero = genero;
		this.tipo = tipo;
	}
	
	


	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Tipos getTipo() {
		return tipo;
	}

	public void setTipo(Tipos tipo) {
		this.tipo = tipo;
	}



}
