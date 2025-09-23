package proyecto.deportes.service;

import java.util.Iterator;

import proyecto.deportes.entidad.Disciplina;
import proyecto.deportes.entidad.Jugador;

/*Servicio que maneja la logica
 * registra jugadores, eliminarlos, verificar  existentes y mostrarlos 
 * */

public class DisciplinaService {

	// Registrar un jugador en todas las colecciones de una disciplina
	// retorna un true si fue agregado
	public boolean registrarJugador(Disciplina disciplina, Jugador jugador) {
		boolean agregado = disciplina.getJugadoresHash().add(jugador);
		disciplina.getJugadoresLinked().add(jugador);
		disciplina.getJugadoresTree().add(jugador);
		return agregado;
	}

	// Elimina un jugador de todas las disciplinas
	// retorna un true si fue eliminado exitosamente
	public boolean eliminarJugador(Disciplina disciplina, Jugador jugador) {
		return disciplina.getJugadoresHash().remove(jugador) && disciplina.getJugadoresLinked().remove(jugador)
				&& disciplina.getJugadoresTree().remove(jugador);

	}

	// Verifica si un jugador existe en una disciplina
	@SuppressWarnings("unused")
	public boolean existeJugador(Disciplina disciplina, Jugador jugador) {
		return disciplina.getJugadoresHash().contains(jugador);
	}

	// Metodo para mostrar jugadores segun el tipo de coleccion
	public void mostrarJugadoresHash(Disciplina disciplina) {
		System.out.println("Jugadores en " + disciplina.getTipo().getNombre() + ": " + disciplina.getJugadoresHash());
	}

	public void mostrarJugadorLinked(Disciplina disciplina) {
		System.out.println("Jugadores en " + disciplina.getTipo().getNombre() + ": " + disciplina.getJugadoresLinked());
	}

	public void mostrarJugadoresTree(Disciplina disciplina) {
		System.out.println("Jugadores en " + disciplina.getTipo().getNombre() + ": " + disciplina.getJugadoresTree());
	}

	public boolean jugadorPorId(Disciplina disciplina, int id) {
		return disciplina.getJugadoresHash().stream().anyMatch(j -> j.getId() == id);
	}

	public int contarJugadores(Disciplina disciplina) {
		return disciplina.getJugadoresHash().size();
	}

	@SuppressWarnings("unused")
	public void mostrarTodos(Iterator<Jugador> it) {
		while (it.hasNext()) {
			Jugador jugador = it.next();
			// solo se imprimira id y nombre
			System.out.println("Id: " + jugador.getId() + ", Nombre: " + jugador.getNombre());
		}
	}

	public void listarJugadoresDisciplinas(Disciplina disciplina) {
		for (Jugador jugador : disciplina.getJugadoresHash()) {
			System.out.println("ID: " + jugador.getId() + ", Nombre: " + jugador.getNombre() + ", Disciplina: "
					+ disciplina.getTipo().getNombre());
		}
	}

}
