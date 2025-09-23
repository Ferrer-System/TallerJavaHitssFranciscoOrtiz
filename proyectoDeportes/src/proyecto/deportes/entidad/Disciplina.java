package proyecto.deportes.entidad;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import proyecto.deportes.enums.TipoDisciplina;

public class Disciplina {
	
	private TipoDisciplina tipo; //tipo de disciplina del enum
	private Set<Jugador> jugadoresHash = new HashSet<>(); 
	private Set<Jugador> jugadoresLinked = new LinkedHashSet<>();
	private Set<Jugador> jugadoresTree = new TreeSet<>();
	
	public Disciplina(TipoDisciplina tipo) {
		this.tipo = tipo;
	}

	public TipoDisciplina getTipo() {
		return tipo;
	}

	public Set<Jugador> getJugadoresHash() {
		return jugadoresHash;
	}

	public Set<Jugador> getJugadoresLinked() {
		return jugadoresLinked;
	}

	public Set<Jugador> getJugadoresTree() {
		return jugadoresTree;
	}

	
}
