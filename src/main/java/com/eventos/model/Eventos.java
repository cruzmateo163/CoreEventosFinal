package com.eventos.model;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="eventos")
public class Eventos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_evento")
	private Integer idEvento;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="fecha_inicio")
	@DateTimeFormat(pattern="yyy-MM-dd")
	private Date fechaInicio;

	@Column(name="fecha_fin")
	@DateTimeFormat(pattern="yyy-MM-dd")
	private Date fechaFin;
	
	@Column(name="direccion")
	private String direccion;
	
	@ManyToOne
	@JoinColumn(name="id_pais")
	private Paises pais;

	@ManyToOne
	@JoinColumn(name="id_provincia")
	private Provincias provincia;
	
	@ManyToOne
	@JoinColumn(name="id_ciudad")
	private Ciudades ciudad;
<<<<<<< HEAD
	
	@ManyToOne
	@JoinColumn(name="id_actividad")
	private Actividades actividad;
	
=======
>>>>>>> d53262b4b500b1f4cb96fa395772158359125048

	public Eventos() {
		super();
	}
<<<<<<< HEAD
	
	public Eventos(Eventos evento) {
		this.idEvento = idEvento;
	}

=======
>>>>>>> d53262b4b500b1f4cb96fa395772158359125048

	public Eventos(String nombre, String descripcion, Date fechaInicio, Date fechaFin, String direccion, Paises pais,
			Provincias provincia, Ciudades ciudad) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.direccion = direccion;
		this.pais = pais;
		this.provincia = provincia;
		this.ciudad = ciudad;
	}

	public Eventos(Integer idEvento, String nombre, String descripcion, Date fechaInicio, Date fechaFin,
			String direccion, Paises pais, Provincias provincia, Ciudades ciudad) {
		super();
		this.idEvento = idEvento;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.direccion = direccion;
		this.pais = pais;
		this.provincia = provincia;
		this.ciudad = ciudad;
	}

	public Integer getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
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

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Paises getPais() {
		return pais;
	}

	public void setPais(Paises pais) {
		this.pais = pais;
	}

	public Provincias getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincias provincia) {
		this.provincia = provincia;
	}

	public Ciudades getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudades ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Eventos [idEvento=" + idEvento + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", direccion=" + direccion + ", pais="
				+ pais + ", provincia=" + provincia + ", ciudad=" + ciudad + "]";
	}

	
	
	
	
}
