package sistema.producto.clases;

import sistema.producto.abstracts.Electronico;

//clase entidad
public class TvLcd extends Electronico {

	
	private int pulgadas;

	//constructor que tambien llama al constructor de electronico
	public TvLcd(String fabricante, int pulgadas, double precio) {
		super(precio, fabricante);
		this.pulgadas = pulgadas;
	}

	
	@Override
	public double getPrecio() {
		return precio;
	}

	@Override
	public double getPrecioVenta() {
		return precio * 1.16; // precio más impuesto
	}

	//devuelve precio de venta casteado para que solo se muestren 2 decimales
	public String getPrecioVentaformateado() {
		return String.format("%.2f", getPrecioVenta());
	}

	public int getPulgadas() {
		return pulgadas;
	}

	// toString modificado
	@Override
	public String toString() {
		return "Tv LCD pulgadas: " + pulgadas + "| Fabricante: " +

				getFabricante() + "| Precio venta: " + getPrecioVentaformateado() + "| ";
	}

}
