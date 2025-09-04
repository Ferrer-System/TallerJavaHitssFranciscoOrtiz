package sistema.producto.clases;

import sistema.producto.abstracts.Electronico;

//clase entidad
public class Iphone extends Electronico {

	private String color;
	private String modelo;
	

	//constructor y adicional llama al costructor de electronico
	public Iphone(String fabricante, String color, String modelo, double precio) {
		super(precio, fabricante);
		this.color = color;
		this.modelo = modelo;
	}

	//devuelve el precio base
	@Override
	public double getPrecio() {
		return precio;
	}

	//precio en venta más un 20% por el tipo de prodcuto Oferta y demanda 
	@Override
	public double getPrecioVenta() {
		return precio * 1.20; // 20% más caro por ser Apple
	}

	// devuelve precio de venta casteado para que solo se muestren 2 decimales
	public String getPrecioVentaformateado() {
		return String.format("%.2f", getPrecioVenta());
	}

	
	public String getColor() {
		return color;
	}

	public String getModelo() {
		return modelo;
	}

	@Override
	public String toString() {
		return "Iphone modelo: " + modelo + " | Frabricante: " + getFabricante() + " | color: " + color
				+ " | precio de venta: " + getPrecioVentaformateado() + "|";
	}

}
