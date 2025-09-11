package carrito.supermercado.entidadrecord;

import carrito.supermercado.interfaces.Producto;

public record NoPerecible(String nombre, double precio, int contenido, int calorias) implements Producto {

}
