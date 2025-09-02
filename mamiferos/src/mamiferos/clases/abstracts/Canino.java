package mamiferos.clases.abstracts;

public abstract class Canino extends Mamifero {

	protected String color;
	protected double tamanioComillos;

	public Canino(String habitat, double altura, double largo, double peso, String nombreCientifico, String color,
			double tamanioComillos) {
		super(habitat, altura, largo, peso, nombreCientifico);
		this.color = color;
		this.tamanioComillos = tamanioComillos;
	}

	public String getColor() {
		return color;
	}

	public double getTamanioComillos() {
		return tamanioComillos;
	}

	@Override
	public String toString() {
		return "Color: " + color + 
				"\nTamaño de Comillos: " + tamanioComillos + " cm.";
	}
	

}
