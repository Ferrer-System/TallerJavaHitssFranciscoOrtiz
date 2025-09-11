package carrito.supermercado.entidadrecord;

import carrito.supermercado.interfaces.Producto;

public record Limpieza(String nombre, double precio, String composicion, double litros) implements Producto {

}
