package sistema.supermercado.enums;

// Enum para poder dar los porcentajes de descuento
public enum Descuento {

	NORMAL(0.0),
	VIP(0.10);
	
	private final double porcentaje;

	private Descuento(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public double getPorcentaje() {
		return porcentaje;
	}
	
}
