package excepcion.estudiantes.testmain;


import excepcion.estudiantes.entidades.Alumno;
import excepcion.estudiantes.excepciones.EdadInvalidaExcepcion;

public class RegistroAlumno {

	public static void main(String[] args) {

		// arreglo fico con solo 3 objetos
		Alumno[] alumnos = new Alumno[3];

		// objetos de tipo alumno
		Alumno alumno = new Alumno("Sara Lara", "Primer Semestre", 18);
		Alumno alumno2 = new Alumno("Ferrer Garcia", "Sexto Semestre", 19);
		Alumno alumno3 = new Alumno("Tomas Mora", "Primer Semestre", 20);
		Alumno alumno4 = new Alumno("Juan Guadarrama", "Octavo Semestre", 27);

		// declaracion de los objetosen un arreglo temporal para simular untentos de
		// registro
		Alumno[] candidatos = { alumno, alumno2, alumno3, alumno4 };

		int indice = 0; // parametro para controlar la posiscion del arreglo guardado

		// for para recorrer el arreglo candidatos para registrarlos o intentar
		// registrarlos
		for (Alumno candidato : candidatos) {
			try {

				// validacion del limite del arreglo
				if (indice >= alumnos.length) {
					throw new ArrayIndexOutOfBoundsException("No se puede registrar más de 3 alumnos.");
				}

				// validacion de edad negativa
				if (candidato.getEdad() < 0) {
					throw new IllegalArgumentException("La edad no puede ser negativa: " + candidato);
				}

				// validacion de edad menor a 18 usando excepcion perzonalizada
				if (candidato.getEdad() < 18) {
					throw new EdadInvalidaExcepcion("La edad minima es de 18 años: " + candidato);
				}

				// si pasan todas las validaciones se registra en un areglo alumnos[]
				/*
				 * simulando un arreglo similar al siguiente alumnos[0] = alumno; alumnos[2] =
				 * alumno2; alumnos[3] = alumno3; alumnos[4] = alumno4;
				 */
				alumnos[indice] = candidato;
				System.out.println("alumno registardo correctamente: " + alumnos[indice]);
				indice++; // avanza a la siguiente posicion

				// capturamos las posubles excepciones en multiples catch
				// segun sea la validacion
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Error de registro: " + e.getMessage());
			} catch (IllegalArgumentException e) {
				System.out.println("Error: " + e.getMessage());
			} catch (EdadInvalidaExcepcion e) {
				System.out.println("Error: " + e.getMessage());
			}
		}

		// Se muestran todos los alumnos que si fueron registrados
		System.out.println("\nLista final de alumnos registrados: ");
		for (Alumno a : alumnos) {
			if (a != null) { // solo se mostrara la posiciones que tienen un alumno registrado 
				System.out.println(a);
			}
		}

	}

}
