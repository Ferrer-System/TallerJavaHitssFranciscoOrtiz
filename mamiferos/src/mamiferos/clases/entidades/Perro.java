package mamiferos.clases.entidades;

import mamiferos.clases.abstracts.Canino;

public class Perro extends Canino {

	private int fuerzaMordidaPsi;

	public Perro(String habitat, double altura, double largo, double peso, String nombreCientifico, String color,
			double tamanioComillos, int fuerzaMordidaPsi) {
		super(habitat, altura, largo, peso, nombreCientifico, color, tamanioComillos);
		this.fuerzaMordidaPsi = fuerzaMordidaPsi;
	}

	@Override
	public String comer() {
		return "El perro zalvaje Africano caza en grupo para poder eliminar presar mas grandes y poder alimentarse.";
	}

	@Override
	public String dormir() {
		return "El perro zalvaje Africano duerme en madrigueras de " + habitat;
	}

	@Override
	public String correr() {
		return "El perro zalvaje persigue sus presar a largas distancias.";
	}

	@Override
	public String comunicarse() {
		return "El perro zalvaje emite chillidos y ladridos para poderse counicar con su manada.";
	}

	@Override
	public String toString() {
		return super.toString() + "\nFuerza de Mordida: " + fuerzaMordidaPsi + " Psi";
	}

	
}
