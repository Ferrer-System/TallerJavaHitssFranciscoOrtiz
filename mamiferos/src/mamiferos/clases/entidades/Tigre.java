package mamiferos.clases.entidades;

import mamiferos.clases.abstracts.Felino;

public class Tigre extends Felino {

	private String especieTigre;

	public Tigre(String habitat, double altura, double largo, double peso, String nombreCientifico,
			double tamanioGarrar, int velocidad, String especieTigre) {
		super(habitat, altura, largo, peso, nombreCientifico, tamanioGarrar, velocidad);
		this.especieTigre = especieTigre;
	}

	@Override
	public String comer() {
		return "El tigre " + especieTigre + " caza de manera solitaria en " + habitat;
	}

	@Override
	public String dormir() {
		return "El tigre duerme bajo la sombra en " + habitat;
	}

	@Override
	public String correr() {
		return "El tigre corre hasta  " + velocidad + "Km/h.";
	}

	@Override
	public String comunicarse() {
		return "El tigre ruge para marcar territorio en " + habitat;
	}

	@Override
	public String toString() {
		
		return super.toString() + "\nEspecie de Tigre: " + especieTigre;
	}
	

}
