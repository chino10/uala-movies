package com.phidalgo.uala.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtil {
	private static final String VIEJO = "viejo";
	private static final String MELANCOLICO = "melancolico";

	public static boolean calcularFechaEstreno(Date fechaEstreno, String tipo) {
		long diffInMillies = Math.abs(new Date().getTime() - fechaEstreno.getTime());
		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		float years = diff / 365;
		if(tipo.equals(VIEJO)) {
			if(years > 2f) {
				return true;
			}
		} else if(tipo.equals(MELANCOLICO)) {
			if(years > 10f) {
				return true;
			}
		}

		return false;
	}
}