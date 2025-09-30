package tienda.deportes.service;

import tienda.deportes.models.Producto;

public class InventarioService extends Inventario {

	private Inventario inventario;

	public InventarioService(Inventario inventario) {
		this.inventario = inventario;
	}

	// Registra un nuevo producto en todas las estructuras.

	public void registrarProducto(Producto producto) {
		inventario.prodcutosSku.put(producto.getSku(), producto);
		inventario.productoOrdenInsercion.put(producto.getSku(), producto);
		inventario.productoPorNombre.add(producto);
	}

	// Consulta un producto por su SKU en O(1).

	public Producto consultarPorSku(String sku) {
		return inventario.prodcutosSku.get(sku);
	}

	// Reporte de productos en el orden en que fueron agregados.

	public void reporteOrdenInsercion() {
		System.out.println("=== Reporte en orden de inserción ===");
		for (Producto p : inventario.productoOrdenInsercion.values()) {
			System.out.println(p);
		}
	}

	// Reporte de productos ordenados alfabéticamente por nombre.

	public void reporteOrdenNombre() {
		System.out.println("=== Reporte en orden alfabético ===");
		for (Producto p : inventario.productoPorNombre) {
			System.out.println(p);
		}
	}

	// Actualiza el stock de un producto.

	public void actualizarStock(String sku, int cantidad) {
		Producto p = inventario.prodcutosSku.get(sku);
		if (p != null) {
			p.actualizarStock(cantidad);
		} else {
			System.out.println("No se encontró producto con SKU: " + sku);
		}
	}

}
