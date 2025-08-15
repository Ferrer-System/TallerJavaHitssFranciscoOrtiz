package ejercisios;

import java.util.Scanner;

public class NotasAlumno {

    public static void main(String[] args) {
        //Inicializamos el Scanner
        Scanner entrada = new Scanner(System.in);

        //declaramos todas la variables que utilizaremos dentro de nuestro programa
        double sumaTotal = 0;
        double sumaMayor6 = 0;
        double nota = 0;
        int contadorMayores6 = 0;
        int contadorIguales1 = 0;
        double promedioTotal = 0;
        double promedioMayor6 = 0;

        //iniciamos un ciclo for para iterar las peticiones de las notas hasta llegar
        //al maximo de 20 notas obligatorias
        for (int i = 1; i <= 20; i++) {
            System.out.println("Ingresa la nota " + i + "(1.0 a 10.0)");
            nota = entrada.nextDouble();

            //indicamos con una condicional si las notas con cierto valor y retornar un menaje predeterminado
            //y cerrar el programa en dado caso que se cumpla
            if (nota < 1.0 || nota > 10.0) {
                System.out.println("Error: la nota es invalida");
                System.out.println("Programa finalizado");
                entrada.close();
                return; //salimos del programa
            }
            //suma total de las notas
            sumaTotal += nota;

            //indicamos con una condicional si cumplen cierto parametros 
            if (nota >= 6.0) {
                sumaMayor6 += nota;
                contadorMayores6++; 
            }
            //contamos si es exactamente igual a un valor predeterminado en este caso 1 
            if (nota == 1.0) {
                contadorIguales1++;
            }
        }
    // calculamos los promedios 
        promedioTotal = sumaTotal/20;
        //indicamos el promedio de las notas mayores a 6 y sacamos su promedio
        if (contadorMayores6 > 0) {
                promedioMayor6 = sumaMayor6 / contadorMayores6;
            }else{
                promedioMayor6 = 0;
            }

       /*  if (promedioTotal >= 6.0) {
            System.out.println("\nAprovaste con: " + promedioTotal);
        }else{
            System.out.println("\nReprovaste: " + promedioTotal);
        }*/

        // Imprimimos todos los resultados 
        System.out.println("Totales:");
        System.out.println("Promedio Total: " + promedioTotal);
        System.out.println("Promedio de notas mayores a 6: " + promedioMayor6);
        System.out.println("Cantidad de notas iguales a 1: " + contadorIguales1);
        

    }
}
