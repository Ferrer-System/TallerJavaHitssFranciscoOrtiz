package sistema.supermercado.models;

import sistema.supermercado.enums.TipoEmpleado;

public class Empleado {
	
	private static int contador = 0;
	private int id;
	private String nombre;
	private TipoEmpleado puesto;
	
	public Empleado(String nombre, TipoEmpleado puesto) {
		this.id = ++contador;
		this.nombre = nombre;
		this.puesto = puesto;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public TipoEmpleado getPuesto() {
		return puesto;
	}

	@Override
	public String toString() {
		return "ID: " + id + " " + nombre + " - " + puesto;
	}
	
	
	
	
	
}
