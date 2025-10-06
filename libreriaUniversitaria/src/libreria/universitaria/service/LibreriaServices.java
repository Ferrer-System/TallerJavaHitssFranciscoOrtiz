package libreria.universitaria.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import libreria.universitaria.models.Cliente;
import libreria.universitaria.models.Libro;
import libreria.universitaria.models.Venta;

public class LibreriaServices {

	private List<Libro> libros = new ArrayList<>();
	private List<Cliente> clientes = new ArrayList<>();
	private List<Venta> ventas = new ArrayList<>();

	// Metodos para la gestion de los libros
	public Libro registrarLibro(Supplier<Libro> proveedorLibro) {
		Libro libro = proveedorLibro.get();
		libros.add(libro);
		return libro;
	}

	public List<String> obtenerResumenLibro(Function<Libro, String> transformador) {
		return libros.stream().map(transformador).collect(Collectors.toList());
	}

	public boolean validarLibro(Libro libro, Predicate<Libro> validador) {
		return validador.test(libro);
	}

	public void imprimirLibros(Consumer<Libro> consumer) {
		libros.forEach(consumer);
	}

	// Metodos para la gestion de clientes
	public Cliente registrarCliente(Supplier<Cliente> clienteSupplier) {
		Cliente cliente = clienteSupplier.get();
		clientes.add(cliente);
		return cliente;
	}

	public boolean validarCliente(Cliente cliente, Predicate<Cliente> validador) {
		return validador.test(cliente);
	}

	public void imprimirCliente(Consumer<Cliente> consumer) {
		clientes.forEach(consumer);
	}

	// Gestion de ventas
	public Venta registrarVenta(Cliente cliente, Libro libro) {
		if (cliente == null || libro == null) {
			throw new IllegalArgumentException("Cliente y libro no pueden ser nulos");
		}
		Venta venta = new Venta(cliente, libro, null);
		ventas.add(venta);
		cliente.agregarCompra(venta);
		return venta;
	}

	// Consultas y calculos
	public Optional<Libro> libroMasCaro() {
		return libros.stream().max(Comparator.comparingDouble(Libro::getPrecio));
	}

	public Optional<Libro> libroMasBarato() {
		return libros.stream().min(Comparator.comparingDouble(Libro::getPrecio));
	}

	public double precioPromedio() {
		return libros.stream().mapToDouble(Libro::getPrecio).average().orElse(0.0);
	}

	// Reportes
	public void imprimirVenta(Consumer<Venta> accion) {
		ventas.forEach(accion);
	}

	// Guardar facturas en una carpeta llamada facturas
	public void guardarFacturas(Venta venta) {
		try {
			// Carpeta de facturas
			Path carpeta = Path.of("facturas");
			if (!Files.exists(carpeta)) {
				Files.createDirectories(carpeta);
			}

			// Nombre del archivo = factura-[codigo].txt
			String nombreArchivo = "factura-" + venta.getCodigo() + ".txt";
			Path archivo = carpeta.resolve(nombreArchivo);

			// Contenido de la factura
			String contenido = venta.generarFactura();

			// Escribir el archivo
			Files.writeString(archivo, contenido, StandardOpenOption.CREATE);

			System.out.println("\nFactura guardada en: " + archivo.toAbsolutePath());

		} catch (IOException e) {
			System.out.println("\nError al guardar la factura: " + e.getMessage());
		}
	}
	
	
	//Notificacion al cliente
	public void notificarCliente(Cliente cliente, String mensaje) {
		System.out.println("Notificacion a " + cliente.getNombre() + ": " + mensaje);
	}
	
	// Metodo de acceso para accesibilidad a datos en main
	public List<Libro> getLibros() {
		return libros;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

}
