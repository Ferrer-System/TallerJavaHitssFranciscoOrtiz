package enums;

//muestra los metodos de pago disponible
// cada metodo de pago tiene una descripcion asociada
public enum PaymentMethod {
	CASH("Efectivo"),
	CARD("Targeta de credito/devito"),
	TRANSFER("Trnsferencia");

	private final String descripcion;// describe el metodo de pago

	//constructor que mostrara la descripcion del enum
	PaymentMethod(String descripcion) {
		this.descripcion = descripcion;
	}

	//metodo qie devuelve la descripcion 
	public String getDescripcion() {
		return descripcion;
	}
	
}
