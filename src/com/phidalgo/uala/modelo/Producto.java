package com.phidalgo.uala.modelo;

import java.util.Date;

import com.phidalgo.uala.modelo.enums.TipoProducto;

public class Producto {
	private Long id;
	private String nombre;
	private Date fechaEstreno;
	private TipoProducto tipoProducto;
	private Integer oscars;
	public Integer duracionMinutos;
	public Integer temporadas;

	public Producto() {
	}

	public Producto(Long id, String nombre, Date fechaEstreno, TipoProducto tipoProducto, Integer oscars, Integer duracionMinutos, Integer temporadas) {
		this.id = id;
		this.nombre = nombre;
		this.fechaEstreno = fechaEstreno;
		this.tipoProducto = tipoProducto;
		this.oscars = oscars;
		this.duracionMinutos = duracionMinutos;
		this.temporadas = temporadas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public Integer getOscars() {
		return oscars;
	}

	public void setOscars(Integer oscars) {
		this.oscars = oscars;
	}

	public Integer getDuracionMinutos() {
		return duracionMinutos;
	}

	public void setDuracionMinutos(Integer duracionMinutos) {
		this.duracionMinutos = duracionMinutos;
	}

	public Integer getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(Integer temporadas) {
		this.temporadas = temporadas;
	}

	public Boolean esInteresante() {
		if(this.tipoProducto.equals(TipoProducto.PELICULA)) {
			if(this.oscars > 0) {
				return Boolean.TRUE;
			}
		} else if(this.tipoProducto.equals(TipoProducto.SERIE)) {
			if(this.temporadas == 4 || this.temporadas == 5) {
				return Boolean.TRUE;
			}
		} else if(this.tipoProducto.equals(TipoProducto.DOCUMENTAL)) {
			if(this.nombre.toLowerCase().contains("unofficial")) {
				return Boolean.TRUE;
			}
		}

		return Boolean.FALSE;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", fechaEstreno=" + fechaEstreno + ", tipoProducto=" + tipoProducto + ", oscars=" + oscars + ", duracionMinutos=" + duracionMinutos
				+ ", temporadas=" + temporadas + "]";
	}
}
