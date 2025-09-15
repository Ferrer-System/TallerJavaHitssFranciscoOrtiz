package facturacion.guardarfacturas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import facturacion.entidades.Factura;

public class FacturaFileGuardar {
	
	//Crea la carpeta donde se guarada todas las facturas 
	private static final String CARPETA_FACTURAS = "facturas";
	
	//Guarda la factura en un archivo con la nomeclatura factura_id.txt
	public static void guardarFactura(Factura factura) {
		try {
			Path carpeta = Paths.get(CARPETA_FACTURAS);
			if (!Files.exists(carpeta)) {
				Files.createDirectories(carpeta);
			}
			
			//Nombre del archivo segun el nombre del archivo
			String nombreArchivo = "factura_" + factura.getId() + ".txt";
			Path archivo = carpeta.resolve(nombreArchivo);
			
			//Escibir contenido de la factura en el archivo
			Files.writeString(archivo, factura.generarReporte());
			
			System.out.println("Factura guardada en: " + archivo.toAbsolutePath());
		} catch (IOException e) {
			System.out.println("Error al guaradar la fatura: " + e.getMessage());
		}
	}
	
	// leer las faturas y mostrarlas en consola
	public static void leerFactura(int idFactura) {
		Path archivo = Paths.get(CARPETA_FACTURAS, "factura_" + idFactura + ".txt");
		try {
			String contenido = Files.readString(archivo);
			System.out.println("\nContenido de la factura " + idFactura + ":" + contenido);
		} catch (IOException e) {
			System.out.println("No se puede leer la factura " + idFactura + ": " + e.getMessage());
		}
	}
	
	//Listar todas las facturas existentes en la carpeta 
	public static void listarFacura() {
		Path carpeta = Paths.get(CARPETA_FACTURAS);
		try {
			if (!Files.exists(carpeta)) {
				System.out.println("No exiten facturas todavia");
				return;
			}
			
			System.out.println("Facturas existentes:");
			var archivos = Files.list(carpeta)
					.filter(Files::isRegularFile)
					.map(path -> path.getFileName().toString())
					.collect(Collectors.toList());
			
			if (archivos.isEmpty()) {
				System.out.println("La carpeta de facturacion esta vacia");
			}else {
				archivos.forEach(System.out::println);
			}
			
		} catch (IOException e) {
			System.out.println("Error al listar facturas: " + e.getMessage());
			
		}	
	}
}





