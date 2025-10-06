package sistema.supermercado.models;

import java.util.List;

public class Venta {
	
	private static int contador = 0;
	private int id;
	private Cliente cliente;
	private Empleado empleado;
	private List<Producto> productos;
	private double total;
	
	public Venta(Cliente cliente, Empleado empleado, List<Producto> productos, double total) {
		this.id = ++contador;
		this.cliente = cliente;
		this.empleado = empleado;
		this.productos = productos;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public double getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "Venta id: " + id + 
				" Cliente:" + cliente + 
				" Empleado: " + empleado +
				" Total: " + total;
	}
	
	

}
