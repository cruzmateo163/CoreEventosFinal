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
@Table(name="provincias")
public class Provincias {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_provincias")
	private Integer idProvincia;
	@Column(name="codigo")
	private String codigo;
	@Column(name="nombre")
	private String nombre;
	@Column(name="descripcion")
	private String descripcion;
	@ManyToOne
	@JoinColumn(name="id_pais")
	private Paises pais;
	
	public Provincias() {
		super();
	}

	public Provincias(String codigo, String nombre, String descripcion, Paises pais) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.pais = pais;
	}

	public Provincias(Integer idProvincia, String codigo, String nombre, String descripcion, Paises pais) {
		super();
		this.idProvincia = idProvincia;
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.pais = pais;
	}

	public Integer getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Integer idProvincia) {
		this.idProvincia = idProvincia;
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

	public Paises getPais() {
		return pais;
	}

	public void setPais(Paises pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Provincias [idProvincia=" + idProvincia + ", codigo=" + codigo + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", pais=" + pais + "]";
	}
	
	
}
