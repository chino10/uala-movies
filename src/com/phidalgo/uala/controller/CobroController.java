package com.phidalgo.uala.controller;

import com.phidalgo.uala.modelo.Plan;
import com.phidalgo.uala.modelo.Usuario;
import com.phidalgo.uala.modelo.enums.CanalesComunicacion;

public class CobroController {
	public static Boolean cobrar(Usuario usuario, Plan plan) {
		if(usuario.getCreditoDisponible() >= plan.getMonto()) {
			usuario.setCreditoDisponible(usuario.getCreditoDisponible() - plan.getMonto());
			notificar(usuario, plan.getMonto());

			return Boolean.TRUE;
		}
		System.out.println("\n\n********\nCRÉDITO INSUFICIENTE: " + usuario.getCreditoDisponible());

		return Boolean.FALSE;
	}

	public static void notificar(Usuario usuario, Float monto) {
		String mensaje = "";
		if(!usuario.getCanalesComunicacion().isEmpty()) {
			String canales = "Se notifica por ";
			for(CanalesComunicacion canal : usuario.getCanalesComunicacion()) {
				canales += " - " + canal.name();
			}
			mensaje = canales + "\nEstimado usuario, se debitaron de su cuenta $" + monto 
					+ ", su crédito restante es de $" + usuario.getCreditoDisponible() 
					+ ".\nMuchas gracias.";
		} else {
			mensaje = "El usuario no posee canañes de comunicación activos, NO se notiifca.";
		}
		System.out.println("\n\n********\n" + mensaje);
	}
}