package sistema.evaluacion.desempenio.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import sistema.evaluacion.desempenio.model.Empleado;
import sistema.evaluacion.desempenio.model.Evaluacion;

public class RecursosHumanosService {

	private List<Empleado> empleados;

	public RecursosHumanosService(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	 // Helper: devuelve Optional con la evaluación más reciente de un empleado
    private Optional<Evaluacion> ultimaEvaluacion(Empleado e) {
        return e.getEvaluacions().stream()
                .max(Comparator.comparingInt(Evaluacion::getAnio));
    }
    
	// 1. Listar emppleados en un departamento ordenado alfabeticamente
	public List<Empleado> listarPorDeartamento(String depto) {
		return empleados.stream().filter(e -> e.getDepartamento().equalsIgnoreCase(depto))
				.sorted(Comparator.comparing(Empleado::getNombre)).toList();
	}

	// 2. Calcular salarios promedio opr departamento
	public Map<String, Double> salarioPromedioPorDepto() {
		return empleados.stream().collect(
				Collectors.groupingBy(Empleado::getDepartamento, Collectors.averagingDouble(Empleado::getSalario)));
	}

	// 3. Obtener el empleado con mayor salario
	public Optional<Empleado> empleadoMayorSalario() {
		return empleados.stream().max(Comparator.comparingDouble(Empleado::getSalario));
	}

	// 4. listar empleados con mas de 5 años y salario > 50,000
	public List<Empleado> empleadosFiltrados() {
		return empleados.stream().filter(e -> e.getExperiencia() > 5 && e.getSalario() > 50000).toList();
	}

	// 5. top 3 de empleados con mejor puntaje en la ultima evaluacion
	public List<String> topUltimaEvaluacionConDetalles() {
		return empleados.stream().map(e -> {
			Optional<Evaluacion> ue = ultimaEvaluacion(e);
			double punt = ue.map(Evaluacion::getPuntaje).orElse(Double.NEGATIVE_INFINITY);
			int anio = ue.map(Evaluacion::getAnio).orElse(-1);
			return Map.entry(e, Map.entry(anio, punt));
		}).filter(entry -> entry.getValue().getValue() != Double.NEGATIVE_INFINITY)
				.sorted((a, b) -> Double.compare(b.getValue().getValue(), a.getValue().getValue())).limit(3)
				.map(entry -> {
					Empleado emp = entry.getKey();
					int anio = entry.getValue().getKey();
					double punt = entry.getValue().getValue();
					return String.format("%s - %s - Última evaluación: %d (%.1f)", emp.getNombre(),
							emp.getDepartamento(), anio, punt);
				}).collect(Collectors.toList());
	}

	// 6. Contar empleados con una evaluacion > 90
	public long empleadosEvaluacionAlta() {
		return empleados.stream().filter(e -> e.getEvaluacions().stream().anyMatch(ev -> ev.getPuntaje() > 90)).count();
	}

	// 7. Promedio de puntaje por empleado
	public Map<String, Double> promedioPuntaje() {
		return empleados.stream().collect(Collectors.toMap(Empleado::getNombre,
				e -> e.getEvaluacions().stream().mapToDouble(Evaluacion::getPuntaje).average().orElse(0.0)));
	}

}
