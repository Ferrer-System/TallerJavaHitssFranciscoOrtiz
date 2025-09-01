package ejercicio;

import java.util.Scanner;

public class MatrizX {
    public static void main(String[] args) {
        //Escaner de lectura por teclado
        Scanner sc = new Scanner(System.in);
        //Leer el tamaño de la matriz cuadrada
        System.out.println("Ingrese un digito para representar la matriz");
        //variable 'n' valor de la matriz cuadradada
        int n = sc.nextInt();
        //Arreglo matriz n x n
        char[][] matriz = new char[n][n];

        //Si el tamaño de la matriz es menor a 1 salir del programa 
        if (n < 1) {
            System.out.println("Error!.......");
            sc.close();
            return;
        }

        //Iteracion para rellenear los espacios con 'X' o '_'
        for (int i = 0; i < n; i++) {           //rellena las filas
            for (int j = 0; j < n; j++) {       //rellena las columnas
                //si estamos en la diaginal principal (i==j)
                //o en la diagonal secundaria (i+j == n-1)
                if (i == j || i + j == n -1) {
                    matriz[i][j] = 'X'; //se imprime la 'X' en el lugar correpondiente
                }else{
                    matriz[i][j] = '_';//se imprime '_' en su lugar correspondiente
                }
            }
        }

        for (char[] fila : matriz) {
            for (char valor : fila) {
                System.out.print(valor);
            }
            System.out.println();
        }
        sc.close();
    
    }

}
