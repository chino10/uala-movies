package com.phidalgo.uala.modelo;

public class Plan {
	private Float monto;

	public Plan() {
	}

	public Plan(Float monto) {
		this.monto = monto;
	}

	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "Plan [monto=" + monto + "]";
	}
}