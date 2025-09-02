package mamiuferos.clases.main;

import mamiferos.clases.abstracts.Mamifero;
import mamiferos.clases.entidades.Guepardo;
import mamiferos.clases.entidades.Leon;
import mamiferos.clases.entidades.Lobo;
import mamiferos.clases.entidades.Perro;
import mamiferos.clases.entidades.Tigre;

public class MamiferosMain {

	public static void main(String[] args) {

		Mamifero[] mamiferos = new Mamifero[5];

		Mamifero leon = new Leon("Sabana Africana", 1.2, 2.5, 190, "Pantera leo", 7.5, 80, 15, 114);
		Mamifero tigre = new Tigre("Selva India", 1.1, 2.2, 75, "Pantera tigris", 5.5, 65, "Bengala");
		Mamifero guepardo = new Guepardo("Llanuras Africanas", 0.9, 1.5, 75, "Acinonyx jubatus", 5.5, 120);
		Mamifero lobo = new Lobo("Bosques", 0.8, 1.3, 50, "Canis Lupus", "Gris", 6.0, 8, "Artico");
		Mamifero perro = new Perro("Sabana Africana", 0.75, 1.0, 35, "Lycaon pictus", "Moteado", 4.0, 370);

		mamiferos[0] = leon;
		mamiferos[1] = tigre;
		mamiferos[2] = guepardo;
		mamiferos[3] = lobo;
		mamiferos[4] = perro;

		// mostrar informacion mediante un forEach para iterar la lista de los mamiferos
		// (win + .) para flechita
		for (Mamifero m : mamiferos) {
			System.out.println("\nNombre Cientifico: " + m.getNombreCientifico() + " | Habitat: " + m.getHabitat() + "|");
			System.out.println(m + "\n");
			System.out.println(" → " + m.comer());
			System.out.println(" → " + m.dormir());
			System.out.println(" → " + m.correr());
			System.out.println(" → " + m.comunicarse());

		}

	}

}
