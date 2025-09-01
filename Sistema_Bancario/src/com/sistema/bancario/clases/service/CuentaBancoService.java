package com.sistema.bancario.clases.service;


import com.sistema.bancario.clases.Cuenta;
import com.sistema.bancario.clases.Transaccion;

public class CuentaBancoService {
	public boolean verificarPassword(Cuenta cuenta, String password, String titular) {
		return cuenta.getPassword().equals(password) && cuenta.getTitular().equals(titular);
	}
	
	public void depositar(Cuenta cuenta, double monto) {
		cuenta.setSaldo(cuenta.getSaldo() + monto);
		Transaccion transaccion = new Transaccion("Deposito", monto, cuenta);
		cuenta.getHistorial().add(transaccion);
		
	}
	
	public void retirar(Cuenta cuenta, double monto) {
		if (monto <= cuenta.getSaldo()) {
			cuenta.setSaldo(cuenta.getSaldo() - monto);
			Transaccion transaccion = new Transaccion("Retiro", monto, cuenta);
			cuenta.getHistorial().add(transaccion);
		}else {
			System.out.println("Fondos insuficientes en la cuenta de " + cuenta.getTitular());
		}
	}
	
	public void mostrarInfo(Cuenta cuenta) {
		System.out.println("\nCuenta ID: " + cuenta.getIdCuenta() +
							" -> Titular: " + cuenta.getTitular() +
							" -> Saldo: $" + cuenta.getSaldo());
	}
	
	public void mostrarHistorial(Cuenta cuenta) {
		System.out.println("\nHistorial de transaccion de " + cuenta.getTitular() + ":");
		for (Transaccion transaccion : cuenta.getHistorial()) {
			transaccion.mostrarInfo();
		}
	}

}








