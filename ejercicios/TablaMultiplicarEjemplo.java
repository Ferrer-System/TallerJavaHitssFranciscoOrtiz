package ejercisios;

import java.util.Scanner;

public class TablaMultiplicarEjemplo {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Multiplicacion de dos numeros");
        
        //Pedimos el primer dato al usuario
        System.out.println("Ingresa el primer numero: ");
        int num1 = entrada.nextInt();

        //Pedimos el segundo dato al usuario
        System.out.println("Ingresa el segundo numero: ");
        int num2 = entrada.nextInt();

        //determinar el signo del resultado
        //si uno es negativo y el otro posituvo = negativo
        //si ambos son negativos o posutivos = positivo
        boolean esNegativo = (num1 < 0 && num2 > 0) || (num1 > 0 && num2 < 0);

        //trabajar con valores absolutos para la multiplicacion 
        int a = Math.abs(num1);// valor absoluto del primer numero
        int b = Math.abs(num2);//valor absoluto del sugundo numero 

        //for para la suma repetidamente
        //sumamos con un for el valor de "a" un total de veces al valor de "b"
        int resultado = 0;
        for (int i = 0; i < b; i++) {
            resultado += a;
        }
        //aplicar el signo final
        if (esNegativo) {
            resultado = -resultado;
        }

        System.out.println("El resultado es: " + resultado);
        entrada.close();
    }

}
