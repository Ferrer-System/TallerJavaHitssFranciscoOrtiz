package tienda.deportes.models;


import tienda.deportes.enums.Categoria;

public class Producto {
	private String sku;
	private String nombre;
	private Categoria categoria;
	private int stock;
	
	public Producto(String sku, String nombre, Categoria categoria, int stock) {
		super();
		this.sku = sku;
		this.nombre = nombre;
		this.categoria = categoria;
		this.stock = stock;
	}

	public String getSku() {
		return sku;
	}

	public String getNombre() {
		return nombre;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public int getStock() {
		return stock;
	}
	
	//actualizar el stock sumando o restando
	public void actualizarStock(int cantidad) {
		this.stock += cantidad;
	}

	@Override
	public String toString() {
		return "Producto {sku: " + sku + ", "
				+ "nombre: " + nombre + ", "
						+ "categoria: " + categoria + ", "
								+ "stock: " + stock + "}";
	}
	
	
	

}
