package clases;

public class Empleado extends Persona{
	
	private int empleadoId;
	private double renumeracion;
	private static int numeracioId;
	
	//constructor con los parametros necesarios y asignar id's heredando los parametros de la clase padre Persona
	public Empleado(String nombre, String apellido, String numeroFiscal, String direccion,
			double renumeracion) {
		super(nombre, apellido, numeroFiscal, direccion);
		this.empleadoId = ++numeracioId;
		this.renumeracion = renumeracion;
	}

	//getters 
	public int getEmpleadoId() {
		return empleadoId;
	}

	public double getRenumeracion() {
		return renumeracion;
	}
	
	//metodo para aumentar la renumeracion 
	public void aumentarRenumeracion(int porsentaje) {
		this.renumeracion += this.renumeracion * porsentaje / 100;//asignar this.renumeracion del constructor multiplicar al porsentaje / 100
	}

	//sobrescitura del metodo toString() con herencia de la super clase "clase padre" 
	@Override
	public String toString() {
		return super.toString() + ", EmpleadoId: " + empleadoId + 
				", Renumeracion: " + renumeracion;
	}
	

}
