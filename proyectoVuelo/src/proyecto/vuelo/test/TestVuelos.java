package proyecto.vuelo.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import proyecto.vuelo.clases.Vuelo;

public class TestVuelos {

	public static void main(String[] args) {

		Path archivo = Paths.get("vuelos.txt");

		try {
			List<String> lineas = Files.readAllLines(archivo);
			List<Vuelo> vuelos = new ArrayList<>();

			// Formateador para fechas y horas en español
			DateTimeFormatter formatterFecha = new DateTimeFormatterBuilder().parseCaseInsensitive()
					.appendPattern("dd MMM yyyy").toFormatter(new Locale("es", "ES"));

			DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");

			for (int i = 1; i < lineas.size(); i++) {// saltamos la cabecera
				String linea = lineas.get(i).replaceAll("\t", " ") // quita tabs
						.replaceAll("\\s+", " ")// normaliza espacios multiples
						.trim();

				//salta lineas vacias 
				if (linea.isEmpty())
					continue;

				String[] datos = linea.split(",");
				for (int j = 0; j < datos.length; j++) {
					datos[j] = datos[j].trim();
				}

				String fechaTexto = datos[3];
				// si la decha viene junta, insertar espacio despues de las 3 primeras letras
				if (fechaTexto.length() > 5 && Character.isDigit(fechaTexto.charAt(3))) {
					fechaTexto = fechaTexto.substring(0, 3) + " " + fechaTexto.substring(3);
				}

				// procesar fecha quitar dia de la semana
				if (fechaTexto.split(" ").length == 4) {
					fechaTexto = fechaTexto.substring(fechaTexto.indexOf(" ") + 1);
				}

				// convertir fecha y hora
				LocalDate fecha = LocalDate.parse(fechaTexto, formatterFecha);
				// Procesar Hora
				String horaTexto = datos[4].replace("hrs", "").trim();
				LocalTime hora = LocalTime.parse(horaTexto, formatterHora);

				Vuelo vuelo = new Vuelo(datos[0], datos[1], datos[2], fecha, hora, Integer.parseInt(datos[5]));
				vuelos.add(vuelo);
			}

			// ordenar por llegada ascendente
			vuelos.sort(Comparator.comparing(Vuelo::getFechaLlegada).thenComparing(Vuelo::getHoraLlegada));

			System.out.println("==== Lista llegada de orden ascendente ====");
			vuelos.forEach(System.out::println);

			// ultimo vuelo en llegada
			Vuelo ultimo = Collections.max(vuelos,
					Comparator.comparing(Vuelo::getFechaLlegada).thenComparing(Vuelo::getHoraLlegada));
			System.out.println("\nEl ultimo vuelo en llagar es: " + ultimo.getCodigo() + ": " + ultimo.getOrigen()
					+ " a " + ultimo.getDestino() + ", aterrizo el " + ultimo.getFechaHoraFormateada());

			// vuelo con menor numero de pasajeros
			Vuelo menorPasajeros = Collections.min(vuelos, Comparator.comparing(Vuelo::getNumPasajeros));
			System.out.println("El vuelo con el menor numero de pasajeros es: " + menorPasajeros.getCodigo() + ": "
					+ menorPasajeros.getOrigen() + " a " + menorPasajeros.getDestino() + ", con "
					+ menorPasajeros.getNumPasajeros() + " pasajeros.");

		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());

		}

	}

}
