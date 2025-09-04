package sistema.producto.test;


import sistema.producto.clases.Comics;
import sistema.producto.clases.Iphone;
import sistema.producto.clases.Libro;
import sistema.producto.clases.TvLcd;
import sistema.producto.interfaces.IProducto;

public class SistemaProductosMain {

	public static void main(String[] args) {

		//arry de productos (IProducto interfaz padre)
		IProducto[] productos = new IProducto[5];
		
		//creacion de los objetos 
		IProducto iphone = new Iphone("Apple", "Negro", "14 Pro", 25000);
		IProducto tvlcd = new TvLcd("Sony", 55, 18000);
		IProducto libro1 = new Libro("Mariona Nadel Farré", "Manual Imprescendible 2da edición", "ANAYA MULTIMEDIA", 760, "24/07/2021");
		IProducto libro2 = new Libro("Mark J. Price", "Tools and Skills for .NET 8", "Packt Publishing", 9600, "30/07/2024");
		IProducto comics = new Comics("Stan Lee", "Spider Man", "Marvel", 9000, "28/09/2020", "Peter Parker");
		
		//asiganacion de los objetos en los indices del array
		productos[0] = iphone;
		productos[1] = tvlcd;
		productos[2] = libro1;
		productos[3] = libro2;
		productos[4] = comics;
		
		// Recorremos el array ejecutando el toString() de cada clase
		for (IProducto p : productos) {
			System.out.println(p);
		}
	}

}
