package libreria.universitaria.test;

import libreria.universitaria.models.Cliente;
import libreria.universitaria.models.Libro;
import libreria.universitaria.models.TipoLibro;
import libreria.universitaria.models.Venta;
import libreria.universitaria.service.LibreriaServices;

public class LibrosMain {

	public static void main(String[] args) {

		LibreriaServices service = new LibreriaServices();

		// Registrar libros usando Supplier
		Libro libro = service
				.registrarLibro(() -> new Libro("Java Basico", "Andres Guzman", 2005, 500, TipoLibro.PROGRAMACION));
		Libro libro2 = service.registrarLibro(
				() -> new Libro("Fundamentos de Programacion", "Luis Joyanes", 2020, 991, TipoLibro.PROGRAMACION));
		Libro libro3 = service.registrarLibro(
				() -> new Libro("La diversidad de la ciencia", "Carl Sagan", 2022, 479, TipoLibro.CIENCIA));
		Libro libro4 = service
				.registrarLibro(() -> new Libro("Historia del Cerebro", "Jose Ramon", 2025, 1143, TipoLibro.HISTORIA));
		Libro libro5 = service
				.registrarLibro(() -> new Libro("El libro de Enoc", "Desconocido", 1982, 1143, TipoLibro.OTROS));

		// Registrar clientes usando Supplier
		Cliente cliente = service.registrarCliente(() -> new Cliente("Ferrer Lara", 25));
		Cliente cliente2 = service.registrarCliente(() -> new Cliente("Laura Cortez", 33));
		Cliente cliente3 = service.registrarCliente(() -> new Cliente("Anna Lichi", 27));

		// Validaciones usando Predicate
		System.out.println("¿Libro valido? " + service.validarLibro(libro, l -> l.getAnioPublicacion() > 1900));
		System.out.println("¿Cliente valido? " + service.validarCliente(cliente, c -> c.getEdad() >= 18));

		// Registrar ventas
		Venta v1 = service.registrarVenta(cliente, libro2);
		service.guardarFacturas(v1);
		// Notificacion al cliente de su compra
		service.notificarCliente(cliente, "Gracias por su compra del libro '" + libro2.getTitulo()
				+ "'. Precio Final: $" + libro2.getPrecioConDescuento());

		Venta v2 = service.registrarVenta(cliente2, libro);
		service.guardarFacturas(v2);
		// Notificacion al cliente de su compra
		service.notificarCliente(cliente2, "Gracias por su compra del libro '" + libro.getTitulo()
				+ "'. Precio Final: $" + libro.getPrecioConDescuento());

		// Imprimir entidades
		System.out.println("\nLibros en la libreria:");
		service.imprimirLibros(System.out::println);

		System.out.println("\nClientes registrados:");
		service.imprimirCliente(System.out::println);

		System.out.println("\nVentas realizadas");
		service.imprimirVenta(v -> System.out.println(v.generarFactura()));

		// Resumen del libro
		System.out.println("\nResumen del libro");
		service.obtenerResumenLibro(Libro::resumen).forEach(System.out::println);

		// Calculos solicitados
		service.libroMasCaro().ifPresent(l -> System.out.println("\nLibro más caro: " + l));
		service.libroMasBarato().ifPresent(b -> System.out.println("\nLibro mas barato: " + b));
		System.out.println("El precio promedio de los libros con descuento es: $" + service.precioPromedio());

	}

}
