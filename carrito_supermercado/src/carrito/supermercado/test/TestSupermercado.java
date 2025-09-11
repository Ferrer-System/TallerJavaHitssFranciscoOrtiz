package carrito.supermercado.test;

import carrito.supermercado.entidadgeneric.Bolsa;
import carrito.supermercado.entidadrecord.Fruta;
import carrito.supermercado.entidadrecord.Lacteo;
import carrito.supermercado.entidadrecord.Limpieza;
import carrito.supermercado.entidadrecord.NoPerecible;
import carrito.supermercado.excepcion.LimiteBolsaException;

public class TestSupermercado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Bolsa<Fruta> bolsaFrutas = new Bolsa<>();
		Bolsa<Lacteo> bolsaLacteos = new Bolsa<>();
		Bolsa<Limpieza> bolsaLimpieza = new Bolsa<>();
		Bolsa<NoPerecible> bolsaNoPerecederos = new Bolsa<>();
		
		try {
			bolsaFrutas.agregar(new Fruta("Manzana", 45.80, 0.5, "Rallada"));
			bolsaFrutas.agregar(new Fruta("Pera", 35.83, 1, "Verde"));
			bolsaFrutas.agregar(new Fruta("Platano", 20.5, 1, "Roja"));
			bolsaFrutas.agregar(new Fruta("Uva", 80.80, 0.5, "Roja"));
			bolsaFrutas.agregar(new Fruta("Mango", 50.33, 2, "Amarilla"));
			bolsaFrutas.agregar(new Fruta("Kiwi", 90.60, 0.5, "Cafe"));
		} catch (LimiteBolsaException e) {
			// TODO: handle exception
			System.out.println("\nError registro Frutas: " + e.getMessage());
		}finally {
			System.out.println("====== Contenido Frutas =====");
		}
		
		
		for (Fruta fruta : bolsaFrutas.getProdutos()) {
			if (fruta != null) {
				System.out.println("Nombre: " + fruta.nombre() + 
						"| Precio: " + fruta.precio() + 
						"| Peso: " + fruta.peso() + 
						"| Color: " + fruta.color());
			}
		}
		
		try {
			bolsaLacteos.agregar(new Lacteo("Leche Santa Clara", 45.50, 1000, 900));
			bolsaLacteos.agregar(new Lacteo("Crema Lala", 35, 1000, 1000));
			bolsaLacteos.agregar(new Lacteo("Nutri Leche ", 45, 5000, 900));
			bolsaLacteos.agregar(new Lacteo("Leche Lala", 68.60, 3000, 1150));
			bolsaLacteos.agregar(new Lacteo("Mantequilla", 50.33, 2000, 350));
			bolsaLacteos.agregar(new Lacteo("Yogurt", 25.30, 2000, 100));
		} catch (LimiteBolsaException e) {
			// TODO: handle exception
			System.out.println("\nError registro Lacteos: " + e.getMessage());
		}finally {
			System.out.println("====== Contenido Lacteos =====");
		}
		
		
		for (Lacteo lacteo : bolsaLacteos.getProdutos()) {
			if (lacteo != null) {
				System.out.println("Nombre: " + lacteo.nombre() + 
						"| Precio: " + lacteo.precio() + 
						"| Cantidad: " + lacteo.cantidad() + "ml " +
						"| Proteinas: " + lacteo.proteinas() + "g");
			}
		}
		
		try {
			bolsaLimpieza.agregar(new Limpieza("Jabon", 25.30, "Detergente", 1));
			bolsaLimpieza.agregar(new Limpieza("Cloro", 35, "Hipoclorito", 3));
			bolsaLimpieza.agregar(new Limpieza("Desinfectante", 20.5, "Alcohol", 1));
			bolsaLimpieza.agregar(new Limpieza("Suavizante", 56.80, "Surfactante Cationico", 5));
			bolsaLimpieza.agregar(new Limpieza("Shampoo", 33, "Sodium Lauril Sulfate", 1));
			bolsaLimpieza.agregar(new Limpieza("Fabuloso", 25, "Sodium Dodecylbenzenesulfonate", 5));
		} catch (LimiteBolsaException e) {
			// TODO: handle exception
			System.out.println("\nError registro Limpieza: " + e.getMessage());
		}finally {
			System.out.println("====== Contenido Limpieza =====");
		}
		
		
		for (Limpieza limpieza : bolsaLimpieza.getProdutos()) {
			if (limpieza != null) {
				System.out.println("Nombre: " + limpieza.nombre() + 
						"| Precio: " + limpieza.precio() + 
						"| Composicion: " + limpieza.composicion() + 
						"| Listros: " + limpieza.litros());
			}
		}
		
		try {
			bolsaNoPerecederos.agregar(new NoPerecible("Arroz", 45.80, 1000, 3600));
			bolsaNoPerecederos.agregar(new NoPerecible("Frijol", 35.83, 900, 3400));
			bolsaNoPerecederos.agregar(new NoPerecible("Lentejas", 20.5, 1000, 3300));
			bolsaNoPerecederos.agregar(new NoPerecible("Harina", 15.80, 1000, 3500));
			bolsaNoPerecederos.agregar(new NoPerecible("Pasta", 50.33, 700, 1800));
			bolsaNoPerecederos.agregar(new NoPerecible("Garvanzo", 40.60, 800, 1200));
		} catch (LimiteBolsaException e) {
			// TODO: handle exception
			System.out.println("\nError registro No Perecibles: " + e.getMessage());
		}finally {
			System.out.println("====== Contenido No Perecibles =====");
		}
		
		
		for (NoPerecible p : bolsaNoPerecederos.getProdutos()) {
			if (p != null) {
				System.out.println("Nombre: " + p.nombre() + 
						"| Precio: " + p.precio() + 
						"| Contenido: " + p.contenido() + "g " + 
						"| Calorias: " + p.calorias() + "cal");
			}
		}
		
		
		
	}

}
