package com.sistema.bancario.clases;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {
	
	private static int contadorCuentas;
	private int idCuenta;
	private String titular;
	private String password;
	private double saldo;
	
	private List<Transaccion> historial;

	public Cuenta(String titular, String password , double depositoInicial) {
		this.idCuenta = ++contadorCuentas;
		this.titular = titular;
		this.password = password;
		this.saldo = depositoInicial;
		this.historial = new ArrayList<>();
	}

	public int getIdCuenta() {
		return idCuenta;
	}

	public String getTitular() {
		return titular;
	}

	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Transaccion> getHistorial() {
		return historial;
	}

	
	
	

	
	
}




