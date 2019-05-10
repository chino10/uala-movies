package com.phidalgo.uala.util;

import java.util.List;

import com.phidalgo.uala.modelo.Producto;

public class StringUtil {
	public static void mostrarPorConsola(String titulo, List<Producto> listaProductos) {
		System.out.println("\n\n********\n" + titulo);
		for(Producto producto : listaProductos) {
			System.out.println(producto.toString());
		}
	}
}