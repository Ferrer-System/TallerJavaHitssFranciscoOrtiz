package tienda.deportes.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import tienda.deportes.models.Producto;

public class Inventario {

	//para busqieda rapida por SKU
	Map<String, Producto> prodcutosSku;
	
	//para mantener el orden de insercion 
	Map<String, Producto> productoOrdenInsercion;
	
	//para mantener productos ordenados por nombre
	Set<Producto> productoPorNombre;

	public Inventario() {
		this.prodcutosSku = new HashMap<>();
		this.productoOrdenInsercion = new LinkedHashMap<>();
		this.productoPorNombre = new TreeSet<>(Comparator.comparing(Producto::getNombre));
	}
	
	
}
