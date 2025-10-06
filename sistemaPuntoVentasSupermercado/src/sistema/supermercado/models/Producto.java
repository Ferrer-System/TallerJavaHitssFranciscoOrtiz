package sistema.supermercado.models;

import sistema.supermercado.enums.TipoProducto;

public class Producto {

	private static int contador = 0;
	private int id;
	private String nombre;
	private double precio;
	private int stock;
	private TipoProducto tipo;

	public Producto(String nombre, double precio, int stock, TipoProducto tipo) {
		this.id = ++contador;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public int getStock() {
		return stock;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public TipoProducto getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "\nID: " + id + " " + nombre + " ($" + precio + ") Stock: " + stock + " Tipo de producto: " + tipo;
	}

}
