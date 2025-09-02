package mamiferos.clases.abstracts;

public abstract class Mamifero {
	// Atributos comunes (super clase, Clase padre)
	protected String habitat;
	protected double altura;
	protected double largo;
	protected double peso;
	protected String nombreCientifico;

	public Mamifero(String habitat, double altura, double largo, double peso, String nombreCientifico) {
		this.habitat = habitat;
		this.altura = altura;
		this.largo = largo;
		this.peso = peso;
		this.nombreCientifico = nombreCientifico;
	}

	public String getHabitat() {
		return habitat;
	}

	public double getAltura() {
		return altura;
	}

	public double getLargo() {
		return largo;
	}

	public double getPeso() {
		return peso;
	}

	public String getNombreCientifico() {
		return nombreCientifico;
	}

	// conjunto de metodos abstractos (cada clase o cada animal los implemetara a su
	// manera)
	public abstract String comer();

	public abstract String dormir();

	public abstract String correr();

	public abstract String comunicarse();

	@Override
	public String toString() {
		return "Nombre Cientifico: " + nombreCientifico + 
				"\nHabitat: " + habitat + 
				"\nAltura: " + altura + 
				"\nLargo: " + largo + 
				"\nPeso: " + peso
				;
	}
	
	

}
