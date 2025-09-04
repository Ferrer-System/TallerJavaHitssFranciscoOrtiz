package sistema.producto.abstracts;

import sistema.producto.interfaces.IElectronico;

//clase abstracta que representa prodcutos electronicos 
public abstract class Electronico extends Producto implements IElectronico {

	protected String fabricante; // nombre deL fabricante

	//constructor
	public Electronico(double precio, String fabricante) {
		super(precio);
		this.fabricante = fabricante;
	}


	//metodo getter
	public String getFabricante() {
		return fabricante;
	}

	
}
