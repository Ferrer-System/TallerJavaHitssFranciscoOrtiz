package sistema.supermercado.test;

import java.util.Arrays;
import java.util.List;

import sistema.supermercado.enums.Descuento;
import sistema.supermercado.enums.TipoEmpleado;
import sistema.supermercado.enums.TipoProducto;
import sistema.supermercado.models.Cliente;
import sistema.supermercado.models.Empleado;
import sistema.supermercado.models.Producto;
import sistema.supermercado.models.Venta;
import sistema.supermercado.service.SupermercadoService;

public class VentasMain {

	public static void main(String[] args) {
		// Llamar al seervice (SupermercadoService)
		SupermercadoService service = new SupermercadoService();

		// Productos
		Producto producto = new Producto("Leche", 25.0, 10, TipoProducto.BEBIDAS);
		Producto producto2 = new Producto("Pan", 15.0, 3, TipoProducto.ALIMENTO);
		Producto producto3 = new Producto("Queso", 80.0, 2, TipoProducto.ALIMENTO);
		Producto producto4 = new Producto("TV 45 Pulgadas", 4200.0, 2, TipoProducto.ELECTRONICO);

		service.registrarProducto(producto);
		service.registrarProducto(producto2);
		service.registrarProducto(producto3);
		service.registrarProducto(producto4);
		

		// Clientes
		Cliente cliente = new Cliente("Ferrer Lara Mota", Descuento.NORMAL);
		Cliente cliente2 = new Cliente("Juan Torres", Descuento.VIP);

		// Empleados
		Empleado empleado = new Empleado("Martha Mora", TipoEmpleado.CAJERO);
		Empleado empleado2 = new Empleado("Anna Lucia", TipoEmpleado.SUPERVISOR);

		// Ventas
		List<Producto> productosVenta = Arrays.asList(producto, producto2, producto3);
		Venta venta = service.registrarVenta(cliente, empleado, productosVenta);

		List<Producto> productosVenta2 = Arrays.asList(producto4, producto2, producto3);
		Venta venta2 = service.registrarVenta(cliente2, empleado2, productosVenta2);
		
		// Generar detalles de la venta
		service.detallesVenta(venta);
		
		// Notificar al cliente
		service.notificarCliente(cliente, empleado);

		// Generar detalles de la venta
		service.detallesVenta(venta2);
				
		// Notificar al cliente
		service.notificarCliente(cliente2, empleado2);

		// Stock bajo
		System.out.println("\nProductos con stock bajo: " + service.filtrarStockBajo());

		// Producto de muestra
		System.out.println("\nProducto de muestra: " + service.generarProductoMuestra());

		// Producto mas caro comparar productos
		System.out.println("\nProducto más caro: " + service.obtenerMasCato(producto, producto3));

		// Aplicar descuento directo al producto
		System.out.println("\nPrecio antes de descuento: " + service.generarProductoMuestra().getPrecio());
		Producto conDescuento = service.aplicarDescuento(service.generarProductoMuestra(), cliente);
		System.out.println("Precio despues de descuento VIP: " + cliente.getNombre() + " - " + service.generarProductoMuestra().getNombre()
				+ ": " + conDescuento.getPrecio());
		
		//Generar ticket estructurado
		// Generar detalles de la venta
		service.generarTicket(venta2);
						
		// Notificar al cliente
		service.notificarCliente(cliente2, empleado2);
		

	}

}
