// Indicamos que esta clase pertenece al paquete Codigo_fuente
package Codigo_fuente;

// Importamos las clases necesarias de nuestro proyecto
import Codigo_fuente.clases.Actividad;
import Codigo_fuente.servicios.GestorDeCultivos;
import Codigo_fuente.servicios.LectorCSV;

// Importamos Scanner para leer datos que el usuario escriba
import java.util.Scanner;

// Esta es la clase principal de nuestro programa
public class Principal {

    // Este es el método especial main, donde comienza la ejecución del programa
    public static void main(String[] args) {

        // Creamos un Scanner que nos permite leer lo que el usuario escribe en consola
        Scanner scanner = new Scanner(System.in);

        // Creamos el gestor que manejará todos los cultivos en memoria
        GestorDeCultivos gestor = new GestorDeCultivos();

        // Al iniciar el programa, leemos los cultivos guardados previamente en el archivo CSV
        // Esto permite que los cultivos antiguos estén disponibles aunque el programa se reinicie
        LectorCSV.leerCultivosDesdeCSV(gestor.getListaCultivos(), "cultivo.csv");

        // Creamos una actividad de prueba, solo para mostrar cómo se vería
        Actividad miActividad = new Actividad("RIEGO", "2023-03-20", "COMPLETADA");

        // Variable donde se almacenará la opción elegida por el usuario
        int opcion = -1;

        // Ciclo principal que muestra el menú hasta que el usuario elige salir (opción 0)
        while (opcion != 0) {
            // Mostramos el menú
            System.out.println("===============================");
            System.out.println(" SISTEMA DE GESTIÓN AGRÍCOLA ");
            System.out.println("===============================");
            System.out.println("1. Listar cultivos registrados");
            System.out.println("2. Mostrar actividad de prueba");
            System.out.println("3. Crear un nuevo cultivo");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            // Leemos la opción elegida por el usuario
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiamos el salto de línea que queda pendiente

            // Ejecutamos una acción según la opción elegida
            switch (opcion) {
                case 1:
                    // Mostrar todos los cultivos que están en la lista
                    gestor.listarCultivos();
                    break;

                case 2:
                    // Mostrar la actividad de prueba
                    System.out.println("\n=== Actividad ===");
                    miActividad.mostrarInfo();
                    System.out.println(); // Espacio visual
                    break;

                case 3:
                    // Crear un nuevo cultivo usando el gestor
                    gestor.agregarCultivo(scanner);
                    break;

                case 0:
                    // Antes de cerrar, guardamos todos los cultivos en el archivo CSV
                    LectorCSV.guardarCultivosEnCSV(gestor.getListaCultivos(), "cultivo.csv");

                    // Mensaje de despedida
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    // Si el usuario escribe una opción inválida
                    System.out.println("Opción no válida. Intenta otra vez.\n");
                    break;
            }
        }

        // Cerramos el Scanner para liberar memoria (buena práctica)
        scanner.close();
    }
}
