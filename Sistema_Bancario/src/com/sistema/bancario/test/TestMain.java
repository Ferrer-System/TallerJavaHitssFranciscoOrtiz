package com.sistema.bancario.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sistema.bancario.clases.Cuenta;
import com.sistema.bancario.clases.service.CuentaBancoService;

public class TestMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		CuentaBancoService cuentaBancoService = new CuentaBancoService();
		
		List<Cuenta> cuentas = new ArrayList<>();
		
		Cuenta cuenta1 = new Cuenta("Ana", "1234", 5000);
		Cuenta cuenta2 = new Cuenta("Luis", "12345", 10000);
		cuentas.add(cuenta1);
		cuentas.add(cuenta2);
		
		Cuenta cuenta = null;
		boolean acceso = false;
		
		System.out.println("===== BIENVENIDO BANCO =====");
		System.out.println("1. Registrar nuevo usuario");
		System.out.println("2. Iniciar sesion");
		System.out.println("3. Usar cuentas predeterminadas");
		System.out.print("Seleccionar una opcion: ");
		int opcionInicio = scanner.nextInt();
		scanner.nextLine();
		
		switch (opcionInicio) {
		case 1 -> {
			System.out.println("Ingrese nombre del titular: ");
			String titular = scanner.nextLine();
			
			System.out.println("Ingrese contraseña: ");
			String password = scanner.nextLine();
			
			System.out.println("Ingrese deposito inicial: ");
			double depositoInicial = scanner.nextDouble();
			scanner.nextLine();
			cuenta = new Cuenta(titular, password, depositoInicial);
			cuentas.add(cuenta);
			System.out.println("Cuenta creada exitosamente");
					
		}
		case 2 -> {
			
			System.out.println("Ingrese nombre de usuario: ");
			String usurioTitular = scanner.nextLine();
			
			System.out.println("Ingrese contraseña: ");
			String passwordEnter = scanner.nextLine();
			
			
			for (Cuenta c : cuentas) {
				if (cuentaBancoService.verificarPassword(c, passwordEnter, usurioTitular)) {
					cuenta = c; 
					acceso = true;
					System.out.println("Acceso correcto\n");
					break;
				}
			}
			if (!acceso) {
				System.out.println("Usuario o contraseña incorrecta");
				return;
			}
		}
		case 3 -> {
			cuenta = cuenta1;
			System.out.println("Acceso con cuenta predeterminada (Ana)");
		}
		
		default ->{
		System.out.println("Opcion invalida");
		return;
			}
		
		}
		
		int opcion;
		do {
			System.out.println("\n===== MENU BANCO =====");
			System.out.println("1. Depositar");
			System.out.println("2. Retitar");
			System.out.println("3. Mostrar informacion de la cuenta");
			System.out.println("4. Mostrar historial de transacciones");
			System.out.println("0. Salir");
			System.out.print("Elija una opcion: ");
			opcion = scanner.nextInt();
			scanner.nextLine();
			
		switch (opcion) {
			case 1 -> {
				System.out.print("Ingrese monto a depositar: ");
				double montoDeposito = scanner.nextDouble();
				scanner.nextLine();
				cuentaBancoService.depositar(cuenta, montoDeposito);
			}
			case 2 -> {
				System.out.print("Ingrese contraseña para retirar: ");
				String passwordRetiro = scanner.nextLine();
				
				if (cuentaBancoService.verificarPassword(cuenta, passwordRetiro, cuenta.getTitular())) {
					System.out.println("Ingresa monto a retirar: ");
					double montoRetiro = scanner.nextDouble();
					scanner.nextLine();
					cuentaBancoService.retirar(cuenta, montoRetiro);
				}else {
					System.out.println("Constraseña o usuario incorrecta. retiro cancelado. ");
				}
			}
			case 3 -> cuentaBancoService.mostrarInfo(cuenta);
			case 4 -> cuentaBancoService.mostrarHistorial(cuenta);
			case 0 ->  System.out.println("Salir del sistema");
			default -> System.out.println("Opcion invalida");
		}
		
	} while (opcion != 0);
		scanner.close();
		
	}

}






