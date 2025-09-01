package clases;

import java.lang.reflect.Constructor;

public class Persona {
	private String nombre;
	private String apellido;
	private String numeroFiscal;
	private String direccion;
	
	// constructor con los param,etros necesarios y la creacion automatica de los Ids
	public Persona(String nombre, String apellido, String numeroFiscal, String direccion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.numeroFiscal = numeroFiscal;
		this.direccion = direccion;
	}

	//getters nombre, apellido,numeroFiscal y direccion
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getNumeroFiscal() {
		return numeroFiscal;
	}

	public String getDireccion() {
		return direccion;
	}

	//metodo toString() para mostrar la informacion 
	@Override
	public String toString() {
		return "Nombre: " + nombre + 
				"| Apellido: " + apellido + 
				"| Numero Fiscal: " + numeroFiscal +
				"| Direccion: " + direccion + 
				"| "; 
	}
	
	
	

}
