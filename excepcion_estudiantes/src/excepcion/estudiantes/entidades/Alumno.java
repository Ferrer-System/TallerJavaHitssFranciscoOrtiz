package excepcion.estudiantes.entidades;

public class Alumno {

	private int id;
	private String nombre;
	private String grado;
	private int edad;
	static int contadorId;
	
	public Alumno(String nombre, String grado, int edad) {
		this.nombre = nombre;
		this.grado = grado;
		this.edad = edad;
		this.id = ++contadorId;
	}

	public int getEdad() {
		return edad;
	}

	@Override
	public String toString() {
		return "Alumno |ID: " + id + "| Nombre: " + nombre + "| Grado: " + grado + "| Edad: " + edad + "|";
	}
	
	
	
	
}
