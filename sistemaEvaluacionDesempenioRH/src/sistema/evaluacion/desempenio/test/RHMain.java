package sistema.evaluacion.desempenio.test;

import java.util.List;

import sistema.evaluacion.desempenio.model.Empleado;
import sistema.evaluacion.desempenio.model.Evaluacion;
import sistema.evaluacion.desempenio.service.RecursosHumanosService;

public class RHMain {

	public static void main(String[] args) {
		List<Evaluacion> evaluacion = List.of(new Evaluacion(2022, 88), new Evaluacion(2023, 92), new Evaluacion(2024, 75));
		List<Evaluacion> evaluacion2 = List.of(new Evaluacion(2022, 75), new Evaluacion(2023, 69), new Evaluacion(2024, 93));
		List<Evaluacion> evaluacion3 = List.of(new Evaluacion(2021, 80), new Evaluacion(2022, 81), new Evaluacion(2023, 90), new Evaluacion(2024, 95));
		List<Evaluacion> evaluacion4 = List.of(new Evaluacion(2024, 97));
		
		List<Empleado> empleados = List.of(
				new Empleado("Ferrer Gomez", "IT", 52000, 5, evaluacion3),
				new Empleado("Laura Cortez", "Marketing", 47000, 3, evaluacion),
				new Empleado("Andres Soto", "IT", 68000, 8, evaluacion2),
				new Empleado("Marcos Torres", "Finanzas", 52000, 5, evaluacion3),
				new Empleado("Mario Ambrocio", "IT", 30000, 2, evaluacion4)
				);
		
		RecursosHumanosService service = new RecursosHumanosService(empleados);
		
		System.out.println("===== Empleados del departamento IT =====");
		service.listarPorDeartamento("IT").forEach(System.out::println);
		
		System.out.println("\n===== Salario promedio por departamento =====");
		service.salarioPromedioPorDepto().forEach((d, p) -> System.out.println(d + ": $" + p));
		
		System.out.println("\n===== Empleado con mayor salario =====");
		service.empleadoMayorSalario().ifPresent(System.out::println);
		
		System.out.println("\n===== Empleados con +5 años y salario > 50,000 =====");
		service.empleadosFiltrados().forEach(System.out::println);
		
		
		System.out.println("\n===== Top 3 port ultima evaluacion =====");
		service.topUltimaEvaluacionConDetalles().forEach(System.out::println);
		
		System.out.println("\nEmpleados con evaluacion > 90: " + service.empleadosEvaluacionAlta());
		
		System.out.println("\n===== Ranking promedio de puntaje =====");
		service.promedioPuntaje().forEach((n, p) -> System.out.printf("%s → %.2f%n", n, p));
		
	}

}
