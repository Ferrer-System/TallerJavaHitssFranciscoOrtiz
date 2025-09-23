package proyecto.deportes.enums;

public enum TipoDisciplina {
	FUTBOL("Futbol"),
	BASKET("Basquetbol"),
	VOLEY("Voleibol");
	
	private final String nombre;//nombre de la disciplina 

	private TipoDisciplina(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	
	

}
