package entidades;

import enums.OrderPriority;
import enums.OrderStatus;
import enums.PaymentMethod;

//clase que representa el pedido en el sistema 
//cada pedido tiene un Id unico cliente, estado, prioridad y metodo de pago
public class Order {

	private static int nextId; // contador estatico que es generado por el constructor 
	
	private int id; //id unico del pedido
	private String customer;//nombre del cliente
	private OrderStatus status;//estado del pedido
	private OrderPriority priority;//prioridad del pedido
	private PaymentMethod paymentMethod;//metodo de pago
	
	//constructor que crear un nuevo pedido
	//el id se asigna automaticamente
	public Order(String customer, OrderStatus status, OrderPriority priority, PaymentMethod paymentMethod) {
		this.id = ++nextId;//id unico asignado y luego incrementa de uno en uno
		this.customer = customer;
		this.status = status;
		this.priority = priority;
		this.paymentMethod = paymentMethod;
	}
	
	
	//metodo que imprime los detallen en consola
	public void mostrarDetalles() {
		System.out.println("\nPedido #" + id);
		System.out.println("Cliente: " + customer);
		System.out.println("Estado: " + status + " → " + status.getMessage());
		System.out.println("Prioridad: " + priority + " (Nivel " + priority.getLevel() + ")");
		System.out.println("Metodo de pago: " + paymentMethod + " → " + paymentMethod.getDescripcion());
	}
	
	
	
}
