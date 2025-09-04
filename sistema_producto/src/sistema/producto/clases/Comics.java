package sistema.producto.clases;

//clase entidad 
//extiende de Libro y agrega atributos extra: personaje
public class Comics extends Libro{
	
	private String personaje;
	
	//constructor implementa los atributos del constructor de la clase Libro
	public Comics(String autor, String titulo, String editorial, double precio, String fechaPublicacion,
			String personaje) {
		super(autor, titulo, editorial, precio, fechaPublicacion);
		this.personaje = personaje;
	}

	@Override
	public double getPrecioVenta() {
		return getPrecio() * 1.16; //más iva
	}

	//devuelve precio de venta casteado para que solo se muestren 2 decimales
	public String getPrecioVentaformateado() {
		return String.format("%.2f", getPrecioVenta());
	}
	
	public String getPersonaje() {
		return personaje;
	}

	@Override
	public String toString() {
		return "Comic: " + "| Titulo: " + getTitulo() + "| Personaje: " + personaje + 
				"| Precio de venta: " + getPrecioVentaformateado() + "| Fecha de publicacion: " + getFechaPublicacion() + "|";
	}
	
	
	

}
