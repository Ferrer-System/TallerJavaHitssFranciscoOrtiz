package ciclos;

import java.util.Scanner;

public class NumeroMenor {

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
         //pedir la cantidad de los numero que se desean comparar
         System.out.println("Ingresar la cantidad de numeros que se desea comparar (al menos  10 numeros enteros): ");
         int cantidad = entrada.nextInt();

         //validamos la cantidad de los digitos pedidos 
         if (cantidad < 10) {
            System.out.println("Debes ingresar almenos 10 numeros.");
            
            entrada.next();
            return; // sale del programa si no cumple
         }

         //variable para almacenar el numero con menor vlor 
         int menor = Integer.MAX_VALUE;
         //MAX_VALUE evalua que el primer numero ingresado siempre sera el menor

         //pedimos los numeros solicitados en el Scanner uno por uno usando un for
         for (int i = 1; i <= cantidad; i++) {
            System.out.println("ingrtesa el numero  " + i + ": ");
            int numero = entrada.nextInt();

            //comparamos para encontrar el numero menor 
            if (numero < menor) {
                menor = numero; // actualizamos el menor si el nuevo nuemro ingresado es más pequeño
            }
         } 
         //usamos el if para mostrar el resultado segun su rango 
         if (menor < 10) {
            System.out.println("El numero: " + menor + " es menor que 10.");
         }else{
            System.out.println("El numero: "  + menor + " es igual o mayor que 10.");
         }
         entrada.close(); //terminamos el Scanner
    }
}
