package proyecto.deportes.entidad;

import java.util.Objects;

/*Clase que representa a un jugador de una disciplina
 * Implementa Comparable para poder ordenarlo alfabeticamente por nombre 
 * */
public class Jugador implements Comparable<Jugador> {

	private int id;
	private String nombre;

	public Jugador(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	//hasCode -> se basa en id y nombre, usado por estructuras Set para evitar duplicados 
	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}

	//equals -> define cuando dos jugadores son considerados iguales
	//en este caso. si tiene el mismp id o el mismo nombre
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true; //Sí es el mismo objeto 
		if (!(obj instanceof Jugador))
			return false; //Sí no es jugador
		Jugador other = (Jugador) obj;
		return id == other.id || Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Jugador |Id: " + id + ", Nombre: " + nombre + "|\n";
	}

	//compareTo define el orden natural del jugador
	//aqui se ordena alfabeticamente ignorando mayusculas y minusculas
	@Override
	public int compareTo(Jugador o) {
		// TODO Auto-generated method stub
		return this.nombre.compareToIgnoreCase(o.nombre);
	}

}
