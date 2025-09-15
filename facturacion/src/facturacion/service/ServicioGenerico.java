package facturacion.service;

import java.util.ArrayList;
import java.util.List;

import facturacion.interfaces.Identificable;

public class ServicioGenerico<T extends Identificable<ID>, ID> {

	private List<T> datos = new ArrayList<>();

	/*public ServicioGenerico() {
	
		datos = new ArrayList<>();
	}*/
	
	//buscar elemento por ID
	public T buscarPorId(ID id) {
		for (T elemento : datos) {
			if (elemento.getId().equals(id)) {
				return elemento;
			}
		}
		return null;
	}
	
	//metodo para guardar elemento sin duplicarse
	public void guardar(T elemento) {
		if (buscarPorId(elemento.getId()) != null) {
			System.out.println("Ya existe el elemento con ID: " + elemento.getId());
		}else {
			datos.add(elemento); //agregar elemento a la lista
			System.out.println("Guardado exitosamente: " + elemento);
		}
	}
	
	//Listar todos los elementos 
	public List<T> listar(){
		return datos;
	}
	
	//actualizar un elemento de datos deacurdo al ID
	public boolean actualizar(ID id, T nuevoElemento) {
		for (int i = 0; i < datos.size(); i++) {
			if (datos.get(i).getId().equals(id)) {// get()i obtienen el vaor del elemento en la posiscion i
				datos.set(i, nuevoElemento);
				System.out.println("Actualizado ID: " + id + " con: " + nuevoElemento);
				return true;
			}
			
		}
		System.out.println("No se encontro el ID " + id + " para actualizar");
		return false;
	}
	
	//metodo para eliminar un elemento con ID
	public boolean eliminar(ID id) {
		for (int i = 0; i < datos.size(); i++) {
			if (datos.get(i).getId().equals(id)) {
				datos.remove(i);
				System.out.println("Eliminado ID: " + id);
				return true;
			}
			
		}
		System.out.println("No se encontro el ID: " + id);
		return false;
		
	}
	
	
	
}
