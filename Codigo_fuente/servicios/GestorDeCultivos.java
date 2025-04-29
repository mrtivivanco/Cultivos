//Aquí irá la lógica del programa (leer CSV, guardar datos, etc.
package Codigo_fuente.servicios;

// Importamos la clase Cultivo desde el paquete "clases"
import Codigo_fuente.clases.Cultivo;

import java.util.ArrayList;
import java.util.Scanner;

// Esta clase se encargará de gestionar los cultivos (agregarlos, listarlos, etc.)
public class GestorDeCultivos {

    // Creamos una lista que almacenará todos los cultivos creados
    private ArrayList<Cultivo> listaCultivos;

    // Constructor: se ejecuta al crear un objeto de tipo GestorDeCultivos
    public GestorDeCultivos() {
        listaCultivos = new ArrayList<>();  // Inicializamos la lista vacía
    }

    // Método para agregar un nuevo cultivo a la lista
    public void agregarCultivo(Scanner scanner) {
        System.out.println("\n=== Crear Nuevo Cultivo ===");

        // Pedimos al usuario cada dato necesario
        System.out.print("Ingresa el nombre del cultivo: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingresa la fecha de siembra (formato YYYY-MM-DD): ");
        String fecha = scanner.nextLine();

        System.out.print("Ingresa el estado del cultivo (ACTIVO, EN_RIESGO, COSECHADO): ");
        String estado = scanner.nextLine();

        System.out.print("Ingresa la variedad del cultivo: ");
        String variedad = scanner.nextLine();

        System.out.print("Ingresa la superficie sembrada (en hectáreas): ");
        double superficie = scanner.nextDouble();
        scanner.nextLine();  // Limpiamos el salto de línea pendiente

        System.out.print("Ingresa el código de la parcela: ");
        String codigoParcela = scanner.nextLine();

        // Creamos el objeto Cultivo con los datos ingresados
        Cultivo nuevoCultivo = new Cultivo(nombre, fecha, estado, variedad, superficie, codigoParcela);

        // Lo agregamos a la lista
        listaCultivos.add(nuevoCultivo);

        System.out.println("✅ Cultivo agregado exitosamente.\n");
    }

    // Método para mostrar todos los cultivos almacenados
    public void listarCultivos() {
        System.out.println("\n=== Lista de Cultivos Registrados ===");

        if (listaCultivos.isEmpty()) {
            System.out.println("No hay cultivos registrados.\n");
        } else {
            // Recorremos cada cultivo y mostramos su información
            for (int i = 0; i < listaCultivos.size(); i++) {
                System.out.println("Cultivo #" + (i + 1));
                listaCultivos.get(i).mostrarInfo();
                System.out.println(); // Línea en blanco
            }
        }
    }

    // (Opcional) Método para acceder a la lista desde fuera si se necesita
    public ArrayList<Cultivo> getListaCultivos() {
        return listaCultivos;
    }
}
