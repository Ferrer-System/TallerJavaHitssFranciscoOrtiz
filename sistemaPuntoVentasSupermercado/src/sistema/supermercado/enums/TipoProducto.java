package sistema.supermercado.enums;

public enum TipoProducto {

	ALIMENTO(0.1), BEBIDAS(0.08), LIMPIEZA(0.1), ELECTRONICO(0.15), OTROS(0.0);

	private final double descuento;

	private TipoProducto(double descuento) {
		this.descuento = descuento;
	}

	public double getDescuento() {
		return descuento;
	}

}
