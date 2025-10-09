package sistema.evaluacion.desempenio.model;

public class Evaluacion {

	private int anio;
	private double puntaje;
	
	public Evaluacion(int anio, double puntaje) {
		this.anio = anio;
		this.puntaje = puntaje;
	}

	public int getAnio() {
		return anio;
	}

	public double getPuntaje() {
		return puntaje;
	}

	@Override
	public String toString() {
		return "Añ: " + anio + " Puntaje: " + puntaje;
	}
	
}
