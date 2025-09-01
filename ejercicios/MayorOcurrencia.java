package ejercicio;

import java.util.Scanner;

public class MayorOcurrencia {
    public static void main(String[] args) {
        //Inicializacion de l escaner
        Scanner sc = new Scanner(System.in);
        // inicializacion de las variables con sus indices [10]
        int[] numeros = new int[10];
        int[] frecuencia = new int[10];

        //solicitar al usuario nuemeros validos
        System.out.println("Ingrese 10 numeros del 1 al 9: ");
        for (int i = 0; i < numeros.length; i++) {
            int num;
            //inicializar dowhile para el bucle de las solicitudes
            do {
                System.out.println("Numero " + (i + 1) + ": ");
                num = sc.nextInt();
                //validar el rango de las peticiones y utilizar el bucle para las peticiones en dado 
                //caso que no se cumpla vuelve a pedir el digito con el dowhile
                if (num < 1 || num >= 10) {
                    System.out.println("Error: solo se permite numeros del 1 al 9");
                }
                //principal orden del while
            } while (num < 1 || num > 9);
            //Guarda el numero en el arreglo pribcipal
            numeros[i] = num;
            //suma uno en la pocision correspondiente
            frecuencia[num]++;
        }
        //inicializacion de varianles para las repeticiones y el valor que mas se repite
        int masRepetido = 1; // asume el primer numero como el mas repetido
        int frecuenciaMax = frecuencia[1]; // numero de veces que aparecio el primer numero 

        //bucle para contar las repeticiones y busca si hay otro con mas repeticiones 
        for (int i = 2; i <= 9; i++) {
            if (frecuencia[i] > frecuenciaMax) {
                masRepetido = i;// actualiza el numero mas repetido
                frecuenciaMax = frecuencia[i]; // actualiza su frecuencia 
            }
        }

        //imprimir los valores correspondientes
        System.out.println("\nLa mayor ocurrencua es: "+ frecuenciaMax);
        System.out.println("El elemento que mas se repite es: " + masRepetido);
        sc.close();

    }

}
