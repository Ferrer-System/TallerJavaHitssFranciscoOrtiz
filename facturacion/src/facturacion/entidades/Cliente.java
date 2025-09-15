package facturacion.entidades;

import facturacion.interfaces.Identificable;

public class Cliente implements Identificable<String>{

	private String id;
	private String nombre;
	
	public Cliente(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	@Override
	public String getId() {	
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "Cliente {id: " + id + ", nombre: " + nombre + "}";
	}

	
	
}
