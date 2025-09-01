package enums;

public enum OrderStatus {

	// enum que representa los posibles estados de un pedido
	// con su mensaje correspondiente a cada estado
	NEW("Pedido creado"),
	PROCESSING("Pedido en proceso"),
	SHIPPED("Pedido invalido"),
	DELIVERED("Pedido entregado"),
	CANCELLED("Pedido cancelado");

	private final String message; // variable final asociado al estado 

	//constructor con la accion de asignar el mensaje 
	OrderStatus(String message) {
		this.message = message;
	}

	//metodo para leer el mensaje (Obtenerlo)
	public String getMessage() {
		return message;
	}
	
	
}
