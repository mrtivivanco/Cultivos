//Aquí irá la lógica del programa (leer CSV, guardar datos, etc.
package Codigo_fuente.servicios;

// Importamos la clase Cultivo desde el paquete "clases"
import Codigo_fuente.clases.Cultivo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Esta clase se encargará de gestionar los cultivos (agregarlos, listarlos, etc.)
public class GestorDeCultivos {

	private Scanner scanner;
	
	// Creamos una lista que almacenará todos los cultivos creados
	private List<Cultivo> listaCultivos;

	// Constructor: se ejecuta al crear un objeto de tipo GestorDeCultivos
	public GestorDeCultivos(Scanner scanner) {
		this.scanner = scanner;
		listaCultivos = new ArrayList<>(); // Inicializamos la lista vacía
	}

	/**
	 * Elimina un elemento de la lista de Cultivos
	 * @param aEliminar El cultivo a eliminar
	 * @return Verdadero cuando la eliminación es exitosa
	 */
	public boolean eliminarCultivo(Cultivo aEliminar) {
		if (listaCultivos.isEmpty()) {
			System.out.println("No hay cultivos para eliminar.");
			return false;
		}
		int index = listaCultivos.indexOf(aEliminar);
		if (index == -1) {
			System.out.println("No existe el cultivo.");
			return false;
		}
		listaCultivos.remove(index);
		System.out.println("Cultivo eliminado");
		return true;
	}
	
	/**
	 * Modificar un elemento de la lista de Cultivos
	 * @param aModificar El cultivo a modificar
	 * @return Verdadero cuando la modificación es exitosa
	 */
	public boolean modificarCultivo(Cultivo aModificar) {
		if (listaCultivos.isEmpty()) {
			System.out.println("No hay cultivos para modificar.");
			return false;
		}
		int index = listaCultivos.indexOf(aModificar);
		if (index == -1) {
			System.out.println("No existe el cultivo.");
			return false;
		}
		listaCultivos.set(index, aModificar);
		return true;
	}
	
	/**
	 * Agrega un elemento de la lista de Cultivos
	 * @param aAgregar El cultivo a agregar
	 * @return Verdadero cuando se agrega el cultivo exitosamente
	 */
	public boolean agregarCultivo(Cultivo aAgregar) {
		listaCultivos.add(aAgregar);
		return true;
	}

	// Método para agregar un nuevo cultivo a la lista
	public void agregarCultivo() {
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
			scanner.nextLine(); // Limpiamos el salto de línea pendiente

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
	public List<Cultivo> getListaCultivos() {
		return listaCultivos;
	}

	public void setListaCultivos(List<Cultivo> listaCultivos) {
		this.listaCultivos = listaCultivos;
	}

	// Método para eliminar un cultivo
	public boolean eliminarCultivo() {
			if (listaCultivos.isEmpty()) {
				System.out.println("No hay cultivos para eliminar.");
				return false;
			}

			listarCultivos();
			System.out.print("\nIngrese el número del cultivo a eliminar: ");

			try {
				int index = Integer.parseInt(scanner.nextLine()) - 1;

				if (index < 0 || index >= listaCultivos.size()) {
					throw new IndexOutOfBoundsException("Número de cultivo inválido");
				}

				Cultivo aEliminar = listaCultivos.get(index);
				System.out.print("¿Está seguro de eliminar el cultivo " + aEliminar.getNombre() + "? (S/N): ");
				String confirmacion = scanner.nextLine();

				if (confirmacion.equalsIgnoreCase("S")) {
					listaCultivos.remove(index);
					System.out.println("✅ Cultivo eliminado exitosamente.");
					return true;
				} else {
					System.out.println("Operación cancelada.");
					return false;
				}

			} catch (NumberFormatException e) {
				System.out.println("❌ Error: Debe ingresar un número válido");
				return false;
			} catch (IndexOutOfBoundsException e) {
				System.out.println("❌ Error: " + e.getMessage());
				return false;
			}
	}

	// Método para editar un cultivo existente
	public boolean editarCultivo() {
			if (listaCultivos.isEmpty()) {
				System.out.println("No hay cultivos para editar.");
				return false;
			}

			listarCultivos();
			System.out.print("\nIngrese el número del cultivo a editar: ");

			try {
				int index = Integer.parseInt(scanner.nextLine()) - 1;

				if (index < 0 || index >= listaCultivos.size()) {
					throw new IndexOutOfBoundsException("Número de cultivo inválido");
				}

				Cultivo cultivo = listaCultivos.get(index);
				System.out.println("\nEditando cultivo: " + cultivo.getNombre());
				System.out.println("(Deje en blanco para mantener el valor actual)\n");

				// Editar nombre
				System.out.print("Nombre [" + cultivo.getNombre() + "]: ");
				String nuevoNombre = scanner.nextLine();
				if (!nuevoNombre.trim().isEmpty()) {
					cultivo.setNombre(nuevoNombre);
				}

				// Editar fecha
				System.out.print("Fecha de siembra [" + cultivo.getFecha() + "]: ");
				String nuevaFecha = scanner.nextLine();
				if (!nuevaFecha.trim().isEmpty()) {
					if (!nuevaFecha.matches("\\d{4}-\\d{2}-\\d{2}")) {
						throw new IllegalArgumentException("Formato de fecha inválido");
					}
					cultivo.setFecha(nuevaFecha);
				}

				// Editar estado
				System.out.print("Estado [" + cultivo.getEstado() + "]: ");
				String nuevoEstado = scanner.nextLine();
				if (!nuevoEstado.trim().isEmpty()) {
					if (!nuevoEstado.toUpperCase().matches("ACTIVO|EN_RIESGO|COSECHADO")) {
						throw new IllegalArgumentException("Estado inválido");
					}
					cultivo.setEstado(nuevoEstado.toUpperCase());
				}

				// Editar variedad
				System.out.print("Variedad [" + cultivo.getVariedad() + "]: ");
				String nuevaVariedad = scanner.nextLine();
				if (!nuevaVariedad.trim().isEmpty()) {
					cultivo.setVariedad(nuevaVariedad);
				}

				// Editar superficie
				System.out.print("Superficie [" + cultivo.getSuperficie() + "]: ");
				String nuevaSuperficieStr = scanner.nextLine();
				if (!nuevaSuperficieStr.trim().isEmpty()) {
					double nuevaSuperficie = Double.parseDouble(nuevaSuperficieStr);
					if (nuevaSuperficie <= 0) {
						throw new IllegalArgumentException("La superficie debe ser mayor a 0");
					}
					cultivo.setSuperficie(nuevaSuperficie);
				}

				// Editar parcela
				System.out.print("Código de parcela [" + cultivo.getCodigoParcela() + "]: ");
				String nuevoCodigoParcela = scanner.nextLine();
				if (!nuevoCodigoParcela.trim().isEmpty()) {
					cultivo.setCodigoParcela(nuevoCodigoParcela);
				}

				System.out.println("✅ Cultivo actualizado exitosamente.");
				return true;

			} catch (NumberFormatException e) {
				System.out.println("❌ Error: Debe ingresar un número válido");
				return false;
			} catch (IllegalArgumentException | IndexOutOfBoundsException e) {
				System.out.println("❌ Error: " + e.getMessage());
				return false;
			}
	}
}
