package carrito.supermercado.entidadgeneric;

import java.util.ArrayList;
import java.util.List;

import carrito.supermercado.excepcion.LimiteBolsaException;

public class Bolsa <T> {
	private List<T> produtos;
	private static final int LIMITE = 5;
	
	
	public Bolsa() {
		produtos = new ArrayList<>(); //limite de objeto Producto en la bolsa
	}
	
	public void agregar(T producto) throws LimiteBolsaException{
		if (produtos.size() >= LIMITE) {
			throw new LimiteBolsaException("No se pueden agrega más de cinco productos en la bolsa.");
		}
		produtos.add(producto);
	}
	
	public List<T> getProdutos() {
		return produtos;
	}
	public int getCantidad() {
		return produtos.size();
	}
	

}
