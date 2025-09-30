package expresiones.lambda.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import expresiones.lambda.models.Cliente;

public class Expresiones {

	public static void main(String[] args) {
		// Sintaxis basica de una expresion lambda
		// (parametros) -> expresion 
		//(parametros) -> { bloque de codigo }
		
		//Ejemplo de una ecpresion lambda cuando no recibe parametros
		//() -> System.out.println("Hola mundo");

		//Parametro con tipo explicito
		//(int x, int y) -> x +y;
		
		//parametro con  tipo inferido (el compilador lo deduce)
		//(x,y) -> x + y;
		
		
		//Una expresion lambda con una sola instruccion (no requiere llaves, ni return)
		//x -> x * x;
		
		//Bloque de codigo con varias intrucciones 
		/*(x, y) -> {
			System.out.println("Sumando:");
			int r = x + y;
			return r;
		}*/
		List<String>nombres = Arrays.asList("Juan", "Eloy", "Anna", "Maria", "Ferrer");
		
		//Forma imperativa
		for (String nombre : nombres) {
			System.out.println(nombre);
		}
		
		//Utilizando la forma declarativa 
		System.out.println("====== Forma declarativa ======");
		nombres.forEach((nombre) -> System.out.println(nombre));
		
		//Declarativa de forma fucional con referencia a metodo
		System.out.println("====== Referencia a metodo ======");
		nombres.forEach(System.out::println);// no se ponen los parentesis en el parametro
		
		List<Cliente>clientes = new ArrayList<>();
		clientes.add(new Cliente("Ferrer", 32));
		clientes.add(new Cliente("Juan", 52));
		clientes.add(new Cliente("Lalo", 22));
		clientes.add(new Cliente("Petra", 29));
		clientes.add(new Cliente("Laura", 33));
		
		System.out.println("======= Listando clientes ========");
		clientes.forEach(System.out::println);
		
		System.out.println("\n======= Listando por nombre ========");
		clientes.forEach(c -> System.out.println(c.getNombre()));
		
		Runnable tarea = () -> System.out.println("Ejecutando tarea");
		new Thread(tarea).start();
		
		
		
		
	}

}
