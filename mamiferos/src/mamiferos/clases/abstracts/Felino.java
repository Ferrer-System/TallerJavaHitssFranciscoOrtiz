package mamiferos.clases.abstracts;

public abstract class Felino extends Mamifero {

	protected double tamanioGarrar;
	protected int velocidad;

	// constructor con los parametros integrados de la super clase padre
	public Felino(String habitat, double altura, double largo, double peso, String nombreCientifico,
			double tamanioGarrar, int velocidad) {
		super(habitat, altura, largo, peso, nombreCientifico);
		this.tamanioGarrar = tamanioGarrar;
		this.velocidad = velocidad;
	}

	public double getTamanioGarrar() {
		return tamanioGarrar;
	}

	public int getVelocidad() {
		return velocidad;
	}

	@Override
	public String toString() {
		return "Tamaño de las Garrar: " + tamanioGarrar + " cm.";
	}
	
	
	
}
