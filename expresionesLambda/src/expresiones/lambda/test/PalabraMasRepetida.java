package expresiones.lambda.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import expresiones.lambda.interfacez.Transformador;

public class PalabraMasRepetida {

	public static void main(String[] args) {
		// Expresion lambda con los requisitos necesarios
		Transformador<String, Map<String, Integer>> palabrasRepetidas = frase -> {
			
			//Normalizar la frase a minusculas
			String fraseLimpia = frase.toLowerCase().replaceAll("[^a-z0-9áéíóú ]", "");
			
			// dividir la frase en palabras (ignorar mayusculas y minusculas)
			Map<String, Long> contador = Arrays.stream(fraseLimpia.split("\\s+"))
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

			// encontrar la palabra mas repetida
			Map.Entry<String, Long> maxE = contador.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);

			// devuelve un map con las palabras mas repetidas y su frecuancia
			Map<String, Integer> resultado = new HashMap<>();
			if (maxE != null) {
				resultado.put(maxE.getKey(),maxE.getValue().intValue());
			}

			return resultado;
		};

		String frase = "Hola mundo, hola java, java 8, hola a todos, hola hola, java , Java, JAVA, java, JaVA, hola";
		Map<String, Integer> resultado = palabrasRepetidas.transformar(frase);

		// mostrar el sesultado
		System.out.println("Resultado 'palabra más repetida':  " + resultado);
		

	}

}
