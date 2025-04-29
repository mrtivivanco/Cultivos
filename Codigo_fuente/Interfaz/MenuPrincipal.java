package Codigo_fuente.Interfaz;

import java.util.Scanner;
import services.GestorDeCultivos;
import services.GestorDeParcelas;

public class MenuPrincipal {

    private final Scanner scanner;
    private final GestorDeCultivos gestorCultivos;
    private final GestorDeParcelas gestorParcelas;

    public MenuPrincipal() {
        this.scanner = new Scanner(System.in);
        this.gestorCultivos = new GestorDeCultivos();
        this.gestorParcelas = new GestorDeParcelas();
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    gestorCultivos.listarCultivos();
                    break;
                case 2:
                    gestorCultivos.crearCultivo();
                    break;
                case 3:
                    gestorCultivos.eliminarCultivo();
                    break;
                case 4:
                    gestorCultivos.editarCultivo();
                    break;
                case 5:
                    gestorParcelas.listarParcelas();
                    break;
                case 6:
                    gestorParcelas.agregarParcela();
                    break;
                case 7:
                    gestorParcelas.eliminarParcela();
                    break;
                case 8:
                    gestorParcelas.editarParcela();
                    break;
                case 9:
                    System.out.println("Saliendo y guardando en CSV...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 9);
    }

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

