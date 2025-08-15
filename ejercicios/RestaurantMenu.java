package ejercisios;

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
                //En el primer caso anide un if para sumar los precios y acumularlos directamente en la varible total
                case 1 -> {
                    System.out.println("Pedidos, registre su pedido");
                    if (opcion == 1) {
                System.out.println("Ingrese el precio del producto: ");
                precio = sc.nextDouble();
                total += precio;
                System.out.println("Pedido registrado correctamente: " + total);
            }
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
