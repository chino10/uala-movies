package com.phidalgo.uala.controller;

import java.util.ArrayList;
import java.util.List;

import com.phidalgo.uala.modelo.Producto;
import com.phidalgo.uala.modelo.Usuario;
import com.phidalgo.uala.modelo.enums.EstadoAnimo;
import com.phidalgo.uala.modelo.enums.TipoProducto;
import com.phidalgo.uala.util.DateUtil;

public class RecomendacionController {
	private static TipoProducto PELICULA = TipoProducto.PELICULA;

	public static List<Producto> recomendar(Usuario usuario, List<Producto> listaProductos) {
		List<Producto> listaARecomendar = new ArrayList<Producto>();
		for(Producto producto : listaProductos) {
			if(!verificarSiContiene(usuario.getProductosList(), producto) && usuario.getEstadoAnimo().equals(EstadoAnimo.TRISTE)) {
				if(recomendarTriste(producto)) {
					listaARecomendar.add(producto);
				}
			}
			if(!verificarSiContiene(usuario.getProductosList(), producto) && usuario.getEstadoAnimo().equals(EstadoAnimo.MELANCOLICO)) {
				if(recomendarMelancolico(producto)) {
					listaARecomendar.add(producto);
				}
			}
			if(!verificarSiContiene(usuario.getProductosList(), producto) && usuario.getEstadoAnimo().equals(EstadoAnimo.CONTENTO)) {
				listaARecomendar.add(producto);
			}
		}

		return listaARecomendar;
	}

	private static Boolean recomendarTriste(Producto producto) {
		if(producto.getTipoProducto().equals(PELICULA)) {
			if(producto.getDuracionMinutos() > 120) {
				return Boolean.TRUE;
			}
		}

		return Boolean.FALSE;
	}

	private static Boolean recomendarMelancolico(Producto producto) {
		if(producto.getTipoProducto().equals(PELICULA)) {
			if(DateUtil.calcularFechaEstreno(producto.getFechaEstreno(), "melancolico")) {
				return Boolean.TRUE;
			}
		}

		return Boolean.FALSE;
	}

	private static Boolean verificarSiContiene(List<Producto> listaProductosUsuario, Producto productoARecomendar) {
		for(Producto productoUsuario : listaProductosUsuario) {
			if(productoUsuario.getId().equals(productoARecomendar.getId())) {
				return true;
			}
		}

		return false;
	}
}