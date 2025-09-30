package tienda.deportes.test;

import tienda.deportes.enums.Categoria;
import tienda.deportes.models.Producto;
import tienda.deportes.service.Inventario;
import tienda.deportes.service.InventarioService;

public class ProductoMain {

	public static void main(String[] args) {
		//llamar las clases como dependencias para usar su contenido
		Inventario inventario = new Inventario();
		InventarioService service = new InventarioService(inventario);
		
		//Registarr prodcutos 
		service.registrarProducto(new Producto("SKU001", "Balon Adidas", Categoria.FUTBOL, 50));
		service.registrarProducto(new Producto("SKU002", "Camiseta", Categoria.RUNNING, 30));
		service.registrarProducto(new Producto("SKU014", "Raqueta Wilson", Categoria.TENIS, 20));
		service.registrarProducto(new Producto("SKU006", "Goggles", Categoria.NATACION, 15));
		service.registrarProducto(new Producto("SKU019", "Balon Spalding", Categoria.BALONCESTO, 50));
		service.registrarProducto(new Producto("SKU003", "Nike Invisible 3", Categoria.RUNNING, 30));
		
		//consultar producros
		System.out.println("\nConsultar por SKU");
		System.out.println(service.consultarPorSku("SKU001"));
		
		//Reportes
		System.out.println();
		service.reporteOrdenInsercion();
		
		System.out.println();
		service.reporteOrdenNombre();
		
		System.out.println("\nActualizar stock del SKU014 (Ingreso de 15 unidades)...");
		service.actualizarStock("SKU014", 15);
		
		System.out.println("Prodcuto actualizado");
		System.out.println(service.consultarPorSku("SKU014"));
	}

}
