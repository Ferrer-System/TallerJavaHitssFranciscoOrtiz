package test;

import clases.Empleado;
import clases.Gerente;

public class TestMain {

	public static void main(String[] args) {

		//objeto gerente
		Gerente gerente = new Gerente("Tomas", "Lara", "MXTol12345", "Toluca EdoMéx", 15000, 50000);
		//objeto empleado
		Empleado empleado = new Empleado("Luz", "De Ortiz", "BNX1223", "Reforma CDMX", 15000);
		
		System.out.println("===== Datos del gerente =====");
		System.out.println(gerente);
		
		gerente.aumentarRenumeracion(10);
		gerente.setPresupuesto(75000);
		
		System.out.println("\n====== Despues de los aumentos ======");
		System.out.println(gerente);
		
		System.out.println("\n===== Datos del empleado ======");
		System.out.println(empleado);
	}

}
