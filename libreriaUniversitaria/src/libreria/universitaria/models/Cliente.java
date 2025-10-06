package libreria.universitaria.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cliente {
	private final String id;
	private String nombre;
	private int edad;
	private List<Venta> historialCompras;
	
	public Cliente(String nombre, int edad) {
		if (edad < 18) {
			throw new IllegalArgumentException("El cliente debe ser mayor de edad");
		}
		this.id = UUID.randomUUID().toString();
		this.nombre = nombre;
		this.edad = edad;
		this.historialCompras = new ArrayList<>();
	}
	
	public String getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}
	public List<Venta> getHistorialCompras() {
		return historialCompras;
	}
	
	public void agregarCompra(Venta venta) {
		historialCompras.add(venta);
	}

	@Override
	public String toString() {
		return nombre + " Edad: " + edad + "";
	}

}
