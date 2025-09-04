package sistema.producto.abstracts;

import sistema.producto.interfaces.IElectronico;
import sistema.producto.interfaces.IProducto;

//clase abstracta que representa prodcutos electronicos 
public abstract class Electronico implements IElectronico, IProducto {

	protected String fabricante; // nombre deñ fabricante

	//constructor
	public Electronico(String fabricante) {
		this.fabricante = fabricante;
	}

	//metodo getter
	public String getFabricante() {
		return fabricante;
	}

}
