package com.sistema.bancario.clases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaccion {
	private static int contadorTransaccion;
	private int idTransaccion;
	private String tipo;
	private double monto;
	private Cuenta cuentaAsociada;
	private LocalDateTime fecha;
	
	public Transaccion(String tipo, double monto, Cuenta cuentaAsociada) {
		this.idTransaccion = ++contadorTransaccion;
		this.tipo = tipo;
		this.monto = monto;
		this.cuentaAsociada = cuentaAsociada;
		this.fecha = LocalDateTime.now();
	}
	
	public void mostrarInfo() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String fechaFormato = fecha.format(formato);
		
		System.out.println("Transaccion ID: " + idTransaccion + 
				" {tipo: " + tipo + 
				", monto: " + monto + 
				", cuentaAsociada: " + cuentaAsociada.getIdCuenta() + 
				", fecha: " + fechaFormato + "}");
	}


}




