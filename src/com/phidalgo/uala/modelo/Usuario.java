package com.phidalgo.uala.modelo;

import java.util.ArrayList;

import com.phidalgo.uala.modelo.enums.CanalesComunicacion;
import com.phidalgo.uala.modelo.enums.EstadoAnimo;
import com.phidalgo.uala.util.DateUtil;

public class Usuario {
	private EstadoAnimo estadoAnimo;
	private ArrayList<CanalesComunicacion> canalesComunicacion;
	private ArrayList<Producto> productosList;
	private Boolean isAntiguo;
	private Float creditoDisponible;

	public Usuario() {
	}

	public Usuario(EstadoAnimo estadoAnimo, ArrayList<CanalesComunicacion> canalesComunicacion, ArrayList<Producto> productosList, Boolean isAntiguo, Float creditoDisponible) {
		super();
		this.estadoAnimo = estadoAnimo;
		this.canalesComunicacion = canalesComunicacion;
		this.productosList = productosList;
		this.isAntiguo = isAntiguo;
		this.creditoDisponible = creditoDisponible;
	}

	public EstadoAnimo getEstadoAnimo() {
		return estadoAnimo;
	}

	public void setEstadoAnimo(EstadoAnimo estadoAnimo) {
		this.estadoAnimo = estadoAnimo;
	}

	public ArrayList<CanalesComunicacion> getCanalesComunicacion() {
		return canalesComunicacion;
	}

	public void setCanalesComunicacion(ArrayList<CanalesComunicacion> canalesComunicacion) {
		this.canalesComunicacion = canalesComunicacion;
	}

	public ArrayList<Producto> getProductosList() {
		return productosList;
	}

	public void setProductosList(ArrayList<Producto> productosList) {
		this.productosList = productosList;
	}

	public Boolean getIsAntiguo() {
		return isAntiguo;
	}

	public void setIsAntiguo(Boolean isAntiguo) {
		this.isAntiguo = isAntiguo;
	}

	public Float getCreditoDisponible() {
		return creditoDisponible;
	}

	public void setCreditoDisponible(Float creditoDisponible) {
		this.creditoDisponible = creditoDisponible;
	}

	public Boolean esAntiguo() {
		for(Producto producto : this.getProductosList()) {
			if(DateUtil.calcularFechaEstreno(producto.getFechaEstreno(), "viejo")) {
				return Boolean.TRUE;
			}
		}

		return Boolean.FALSE;
	}

	/*
	 * AL MENOS UN PRODUCTO ES INTERESANTE.
	 */
	public Boolean miraInteresante() {
		for(Producto producto : this.getProductosList()) {
			if(producto.esInteresante()) {
				return Boolean.TRUE;
			}
		}

		return Boolean.FALSE;
	}

	@Override
	public String toString() {
		return "Usuario [estadoAnimo=" + estadoAnimo + ", canalesComunicacion=" + canalesComunicacion + ", productosList=" + productosList + ", isAntiguo=" + isAntiguo + ", creditoDisponible="
				+ creditoDisponible + "]";
	}
}