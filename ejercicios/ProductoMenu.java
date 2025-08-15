package ejercisios;

import java.util.Scanner;

public class ProductoMenu {
    public static void main(String[] args) {
        // para la tarea se requiere un menu para administrar a los productos con las opciones: actualizar, aliminar, crear, listar y salir
        //para la clase con el metodo main vamos a contar con un menu y poder seleccionar el tipo de operacion, segun el numero ingresado
        //dentro de cada opcion imprimir in texto relacionadom por ejemplo, para actualizar: "Isiario actualizado correctamente"
        //para elimir el mensaje "Usuario eliminado correctamente" y asi sucesivamente dependiendo de la opcion
        //itera hasta que la opcion se salir, cada vez que se selecciona una operacion distinta a salir,
        //al finalizar con dicha operacion debe volver al menu para continuar con otra, con la opcion salir (5) se debe mostrar el mensaje "Haz salid con exito!"
        //y finalizar el programa
        //nombre del repo para git "TallerJavaHitssNombreApellido"
        Scanner sc = new Scanner(System.in);
        //gardar la opcion seleccionada por el usuario  
        int opcion;

        System.out.println("===== Opciones del menu del 1 al 5=====");
        System.out.println("1. Actualizar" + "\n2. Eliminar" + "\n3. Crear" + "\n4. Listar" + "\n5. Salir");
        //menu que se repetira ghasta que se elija la opcion 5
        do {
            System.out.println("Seleccionar una opcion del menu: ");
            opcion = sc.nextInt();
            switch (opcion) {
            case 1 -> System.out.println("Producto actualizado correctamente");
            case 2 -> System.out.println("Producto eliminado correctamente");
            case 3 -> System.out.println("Producto creado correctamente");
            case 4 -> System.out.println("Producto listado correctamente");
            case 5 -> System.out.println("Opcion para salir del menu");
            
                default -> System.out.println("Opcion no valida. Por favor intentalo de nuevo");
            }
        } while (opcion != 5);
        

        sc.close();


    }

}
