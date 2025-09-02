package mamiferos.clases.entidades;

import mamiferos.clases.abstracts.Canino;

public class Lobo extends Canino {

	private int numCamada;
	private String especieLobo;

	public Lobo(String habitat, double altura, double largo, double peso, String nombreCientifico, String color,
			double tamanioComillos, int numCamada, String especieLobo) {
		super(habitat, altura, largo, peso, nombreCientifico, color, tamanioComillos);
		this.numCamada = numCamada;
		this.especieLobo = especieLobo;
	}

	@Override
	public String comer() {
		return "El lobo " + especieLobo + " caza en manada de " + numCamada + " individuos.";
	}

	@Override
	public String dormir() {
		return "EL lobo " + especieLobo + " duerme en las cavernas de " + habitat;
	}

	@Override
	public String correr() {
		return "El lobo corre para cazar por " + habitat;
	}

	@Override
	public String comunicarse() {
		return "El lobo aulla para comunicarse con su manada";
	}

	@Override
	public String toString() {
		
		return super.toString() + "\nNumero de Camada: " + numCamada + " integrantes."+ 
				"\nEspecie de Lobo: " + especieLobo;
	}

	
	
}
