package main.test;

import entidades.Order;
import enums.OrderPriority;
import enums.OrderStatus;
import enums.PaymentMethod;

public class ManPedidos {

	public static void main(String[] args) {

		//pedidos que muestra sus detalles
		Order order1 = new Order("Ana",OrderStatus.NEW, OrderPriority.HIGH, PaymentMethod.CARD);
		Order order2 = new Order("Luis",OrderStatus.SHIPPED, OrderPriority.MEDIUM, PaymentMethod.CASH);
		Order order3 = new Order("Marta",OrderStatus.DELIVERED, OrderPriority.LOW, PaymentMethod.TRANSFER);
		
		//muestra la infprmacion usando el metodo mostrar detallesd ela clase Order
		order1.mostrarDetalles();
		order2.mostrarDetalles();
		order3.mostrarDetalles();
		
	}

}
