package clases;

public class Cliente extends Persona{
	private int clienteId;
	private static int numeroId;

	//constructor con los parametros necesarios y asignar id's heredando los parametros de la clase padre Persona
	public Cliente(String nombre, String apellido, String numeroFiscal, String direccion) {
		super(nombre, apellido, numeroFiscal, direccion);
		this.clienteId = ++numeroId;
	}

	public int getClienteId() {
		return clienteId;
	}

	//sobrescitura del metodo toString() con herencia de la super clase "clase padre"
	@Override
	public String toString() {
		return super.toString() + ", ClienteId: " + clienteId;
	}
	
	

}
