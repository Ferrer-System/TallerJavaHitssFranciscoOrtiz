package sistema.supermercado.models;

import sistema.supermercado.enums.Descuento;

public class Cliente {

	private static int contador = 0;
	private int id;
	private String nombre;
	private Descuento tipo;
	
	public Cliente(String nombre, Descuento tipo) {
		this.id = ++contador;
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Descuento getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "ID: " + id + " " + nombre + " (" + tipo + ")";
	}
	
	
	
}
