package com.eventos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="inscripciones")
public class Inscripciones {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_inscripcion")
	private Integer idInscripcion;
	
	@ManyToOne
	@JoinColumn(name="id_evento")
	private Eventos evento;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuarios usuario;

	public Inscripciones() {
		
	}

	
	public Inscripciones(Eventos evento) {
		
		this.evento = evento;
		
	}
	
	public Inscripciones(Eventos evento, Usuarios usuario) {
		
		this.evento = evento;
		this.usuario = usuario;
	}

	public Inscripciones(Integer idInscripcion, Eventos evento, Usuarios usuario) {
		
		this.idInscripcion = idInscripcion;
		this.evento = evento;
		this.usuario = usuario;
	}

	public Integer getIdInscripcion() {
		return idInscripcion;
	}

	public Eventos getEvento() {
		return evento;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setIdInscripcion(Integer idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	public void setEvento(Eventos evento) {
		this.evento = evento;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Inscripciones [idInscripcion=" + idInscripcion + ", evento=" + evento + ", usuario=" + usuario + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
