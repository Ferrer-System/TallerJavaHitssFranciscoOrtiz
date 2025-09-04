package sistema.producto.abstracts;

import sistema.producto.interfaces.IProducto;

// clase abstracta que representara cualquier prodcuto
public abstract class Producto implements IProducto {

	protected double precio;

	//constructor
	public Producto(double precio) {
		this.precio = precio;
	}

	//implementacion comun para todos los producutos 
	@Override
	public double getPrecio() {
		return precio;
	}

	
}
