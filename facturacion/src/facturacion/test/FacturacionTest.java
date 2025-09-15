package facturacion.test;

import java.util.Arrays;

import facturacion.entidades.Cliente;
import facturacion.entidades.Factura;
import facturacion.entidades.Producto;
import facturacion.guardarfacturas.FacturaFileGuardar;
import facturacion.service.ServicioGenerico;

//sistema de facturacion 
		//entidades Cliente, Producto, Factura
		//servisio generico que va a manejar un Id unico -> Todas las entidades que estiendan o implementen de Identificable
		//-> guardar entidades
		//-> listar las entidades
		//-> buscar por ID
		//-> actualizar 
		//-> eliminar por ID
		
		//Interfaz generica udebtificable donde bamos a obligar nuestras intedidades que implementen el metodo abstrcato del ID
		
		//Problema: escribir y leer un archivo donde se gusrade el detalle de la factura
public class FacturacionTest {
	
	//una clase con metodos estaticos, los cuales son: 
	//1.- guardar un arechivo la factura, con la siguiente nomeclatura en el nombre del archivo
	// "factura_idFacturas.txt", todas las facturas se guardan en una carpeta llamada "facturas"
	//2.- Leer la factura y mostrar en consola 
	//3.- Listar todos los nobres de todas las facturas existentes 
	//ejemplo factura_1.txt
	//		  factura_2.txt

	public static void main(String[] args) {
		//Servicios 
		ServicioGenerico<Cliente, String> clienteServicio = new ServicioGenerico<>();
		ServicioGenerico<Producto, Integer> productoServicio = new ServicioGenerico<>();
		ServicioGenerico<Factura, Integer> facturaServicio = new ServicioGenerico<>();
		
		//No se acepta la entidad estudiante porque no implementa de identificable
		//ServicioGenerico<Estudiante, Integer> esrtudianteServicio = new ServicioGenerico<>();
		
		//Clientes
		Cliente cliente = new Cliente("C001", "Eloy Sanchez");
		Cliente cliente2 = new Cliente("C003", "Ferrer Ortiz");
		Cliente cliente3 = new Cliente("C002", "Edith Santiago");
		
		clienteServicio.guardar(cliente);
		//no se guarda el cliente2 porque tiene duplicado
		clienteServicio.guardar(cliente2);
		clienteServicio.guardar(cliente3);
		
		//productos
		Producto producto = new Producto(100, "Laptop", 15000);
		Producto producto2 = new Producto(200, "Mouse", 250);
		Producto producto3 = new Producto(300, "Teclado", 670.54);
		Producto producto4 = new Producto(400, "Pantalla", 12000.54);
		
		productoServicio.guardar(producto);
		productoServicio.guardar(producto2);
		productoServicio.guardar(producto3);
		productoServicio.guardar(producto4);
		
		//Facturas
		//List<Producto> nuevaLista = new ArrayList<>(Arrays.asList(producto, producto2, producto3, producto4)); forma 2		
		Factura factura = new Factura(1, cliente, Arrays.asList(producto, producto2));
		Factura factura2 = new Factura(2, cliente3, Arrays.asList(producto, producto2, producto3));
		facturaServicio.guardar(factura);
		facturaServicio.guardar(factura2);
		
		//Buscar por Id
		System.out.println("\nBuscar cliente C002: ");
		System.out.println(clienteServicio.buscarPorId("C002"));
		
		//Actualizar cliente
		System.out.println("\nActualizar cliente C002: ");
		clienteServicio.actualizar("C002", new Cliente("C002", "Susana Gonzales"));
		
		//Eliminar cliente por ID
		System.out.println("\nEliminando cliente C003: ");
		clienteServicio.eliminar("C003");
		
		//
		System.out.println("\nEliminar y agregar productos a factura");
		factura2.eliminarProducto(300);
		factura2.agregarProducto(producto2);
		System.out.println(factura.generarReporte());
		
		//Guardar las facturas con extencion txt 
		FacturaFileGuardar.guardarFactura(factura);
		FacturaFileGuardar.guardarFactura(factura2);
		
		//leer facturas
		FacturaFileGuardar.leerFactura(1);
		
		//listar las facturas existentes 
		FacturaFileGuardar.listarFacura();
		
	}

}





