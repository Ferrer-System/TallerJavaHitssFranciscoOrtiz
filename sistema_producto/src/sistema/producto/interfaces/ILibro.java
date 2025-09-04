package sistema.producto.interfaces;

import java.time.LocalDate;

//interfaz para productos de tipo libro
public interface ILibro {

	public LocalDate getFechaPublicacion();// devuelve fecha en que se publico
	
	public String getAutor();				//devuelve el autor del libro

	public String getTitulo();				//devuelve el titulo del libro

	public String getEditorial();			//devuelve la editorial del libro

}
