package sistema.producto.interfaces;


/*interfaz base para todos los prodcutos 
 * define que metodos deben implementar todas las clases que sean "productos"
 * */
public interface IProducto {

	public double getPrecio();		//devuleve el precio bace del producto

	public double getPrecioVenta(); //devuelve el precio de venta (aplicando reglas de cada clase o producto)

}
