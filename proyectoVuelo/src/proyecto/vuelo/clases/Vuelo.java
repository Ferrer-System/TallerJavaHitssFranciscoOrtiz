package proyecto.vuelo.clases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Vuelo {

	private String codigo;
	private String origen;
	private String destino;
	private LocalDate fechaLlegada;
	private LocalTime horaLlegada;
	private int numPasajeros;

	public Vuelo(String codigo, String origen, String destino, LocalDate fechaLlegada, LocalTime horaLlegada,
			int numPasajeros) {
		super();
		this.codigo = codigo;
		this.origen = origen;
		this.destino = destino;
		this.fechaLlegada = fechaLlegada;
		this.horaLlegada = horaLlegada;
		this.numPasajeros = numPasajeros;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getOrigen() {
		return origen;
	}

	public String getDestino() {
		return destino;
	}

	public LocalDate getFechaLlegada() {
		return fechaLlegada;
	}

	public LocalTime getHoraLlegada() {
		return horaLlegada;
	}

	public int getNumPasajeros() {
		return numPasajeros;
	}

	public String getFechaHoraFormateada() {
		DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("dd MMM yyyy", new Locale("es", "ES"));
		DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");
		return fechaLlegada.format(formatterFecha)
				+ " " + horaLlegada.format(formatterHora);
	}

	@Override
	public String toString() {
		return codigo + ": " + origen + " a " + destino + 
				", aterriza el " + getFechaHoraFormateada() + 
				", pasajeros: " + numPasajeros;
	}
	
	
	
	
	
	
}
