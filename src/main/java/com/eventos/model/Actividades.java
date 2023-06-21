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
@Table(name="actividades")
public class Actividades {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_actividad")
	private Integer idActividad;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuarios usuario;

	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categorias categoria;

	public Actividades() {
	}

	public Actividades(String nombre, String descripcion, Usuarios usuario, Categorias categoria) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuario = usuario;
		this.categoria = categoria;
	}

	public Actividades(Integer idActividad, String nombre, String descripcion, Usuarios usuario, Categorias categoria) {
		this.idActividad = idActividad;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuario = usuario;
		this.categoria = categoria;
	}

	public Integer getIdActividad() {
		return idActividad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public Categorias getCategoria() {
		return categoria;
	}

	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Actividades [idActividad=" + idActividad + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", usuario=" + usuario + ", categoria=" + categoria + "]";
	}
	
	
	

}
