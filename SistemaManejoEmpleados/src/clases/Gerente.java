package clases;

public class Gerente extends Empleado{
	private double presupuesto;

	//constructor con los parametros necesarios, heredando los parametros de la clase padre Persona
	public Gerente(String nombre, String apellido, String numeroFiscal, String direccion,
			double renumeracion, double presupuesto) {
		super(nombre, apellido, numeroFiscal, direccion, renumeracion);
		this.presupuesto = presupuesto;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	//sobrescitura del metodo toString() con herencia de la super clase "clase padre"
	@Override
	public String toString() {
		return super.toString() + ", Presupuesto: " + presupuesto;
	}
	

}
