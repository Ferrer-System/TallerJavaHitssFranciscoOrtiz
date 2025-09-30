package expresiones.lambda.test;

import expresiones.lambda.interfacez.Operacion;
import expresiones.lambda.interfacez.Transformador;

public class PruebaInterfazFunsional {
	public static void main(String[] args) {
		
		//Implemetar con lambda
		Operacion suma = (a, b) -> a + b;
		System.out.println("Suma: " + suma.calcular(5, 8));
		
		Operacion resta = (a, b) -> a - b;
		System.out.println("Resta: " + resta.calcular(16, 8));
		
		//Lambda que trasnforma String a mayusculas <String>
		
		Transformador<String, String> aMayusculas = s -> s.toUpperCase();
		System.out.println("Mayusculas en una cadena: " + aMayusculas.transformar("laura cortez"));
		
		Transformador<String, String> limpiar = f -> f.replaceAll("[ ,.]", "").toUpperCase();
		String ori = "Hola, todos estan listos para PARA ,empezAr";
		String convertir = limpiar.transformar(ori); 
		System.out.println("\nFrase original: " + ori);
		System.out.println("Frase transformada: " + convertir);
	}

}
