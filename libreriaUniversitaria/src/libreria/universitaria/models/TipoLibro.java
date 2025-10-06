package libreria.universitaria.models;

public enum TipoLibro {
	PROGRAMACION(0.10),
	CIENCIA(0.15),
	HISTORIA(0.05),
	LITERATURA(0.20),
	OTROS(0.0);
	
	private final double descuento;

	private TipoLibro(double descuento) {
		this.descuento = descuento;
	}

	public double getDescuento() {
		return descuento;
	}

}
