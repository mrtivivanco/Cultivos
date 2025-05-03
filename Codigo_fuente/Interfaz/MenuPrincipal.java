package Codigo_fuente.Interfaz;

import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Codigo_fuente.clases.Cultivo;
import Codigo_fuente.servicios.GestorDeCultivos;
import Codigo_fuente.servicios.GestorDeParcelas;
import Codigo_fuente.servicios.LectorEscritorCSV;

//Clase que representa el menu principal del sistema agrícola.
//Presetna un interfaz de usuario para interactuar con cultivos y parcelas 
public class MenuPrincipal {

	private Scanner scanner = new Scanner(System.in);
	// Gestor que maneja todas las opercaiones relacionadas con los cultivos.
	private final GestorDeCultivos gestorCultivos;
	// Gestor que maneja todas las operaciones relacionadas con las parcelas.
	private final GestorDeParcelas gestorParcelas;

	// Constructor que inicializa el menu con sus dependencias
	public MenuPrincipal() {
		List<Cultivo> lista = LectorEscritorCSV.leerCultivosDesdeCSV("cultivo.csv");
		this.gestorCultivos = new GestorDeCultivos(scanner); // Gestor de cultivos
		this.gestorCultivos.setListaCultivos(lista);
		this.gestorParcelas = new GestorDeParcelas(this.gestorCultivos, scanner);// Gestor de parcelas
	}

	// Método principal que inicia el menu y maneja la interaccion con el usuario.
	public void iniciar() {

		int opcion = -1;
		while (opcion != 9) {
			mostrarMenu();
			System.out.print("Seleccione una opción: ");
			String input = scanner.nextLine(); // leer como texto para evitar InputMismatch
			try {
				opcion = Integer.parseInt(input); // convertir a entero de forma segura
			} catch (NumberFormatException e) {
				System.out.println("Debe ingresar un número válido.");
				continue;
			} catch (InputMismatchException e) {
				System.out.println("Formato de entrada incorrecto.");
				scanner.nextLine(); // limpiar buffer
				continue;
			} catch (NoSuchElementException e) {
				System.out.println("No se encontró más entrada. Finalizando.");
				continue;
			}

			switch (opcion) {
			case 1:
				gestorCultivos.listarCultivos();
				grabarCSV();
				break;
			case 2:
				gestorCultivos.agregarCultivo();
				grabarCSV();
				break;
			case 3:
				gestorCultivos.eliminarCultivo();
				grabarCSV();
				break;
			case 4:
				gestorCultivos.editarCultivo();
				grabarCSV();
				break;
			case 5:
				gestorParcelas.listarParcelas();
				grabarCSV();
				break;
			case 6:
				gestorParcelas.agregarParcela();
				grabarCSV();
				break;
			case 7:
				gestorParcelas.eliminarParcela();
				grabarCSV();
				break;
			case 8:
				gestorParcelas.editarParcela();
				grabarCSV();
				break;
			case 9:
				System.out.println("Saliendo y guardando en CSV...");
				break;
			default:
				System.out.println("Opción no válida.");
			}

		}
	}

	private void grabarCSV() {
		LectorEscritorCSV.guardarCultivosEnCSV(this.gestorCultivos.getListaCultivos(), "cultivo.csv");
	}

	// Muestra el menú de operaciones disponibles en la consola
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

	public static void main(String[] args) {
		MenuPrincipal menu = new MenuPrincipal();
		menu.iniciar();
	}
}
