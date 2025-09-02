package mamiferos.clases.entidades;

import mamiferos.clases.abstracts.Felino;

public class Guepardo extends Felino {

	public Guepardo(String habitat, double altura, double largo, double peso, String nombreCientifico,
			double tamanioGarrar, int velocidad) {
		super(habitat, altura, largo, peso, nombreCientifico, tamanioGarrar, velocidad);
	}

	@Override
	public String comer() {
		return "El guepardo caza gacelas para poder sobrevivir en " + habitat;
	}

	@Override
	public String dormir() {
		return "El guepardo duerme en las llanuras de su habitat";
	}

	@Override
	public String correr() {
		return "El guepardo es el mas rapido, llega a alcanzar hasta " + velocidad + " km/h.";
	}

	@Override
	public String comunicarse() {
		return "El guepardo emite un sonido parecido a un ronroneo de un gatito";
	}

	@Override
	public String toString() {
		return super.toString() +  "\nTamaño de las Garras: " + tamanioGarrar;
	}

	
	
	

}
