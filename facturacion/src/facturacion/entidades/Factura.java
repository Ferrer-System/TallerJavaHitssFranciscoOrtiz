package facturacion.entidades;

import java.util.ArrayList;
import java.util.List;

import facturacion.interfaces.Identificable;

public class Factura implements Identificable<Integer>{
	
	private Integer id;
	private Cliente cliente;
	private List<Producto> productos;
	
	public Factura(Integer id, Cliente cliente, List<Producto> productos) {
		this.id = id;
		this.cliente = cliente;
		this.productos = new ArrayList<>(productos);
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public List<Producto> getProductos() {
		return productos;
	}
	
	//Metodo dinamico para agregar un elemento a mi lista de productos
	public void agregarProducto(Producto producto) {
		productos.add(producto);
		System.out.println("Producto agregado: " + producto);
	}
	
	//Eliminar producto de lista de productos 
	public boolean eliminarProducto(int id) {
		for (int i = 0; i < productos.size(); i++) {
			if (productos.get(i).getId().equals(id)) {
				System.out.println("Prodcuto eliminado: " + productos.get(i));
				productos.remove(i);
				return true;
			}
			
		}
		System.out.println("No se encontro el producto con ID: " + id);
		return false;
	}
	
	public double calcularTotal() {
		double total = 0;
		for (Producto producto : productos) {
			total += producto.getPrecio();
		}
		return total;
	}
	
	//Generar ticket de la factura
	public String generarReporte() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n====== FACTURA #").append(id).append("==========\n");
		sb.append("Cliente: ").append(cliente.getNombre()).append("\n");
		sb.append("------------------------------------------------\n");
		sb.append(String.format("%-20s %10s\n", "Producto", "Precio"));
		sb.append("------------------------------------------------\n");
		
		for (Producto producto : productos) {
			sb.append(String.format("%-20s $%9.2f\n",
					producto.getDescripcion(),producto.getPrecio()));
		}
			sb.append("------------------------------------------------\n");
			sb.append(String.format("%-20s $%9.2f\n", "Total: ",calcularTotal()));
			sb.append("------------------------------------------------\n");
			
		
		return sb.toString() ;
	}

	@Override
	public String toString() {
		return "Factura {ID: " + id + "\nCliente: " + cliente + 
				"\nProductos: " + productos + "\nTotal: " + calcularTotal() + "}";
	}
	
	

}
