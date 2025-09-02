package mamiferos.clases.entidades;

import mamiferos.clases.abstracts.Felino;

public class Leon extends Felino {

	private int numManada;
	private double potenciadorRugidoDecibel;

	// constructor que hereda los atribustos de la super clase abstracta Felino que
	// al mismo tiempo
	// hereda de la super clase abstracta mamifero
	public Leon(String habitat, double altura, double largo, double peso, String nombreCientifico, double tamanioGarrar,
			int velocidad, int numManada, double potenciadorRugidoDecimal) {
		super(habitat, altura, largo, peso, nombreCientifico, tamanioGarrar, velocidad);
		this.numManada = numManada;
		this.potenciadorRugidoDecibel = potenciadorRugidoDecimal;
	}

	@Override
	public String comer() {
		return "El leon casa junto a su grupo de " + numManada + " individuos en " + habitat;
	}

	@Override
	public String dormir() {
		return "El leon duerme en la sabana africaba.";
	}

	@Override
	public String correr() {
		return "El leon corre a " + velocidad + " km/h para atrapar a sus presas.";
	}

	@Override
	public String comunicarse() {
		return "El leon emite rugidos para marcar territorio y emite gruñidos y buffs para comunicarse dentro de la manada";
	}

	@Override
	public String toString() {
		return super.toString() + "\nNumero de Manada " + numManada + " integrantes" +
				"\nPotenciador de Rugido: " + potenciadorRugidoDecibel + " dB's";
	}
	

}
