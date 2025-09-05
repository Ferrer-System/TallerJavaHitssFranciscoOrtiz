package excepcion.estudiantes.excepciones;

//excepcion personalizada para cuando la edad es menor a 18
public class EdadInvalidaExcepcion extends Exception{
	
	/**serie por default puede o no puede ir
	 */
	private static final long serialVersionUID = 1L;

	public EdadInvalidaExcepcion(String mensaje) {
		super(mensaje);
	}

}
