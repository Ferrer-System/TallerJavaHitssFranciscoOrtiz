package carrito.supermercado.entidadrecord;

import carrito.supermercado.interfaces.Producto;

public record Lacteo(String nombre, double precio, int cantidad, int proteinas) implements Producto {

}
