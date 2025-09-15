package facturacion.entidades;

public class Estudiante {

	private Integer id;
	private String nombre;
	private double calificacion;
	public Estudiante(Integer id, String nombre, double calificacion) {
		this.id = id;
		this.nombre = nombre;
		this.calificacion = calificacion;
	}
	public Integer getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public double getCalificacion() {
		return calificacion;
	}
	@Override
	public String toString() {
		return "Estudiante {id: " + id + ", nombre: " + nombre + ", calificacion: " + calificacion + "}";
	}
		
		
}
