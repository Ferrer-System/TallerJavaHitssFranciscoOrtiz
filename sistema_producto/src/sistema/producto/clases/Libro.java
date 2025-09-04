package sistema.producto.clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import sistema.producto.abstracts.Producto;
import sistema.producto.interfaces.ILibro;

//clase entidad 
//extiende de Producto e implementa ILibro
public class Libro extends Producto implements ILibro {

	private LocalDate fechaPublicacion;
	private String autor;
	private String titulo;
	private String editorial;

	//constructor que implementa eñ constructor de la clase Producto
	public Libro(String autor, String titulo, String editorial, double precio, String fechaPublicacion) {
		super(precio);
		this.autor = autor;
		this.titulo = titulo;
		this.editorial = editorial;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //formato de la fecha 
		this.fechaPublicacion = LocalDate.parse(fechaPublicacion, formatter);
	}

	@Override
	public double getPrecioVenta() {
		return precio * 1.16; // más iva
	}
	
	//devuelve precio de venta casteado para que solo se muestren 2 decimales
	public String getPrecioVentaformateado() {
		return String.format("%.2f", getPrecioVenta());
	}

	@Override
	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}

	@Override
	public String getAutor() {
		return autor;
	}

	@Override
	public String getTitulo() {
		return titulo;
	}

	@Override
	public String getEditorial() {
		return editorial;
	}

	@Override
	public String toString() {
		return "Libro: " + "| Titulo: " + titulo + "| Autor: " + autor + "| Editorial: " + editorial
				+ "| Fecha de publicacion: " + fechaPublicacion.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+ "| Precio del producto: " + getPrecioVentaformateado() + "| ";
	}

}
