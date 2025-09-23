package proyecto.deportes.test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import proyecto.deportes.entidad.Disciplina;
import proyecto.deportes.entidad.Jugador;
import proyecto.deportes.enums.TipoDisciplina;
import proyecto.deportes.service.DisciplinaService;

public class MainDeportes {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		DisciplinaService service = new DisciplinaService();

		// Crear disciplinas
		Disciplina futbol = new Disciplina(TipoDisciplina.FUTBOL);
		Disciplina basket = new Disciplina(TipoDisciplina.BASKET);
		Disciplina voley = new Disciplina(TipoDisciplina.VOLEY);

		int opcion;
		do {
			// Menu Principal
			System.out.println("\n========== Menu Deportes ==========");
			System.out.println("1. Registrar jugador en disciplina");
			System.out.println("2. Mostrar jugadores por (Hashset)");
			System.out.println("3. Mostrar jugadores en orden de inscripcion (LinkedHashSet)");
			System.out.println("4. Mostrar Jugadores por nombre (TreeSet)");
			System.out.println("5. Mostrar fusion de equipos");
			System.out.println("6. Mostrar jugadores comunes");
			System.out.println("7. Transferir jugadores");
			System.out.println("8. Ranking por id");
			System.out.println("9. buscar por disciplina");
			System.out.println("10. Jugadores comunes entre deportes");
			System.out.println("11. Salir");
			System.out.println("Elegir opcion: ");
			opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
			case 1 -> {
				// Registrar jugadores en disciplina
				System.out.println("Elegir disciplina: 1.Futbol 2.Basket 3.Voley");
				int d = scanner.nextInt();
				scanner.nextLine();
				System.out.println("ID: ");
				int id = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Nombre: ");
				String nombre = scanner.nextLine();
				Jugador j = new Jugador(id, nombre);

				switch (d) {
				case 1 -> service.registrarJugador(futbol, j);
				case 2 -> service.registrarJugador(basket, j);
				case 3 -> service.registrarJugador(voley, j);
				default -> System.out.println("Opcion no valida");
				}

			}
			case 2 -> {
				Set<Jugador> todos = new HashSet<>();
				todos.addAll(futbol.getJugadoresHash());
				todos.addAll(basket.getJugadoresHash());
				todos.addAll(voley.getJugadoresHash());
				service.mostrarJugadoresHash(futbol);
				System.out.println("Total jugadores de fulbol: " + service.contarJugadores(futbol));
				service.mostrarJugadoresHash(basket);
				System.out.println("Total jugadores de basket: " + service.contarJugadores(basket));
				service.mostrarJugadoresHash(voley);
				System.out.println("Total jugadores de Voleibol: " + service.contarJugadores(voley));
				System.out.println("===== Todos los jugadores =====");
				service.mostrarTodos(todos.iterator());
			}
			case 3 -> {
				Set<Jugador> todos = new LinkedHashSet<>();
				todos.addAll(futbol.getJugadoresHash());
				todos.addAll(basket.getJugadoresHash());
				todos.addAll(voley.getJugadoresHash());
				service.mostrarJugadorLinked(futbol);
				System.out.println("Total jugadores de fulbol: " + service.contarJugadores(futbol));
				service.mostrarJugadorLinked(basket);
				System.out.println("Total jugadores de basket: " + service.contarJugadores(basket));
				service.mostrarJugadorLinked(voley);
				System.out.println("Total jugadores de voleibol: " + service.contarJugadores(voley));

				System.out.println("===== Todos los jugadores =====");
				service.mostrarTodos(todos.iterator());
			}
			case 4 -> {
				Set<Jugador> ranking = new TreeSet<>(Comparator.comparing(Jugador::getNombre));
				ranking.addAll(futbol.getJugadoresHash());
				ranking.addAll(basket.getJugadoresHash());
				ranking.addAll(voley.getJugadoresHash());
				service.mostrarJugadorLinked(futbol);
				System.out.println("Total jugadores de futbol: " + service.contarJugadores(futbol));
				service.mostrarJugadorLinked(basket);
				System.out.println("Total jugadores de basket: " + service.contarJugadores(basket));
				service.mostrarJugadorLinked(voley);
				System.out.println("Total jugadores de voleibol: " + service.contarJugadores(voley));

				System.out.println("===== Todos los jugadores =====");
				service.mostrarTodos(ranking.iterator());

			}
			case 5 -> {
				// Fusion
				Set<Jugador> union = new HashSet<>(futbol.getJugadoresHash());
				union.addAll(basket.getJugadoresHash());
				
				Set<Jugador>comunes = new HashSet<>(futbol.getJugadoresHash());
				comunes.retainAll(basket.getJugadoresHash());
				
				service.mostrarJugadorLinked(futbol);
				service.mostrarJugadorLinked(basket);
				service.mostrarJugadorLinked(voley);
				System.out.println("=====Fusion Jugadores Futbol + Basket=====");
				service.mostrarTodos(union.iterator());
				
				System.out.println("===== Jugadores comunes Futbol + Basket =====");
				if (comunes.isEmpty()) {
					System.out.println("No hay jugadores comunes entre Futbol y basket.");
				}else {
					service.mostrarTodos(comunes.iterator());
				}
				
				
			}
			case 6 -> {
				// interseccion entre futbol y basket
				Set<Jugador> interseccion = new HashSet<>(futbol.getJugadoresHash());
				interseccion.retainAll(basket.getJugadoresHash());
				System.out.println("Jugadores comunes futbol y basket: " + interseccion);
				System.out.println("===== Todos los jugadores =====");
				service.mostrarTodos(interseccion.iterator());
			}
			case 7 -> {
				// Transferir jugadores de futnol a basket
				System.out.print("ID jugador a tranferir de basket a futbol: ");
				int id = scanner.nextInt();
				scanner.nextLine();
				Jugador temp = basket.getJugadoresHash().stream().filter(j -> j.getId() == id).findFirst().orElse(null);
				if (temp != null) {
					service.eliminarJugador(basket, temp);
					service.registrarJugador(futbol, temp);
					System.out.println("Jugador transferido: " + temp);
					System.out.println("===== Todos los jugadores =====");

				} else {
					System.out.println("Jugador no encontrado en basket");
				}
			}
			case 8 -> {
				// Ranking de jugadores pr Id
				Set<Jugador> ranking = new TreeSet<>(Comparator.comparing(Jugador::getId));
				ranking.addAll(futbol.getJugadoresHash());
				ranking.addAll(basket.getJugadoresHash());
				ranking.addAll(voley.getJugadoresHash());
				System.out.println("Ranking pot Nombre: " + ranking);
				System.out.println("===== Todos los jugadores =====");
				service.mostrarTodos(ranking.iterator());
			}
			case 9 -> {
				System.out.println("ID jugador a buscar:");
				int id = scanner.nextInt();
				scanner.nextLine();
				Jugador temp = new Jugador(id, "");
				boolean encontrado = false;
				if (service.jugadorPorId(futbol, id)) {
					System.out.println("EL jugador con ID: " + id + " esta inscrito en Futbol");
					encontrado = true;
				}
				if (service.jugadorPorId(basket, id)) {
					System.out.println("El jugador con ID: " + id + " esta inscrito en Basket");
					encontrado = true;
				}
				if (service.jugadorPorId(voley, id)) {
					System.out.println("El jugador con Id " + id + " esta incrito en Voleibol");
				}
				if (!encontrado) {
					System.out.println("El jugador con ID: " + id + " no esta inscrito en ningua disciplina");
				}
			}
			case 10 -> {
				System.out.println("===== Lista completa de jugadores por disciplina =====");
				service.listarJugadoresDisciplinas(futbol);
				service.listarJugadoresDisciplinas(basket);
				service.listarJugadoresDisciplinas(voley);
			}
			case 11 -> System.out.println("Saliendo...");

			default -> System.out.println("Opcion no valida");
			}

		} while (opcion != 11);
		scanner.close();
	}

}
