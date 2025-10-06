package sistema.supermercado.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import sistema.supermercado.enums.Descuento;
import sistema.supermercado.enums.TipoProducto;
import sistema.supermercado.models.Cliente;
import sistema.supermercado.models.Empleado;
import sistema.supermercado.models.Producto;
import sistema.supermercado.models.Venta;

public class SupermercadoService {

	private List<Producto> productos = new ArrayList<>();
	private List<Venta> ventas = new ArrayList<>();

	// Registrar producto usando Consumer
	public void registrarProducto(Producto producto) {
		Consumer<Producto> agregar = p -> productos.add(p);
		agregar.accept(producto);
	}

	// Filtrar los productos con stock bajo
	public List<Producto> filtrarStockBajo() {
		Predicate<Producto> stockBajo = p -> p.getStock() < 5;
		return productos.stream().filter(stockBajo).toList();
	}

	// Calcular el total de una venta considerando el descuento segun el tipo de
	// cliente
	public double calcularTotal(List<Producto> productos, Cliente cliente) {
		double subTotal = productos.stream().mapToDouble(Producto::getPrecio).sum();
		double descuento = cliente.getTipo().getPorcentaje();
		return subTotal - (subTotal * descuento);
	}

	public double calcularTotalConDescuento(Venta venta) {
		StringBuilder mensaje = new StringBuilder();
		double total = 0;
		
		for (Producto p : productos) {
			double preciOriginal = p.getPrecio();
			double precio = preciOriginal;
			boolean desProducto = false;
			boolean descuentoVip = false;
			
			if (p.getTipo().getDescuento() > 0) {
				precio *= (1 - p.getTipo().getDescuento());
				desProducto = true;
			}
			
			//Descuento Vip
			if (venta.getCliente().getTipo() == Descuento.VIP && preciOriginal > 1000) {
				precio *= (1 - venta.getCliente().getTipo().getPorcentaje());
				descuentoVip = true;
			}
			
			total += precio;
			
			if (desProducto && descuentoVip) mensaje.append(p.getNombre()).append(": descuento producto + VIP aplicado\n");
			else if (desProducto) mensaje.append(p.getNombre()).append(": descuento por tipo de producto aplicado\n");
			else if (descuentoVip) mensaje.append(p.getNombre()).append(": descuento VIP aplicado\n");
			else mensaje.append(p.getNombre()).append(": sin descuento\n");
		}
		System.out.println(mensaje.toString());
		return total;
		
	}

	// Registrar venta
	public Venta registrarVenta(Cliente cliente, Empleado empleado, List<Producto> productos) {
		double total = calcularTotal(productos, cliente);
		Venta venta = new Venta(cliente, empleado, productos, total);
		ventas.add(venta);
		return venta;
	}

	// Generar productos de muestra
	public Producto generarProductoMuestra() {
		Supplier<Producto> productoMuestra = () -> new Producto("Papas fritas", 25.5, 15, TipoProducto.ALIMENTO);
		return productoMuestra.get();
	}

	// Aplicar descuento a producto segun cliente
	public Producto aplicarDescuento(Producto producto, Cliente cliente) {
		Function<Producto, Producto> descuento = p -> {
			double nuevoPrecio = p.getPrecio() * (1 - cliente.getTipo().getPorcentaje());
			p.setPrecio(nuevoPrecio);
			return p;
		};
		return descuento.apply(producto);
	}

	// Comparar dos productos y devolver el mas caro
	public Producto obtenerMasCato(Producto p1, Producto p2) {
		BiFunction<Producto, Producto, Producto> comparador = (a, b) -> a.getPrecio() > b.getPrecio() ? a : b;
		return comparador.apply(p1, p2);
	}

	// Verificar si un cliente puede tener descuento extra
	public double clienteConDescuento(Cliente cliente, double total) {
		BiFunction<Cliente, Double, Double> aplicar = (c, t) -> {
			if (c.getTipo() == Descuento.VIP && t > 1000) {
				return t * (1 - c.getTipo().getPorcentaje()); //Aplica desceunto vip
			}
			return t;
		};
		return aplicar.apply(cliente, total);
	}

	// Generar detalles de la venta
	public void detallesVenta(Venta venta) {
		System.out.println("\n----- detalles de Venta -----");
		System.out.println("Venta #" + venta.getId());
		System.out.println("Cliente: " + venta.getCliente().getNombre());
		System.out
				.println("Empleado: " + venta.getEmpleado().getNombre() + " (" + venta.getEmpleado().getPuesto() + ")");
		System.out.println("Productos: ");
		
		double subTotal = 0.0;
		
		for (Producto p : venta.getProductos()) {
			double precioOrig = p.getTipo().getDescuento() * 100;
			double precioFinal = p.getPrecio() * (1 - p.getTipo().getDescuento());
			subTotal += precioFinal;
			
			String mensaje = p.getTipo().getDescuento() > 0 ? "Descuento por tipo de producto aplicado" : "Sin descuento";
			System.out.printf(" - %s: $%.2f (%s)\n", p.getNombre(), precioFinal, mensaje);
			System.out.println("-> desceunto del prodcuto: " + precioOrig + "%");
		}
		
		double totalFinal = subTotal;
		
		//Descuento VIP sobre subtotal si aplica
		if (venta.getCliente().getTipo() == Descuento.VIP && subTotal > 1000) {
			totalFinal = subTotal * (1 - venta.getCliente().getTipo().getPorcentaje());
			System.out.println("Descuento VIP aplicado sobre subtotal: " + venta.getCliente().getTipo().getPorcentaje() * 100 + "%");
		}
		System.out.printf("Sun Total: $%.2f\n", subTotal);
		System.out.printf("Total con decuento aplicado: $%.2f\n" , totalFinal);
		System.out.println("-----------------------------");
	

	}

	// Notificar al cliente
	public void notificarCliente(Cliente cliente, Empleado empleado) {
		BiConsumer<Cliente, Empleado> notificar = (c, e) -> System.out.println("Estimado " + c.getNombre()
				+ ", su compra fue procesada por " + e.getNombre() + " (" + e.getPuesto() + ")");
		notificar.accept(cliente, empleado);
	}

	// Generar ticket de venta
	public void generarTicket(Venta venta) {
		System.out.println("\n=============================");
		System.out.printf("%20s\n","Ticket de Venta");
		System.out.println("=============================");
		
		System.out.printf("Venta: #%d\n", venta.getId());
		System.out.printf("Cliente: %s\n", venta.getCliente().getNombre());
		System.out
				.printf("Empleado: %s (%s)\n", 
						venta.getEmpleado().getNombre(), 
						venta.getEmpleado().getPuesto());
		System.out.println("-----------------------------");
		System.out.printf("%-20s %10s\n","Productos", "Precio", "Precio Final");
		System.out.println("-----------------------------");
		
		double subTotal = 0.0;
		
		for (Producto p : venta.getProductos()) {
			double precioOrig = p.getPrecio();
			double precioFinal = precioOrig * (1 - p.getTipo().getDescuento());
			subTotal += precioFinal;
			
			// Producto alineado a la izquierda, precio a la derecha
			System.out.printf("%-20s $%9.2f\n", p.getNombre(), precioOrig , precioFinal);
			if (p.getTipo().getDescuento() > 0) {
				System.out.printf("   -> Descuento producto: -%.0f%%\n", p.getTipo().getDescuento() * 100);
			}
		}
		
		System.out.println("-----------------------------");
		System.out.printf("%-20s $%9.2f\n", "Subtotal", subTotal);
		
		double totalFinal = subTotal;
		
		//Descuento VIP sobre subtotal si aplica
		if (venta.getCliente().getTipo() == Descuento.VIP && subTotal > 1000) {
			double desVip = venta.getCliente().getTipo().getPorcentaje();
			totalFinal = subTotal * (1 - desVip);
			System.out.printf("%-20s (-%.0f%%)\n", "Descuento VIP: ", desVip * 100, "%");
		}
		System.out.println("-----------------------------");
		System.out.printf("$%.20s $%9.2f\n", "TOTAL", totalFinal);
		System.out.println("=============================");
		System.out.printf("Gracias por su compra, %s!\n" , venta.getCliente().getNombre());
		System.out.println("=============================");	}
	
}
