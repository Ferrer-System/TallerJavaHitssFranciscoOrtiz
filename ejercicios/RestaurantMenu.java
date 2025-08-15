package ejercicio;

import java.util.Scanner;

public class RestaurantMenu {
    public static void main(String[] args) {
        //Inicializar el Scaner 
        Scanner sc = new Scanner(System.in);
        //Declaracion de variables
        double precio;
        double total = 0;
        Integer opcion;

        //Menu estatico
        System.out.println("===== Opciones a elegir del menu de opciones =====");
        System.out.println("1. Registrar un pedido.");
        System.out.println("2. Mostrar el total de ventas.");
        System.out.println("3. Salir del sistema.");

        //iniciar el do
        do {
            //Dentro del ciclo do la peticion que se repetira cada que se ejecute una tarea
            System.out.println("Elegir opcion: ");
            opcion = sc.nextInt();
            //Las opciones estan controladas por un switch moderno
            switch (opcion) {
                //En el primer caso anide un if  dentro de un dowhile para sumar los precios y acumularlos directamente en la varible total
                case 1 -> {
                    do {
                        System.out.println("Pedidos, Ingrese el precio de su producto");
                        precio = sc.nextDouble();
                        if (precio <= 0) {
                            System.out.println("Precio del producto invalido");
                        }
                
                } while (precio <= 0);

                total += precio;
                System.out.println("Pedido registrado correctamente: " + total);
                }
                //Concateno el total, no afecta las opciones 
                case 2 -> System.out.println("Total de las ventas: " + (total));
                case 3 -> System.out.println("Salir del sistema"); //Sale del menu y termina el sitema
                default -> {System.out.println("Opcion invalida");
                
            }
                
            }
        } while (opcion != 3);//Sale del menu y termina el sitema
        //Como adicional imprime el total 
        System.out.println("Gran total: " + total);
        sc.close();// cierre del escaner
    }

}
