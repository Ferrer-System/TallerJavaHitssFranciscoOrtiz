package sistema.evaluacion.desempenio.model;

import java.util.List;

public class Empleado {
	private static int contador = 0;
	private int id;
	private String nombre;
	private String departamento;
	private double salario;
	private int experiencia;
	private List<Evaluacion> evaluacions;
	
	public Empleado(String nombre, String departamento, double salario, int experiencia,
			List<Evaluacion> evaluacions) {
		this.id = ++contador;
		this.nombre = nombre;
		this.departamento = departamento;
		this.salario = salario;
		this.experiencia = experiencia;
		this.evaluacions = evaluacions;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public double getSalario() {
		return salario;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public List<Evaluacion> getEvaluacions() {
		return evaluacions;
	}

	@Override
	public String toString() {
		return nombre + " (" + departamento + ") - $" + salario
				+ " - Experiencia: " + experiencia + " años";
	}
	
	

}
