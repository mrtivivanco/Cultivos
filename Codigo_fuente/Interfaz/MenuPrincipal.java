package Codigo_fuente.Interfaz;

import java.util.Scanner;
import services.GestorDeCultivos;
import services.GestorDeParcelas;

//Clase que representa el menu principal del sistema agrícola.
//Presetna un interfaz de usuario para interactuar con cultivos y parcelas 
public class MenuPrincipal {

    //Scanner para leer la entrada del usuario 
    private final Scanner scanner;
    //Gestor que maneja todas las opercaiones relacionadas con los cultivos.
    private final GestorDeCultivos gestorCultivos;
    //Gestor que maneja todas las operaciones relacionadas con las parcelas. 
    private final GestorDeParcelas gestorParcelas;

    //Constructor que inicializa el menu con sus dependencias 
    public MenuPrincipal() {
        this.scanner = new Scanner(System.in); //Scanner para leer la consola 
        this.gestorCultivos = new GestorDeCultivos(); //Gestor de cultivos 
        this.gestorParcelas = new GestorDeParcelas();//Gestor de parcelas
    }

    //Método principal que inicia el menu y maneja la interaccion con el usuario.
    public void iniciar() {
        int opcion;
        do {
            mostrarMenu(); //Muestra las opciones disponibles
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine()); //Lee la opcion del usuario 

            //Ejecuta la acción correspondiente a la accion seleccionada
            switch (opcion) {
                case 1: //Listar cultivos
                    gestorCultivos.listarCultivos();
                    break;
                case 2: //Crear nuevo cultivo
                    gestorCultivos.crearCultivo();
                    System.out.println("Cultivo creado exitosamente!");
                    break;
                case 3: //Eliminar cultivo
                    gestorCultivos.eliminarCultivo();
                    System.out.println("Cultivo eliminado exitosamente!");
                    break;
                case 4: //Editar cultivo
                    gestorCultivos.editarCultivo();
                    break;
                case 5: //Listar parcelas
                    gestorParcelas.listarParcelas();
                    break;
                case 6: //Agragar parcelas
                    gestorParcelas.agregarParcela();
                    System.out.println("Parcela creado exitosamente!");
                    break;
                case 7: //Eliminar parcelas
                    gestorParcelas.eliminarParcela();
                    System.out.println("Parcela eliminada exitosamente!");
                    break;
                case 8: //Editar parcelas
                    gestorParcelas.editarParcela();
                    break;
                case 9: //Salir del programa
                    System.out.println("Saliendo y guardando en CSV...");
                    break;
                default: //Opción no válida
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 9); //Repite hasta que el usuario elija salir (opción 9)
    }

    //Muestra el menú de operaciones disponibles en la consola
    private void mostrarMenu() {
        System.out.println("\n=== MENÚ PRINCIPAL ===");
        System.out.println("1. Listar cultivos");
        System.out.println("2. Crear nuevo cultivo");
        System.out.println("3. Eliminar cultivo");
        System.out.println("4. Editar cultivo");
        System.out.println("5. Listar parcelas");
        System.out.println("6. Agregar parcela");
        System.out.println("7. Eliminar parcela");
        System.out.println("8. Editar parcela");
        System.out.println("9. Salir");
    }
}


