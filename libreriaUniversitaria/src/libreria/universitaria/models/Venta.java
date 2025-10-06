package libreria.universitaria.models;

import java.time.LocalDate;
import java.util.UUID;

public class Venta {
	private final String codigo;
	private Cliente cliente;
	private Libro libro;
	private LocalDate fecha;

	public Venta(Cliente cliente, Libro libro, LocalDate fecha) {
		this.codigo = UUID.randomUUID().toString();
		this.cliente = cliente;
		this.libro = libro;
		this.fecha = LocalDate.now();
	}

	public String getCodigo() {
		return codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Libro getLibro() {
		return libro;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	// Genera el texto de la factura
	public String generarFactura() {
		return "Factura [" + codigo + "]\n" + "Cliente: " + cliente.getNombre() + "\n" + "Libro: " + libro.getTitulo()
				+ "\n" + "Precio Original: $" + libro.getPrecio() + "\n" + "Precio con descuento: $"
				+ libro.getPrecioConDescuento() + "\n" + "Fecha: " + fecha + "\n";
	}

	@Override
	public String toString() {
		return "Venta " + codigo + " | " + cliente.getNombre() + " -> " + libro.getTitulo() + " [" + fecha + "]";
	}

}
