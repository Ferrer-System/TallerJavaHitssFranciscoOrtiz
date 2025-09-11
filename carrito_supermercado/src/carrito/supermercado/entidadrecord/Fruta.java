package carrito.supermercado.entidadrecord;

import carrito.supermercado.interfaces.Producto;

public record Fruta(String nombre, double precio, double peso, String color) 
		implements Producto{
	

}
