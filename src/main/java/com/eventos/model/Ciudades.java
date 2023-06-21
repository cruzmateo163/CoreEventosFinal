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
@Table(name="ciudades")
public class Ciudades {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ciudad")
	private Integer idCiudad;
	@Column(name="codigo")
	private String codigo;
	@Column(name="nombre")
	private String nombre;
	@Column(name="descripcion")
	private String descripcion;
	@ManyToOne
	@JoinColumn(name="id_provincia")
	private Provincias provincia;
	
	public Ciudades() {
		super();
	}

	public Ciudades(String codigo, String nombre, String descripcion, Provincias provincia) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.provincia = provincia;
	}

	public Ciudades(Integer idCiudad, String codigo, String nombre, String descripcion, Provincias provincia) {
		super();
		this.idCiudad = idCiudad;
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.provincia = provincia;
	}

	public Integer getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Integer idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Provincias getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincias provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return "Ciudades [idCiudad=" + idCiudad + ", codigo=" + codigo + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", provincia=" + provincia + "]";
	}

	
	
}
