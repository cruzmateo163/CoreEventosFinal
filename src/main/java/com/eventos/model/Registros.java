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
@Table(name="registros")
public class Registros {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_registro")
	private Integer idRegistro;

	@ManyToOne
	@JoinColumn(name="id_evento")
	private Eventos evento;

	@ManyToOne
	@JoinColumn(name="id_actividad")
	private Actividades actividad;

	public Registros() {
		
	}

	public Registros(Eventos evento, Actividades actividad) {
		super();
		this.evento = evento;
		this.actividad = actividad;
	}

	public Registros(Integer idRegistro, Eventos evento, Actividades actividad) {
		super();
		this.idRegistro = idRegistro;
		this.evento = evento;
		this.actividad = actividad;
	}

	public Integer getIdRegistro() {
		return idRegistro;
	}

	public Eventos getEvento() {
		return evento;
	}

	public Actividades getActividad() {
		return actividad;
	}

	public void setIdRegistro(Integer idRegistro) {
		this.idRegistro = idRegistro;
	}

	public void setEvento(Eventos evento) {
		this.evento = evento;
	}

	public void setActividad(Actividades actividad) {
		this.actividad = actividad;
	}

	@Override
	public String toString() {
		return "Registros [idRegistro=" + idRegistro + ", evento=" + evento + ", actividad=" + actividad + "]";
	}
	
	
	
	
	
	
}
