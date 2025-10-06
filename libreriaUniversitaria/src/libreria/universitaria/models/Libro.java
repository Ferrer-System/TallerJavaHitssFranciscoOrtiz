package libreria.universitaria.models;

import java.util.UUID;

public class Libro {
	private final String id;
	private String titulo;
	private String autor;
	private int anioPublicacion;
	private double precio;
	private TipoLibro tipo;
	
	public Libro(String titulo, String autor, int anioPublicacion, double precio, TipoLibro tipo) {
		if (anioPublicacion < 1900) {
			throw new IllegalArgumentException("El año de publicacion debe de ser posterior al año 1900");
		}if (precio <= 0) {
			throw new IllegalArgumentException("El precio del producto debe de ser positivo");
		}
		this.id = UUID.randomUUID().toString();
		this.titulo = titulo;
		this.autor = autor;
		this.anioPublicacion = anioPublicacion;
		this.precio = precio;
		this.tipo = tipo;
	}

	public String getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public int getAnioPublicacion() {
		return anioPublicacion;
	}

	public double getPrecio() {
		return precio;
	}

	public TipoLibro getTipo() {
		return tipo;
	}
	
	//Devuelve el precio aplicando el descuento segun el tipo de libro.
	public double getPrecioConDescuento() {
		return precio - (precio * tipo.getDescuento());
	}
	
	// Convierte el libro a un resumen
	public String  resumen() {
		return titulo + " (" + anioPublicacion + ") de " + autor + 
				" - Tipo: " + tipo + " - Precio: $" + precio;
	}

	@Override
	public String toString() {
		return resumen();
	}
	
	
	

}
