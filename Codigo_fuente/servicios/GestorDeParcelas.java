package Codigo_fuente.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Codigo_fuente.clases.Cultivo;
import Codigo_fuente.clases.Parcela;

//Esta clase se encargará de gestionar las parcelas
public class GestorDeParcelas {
	private Scanner scanner;
	// Creamos una lista que almacenará las parcelas creadas
	private List<Parcela> listaParcelas;

	private GestorDeCultivos gestorDeCultivos;

	// Constructor: se ejecuta al crear un objeto de tipo GestorDeParcelas
	public GestorDeParcelas(GestorDeCultivos gestor, Scanner scanner) {
		this.scanner = scanner;
		listaParcelas = new ArrayList<>(); // Inicializamos la lista vacía
		gestorDeCultivos = gestor;

		generarParcelasDesdeCultivos();
	}

	private void generarParcelasDesdeCultivos() {
		List<Cultivo> lista = gestorDeCultivos.getListaCultivos();
		for (Cultivo c : lista) {
			Parcela p = new Parcela(c.getCodigoParcela());
			int index = listaParcelas.indexOf(p);
			if (index != -1) {
				p = listaParcelas.get(index);
			} else {
				listaParcelas.add(p);
			}
			p.agregarCultivo(c);

		}
	}

	// Método para agregar parcela
	public boolean agregarParcela() {
		System.out.println("\n=== Agregar Nueva Parcela ===");
		System.out.print("Ingrese código de parcela: ");
		String codigo = scanner.nextLine();

		if (buscarParcela(codigo) != null) {
			System.out.println("¡Esta parcela ya existe!");
			return false;
		}

		Parcela nueva = new Parcela(codigo);
		listaParcelas.add(nueva);
		return true;
	}

	/**
	 * Este método permite seleccionar el índice de la parcela a eliminar.
	 * 
	 * Se encarga de eliminar cada uno de los cultivos asociados a la parcela.
	 * 
	 * @return Verdadero cuando la eliminación es exitosa.
	 */
	public boolean eliminarParcela() {
		if (listaParcelas.isEmpty()) {
			System.out.println("No hay parcelas para eliminar.");
			return false;
		}

		listarParcelas();
		System.out.print("\nIngrese el número de la parcela a eliminar: ");

		try {
			int index = Integer.parseInt(scanner.nextLine()) - 1;

			if (index < 0 || index >= listaParcelas.size()) {
				throw new IndexOutOfBoundsException("Número de parcela inválido");
			}

			Parcela aEliminar = listaParcelas.get(index);
			System.out.print("¿Está seguro de eliminar la parcela " + aEliminar.getCodigoParcela() + "? (S/N): ");
			String confirmacion = scanner.nextLine();

			if (confirmacion.equalsIgnoreCase("S")) {
				// Primero se eliminan los cultivos de la parcela
				while (!aEliminar.getListaCultivos().isEmpty()) {
					gestorDeCultivos.eliminarCultivo(aEliminar.getListaCultivos().get(0));
				}
				listaParcelas.remove(index);
				System.out.println("✅ Parcela eliminada exitosamente.");
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

	public boolean editarParcela() {
		if (listaParcelas.isEmpty()) {
			System.out.println("No hay parcelas para editar.");
			return false;
		}

		listarParcelas();
		System.out.print("\nIngrese el número de la parcela a editar: ");

		try {
			int index = Integer.parseInt(scanner.nextLine()) - 1;

			if (index < 0 || index >= listaParcelas.size()) {
				throw new IndexOutOfBoundsException("Número de parcela inválido");
			}

			Parcela aEditar = listaParcelas.get(index);
			System.out.println("\n=== MENÚ EDICIÓN PARCELA ===");
			System.out.println("1. Agregar cultivo");
			System.out.println("2. Eliminar cultivo");
			System.out.println("3. Editar cultivo");
			System.out.println("4. Salir");
			index = Integer.parseInt(scanner.nextLine());
			if (index == 1) {
				this.agregarCultivo(aEditar);
			} else if (index == 2) {
				eliminarCultivo(aEditar);
			} else if (index == 3) {
				editarCultivo(aEditar);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// Método para buscar parcela
	public Parcela buscarParcela(String codigo) {
		for (Parcela p : listaParcelas) {
			if (p.getCodigoParcela().equalsIgnoreCase(codigo)) {
				return p;
			}
		}
		return null;
	}

	// Método para listar parcelas
	public void listarParcelas() {
		if (listaParcelas.isEmpty()) {
			System.out.println("\nNo hay parcelas registradas");
			return;
		}

		System.out.println("\n=== Listado de Parcelas ===");
		for (Parcela p : listaParcelas) {
			System.out.println("Parcela: " + p.getCodigoParcela());
			System.out.println("Cultivos asociados: " + p.getListaCultivos().size());
			System.out.println("----------------------");
		}
	}

	// Getters y Setters
	public List<Parcela> getListaParcelas() {
		return listaParcelas;
	}

	public void setListaParcelas(List<Parcela> listaParcelas) {
		this.listaParcelas = listaParcelas;
	}

	// Método para agregar un nuevo cultivo a la lista
	private void agregarCultivo(Parcela parcela) {
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

			// Creamos el objeto Cultivo con los datos ingresados
			Cultivo nuevoCultivo = new Cultivo(nombre, fecha, estado, variedad, superficie, parcela.getCodigoParcela());

			// Lo agregamos a la lista de cultivos de la parcela
			parcela.getListaCultivos().add(nuevoCultivo);
			// Lo agregamos a la lista de cultivos del gestor de cultivos
			gestorDeCultivos.agregarCultivo(nuevoCultivo);

			System.out.println("✅ Cultivo agregado exitosamente.\n");
	}

	// Método para eliminar un cultivo
	private boolean eliminarCultivo(Parcela parcela) {
		List<Cultivo> listaCultivos = parcela.getListaCultivos();

			if (listaCultivos.isEmpty()) {
				System.out.println("No hay cultivos para eliminar.");
				return false;
			}

			listarCultivos(parcela);
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
					// Se elimina de la lista de cultivos de la parcela
					listaCultivos.remove(index);
					// Se elimina de la lista de cultivos del ge
					gestorDeCultivos.eliminarCultivo(aEliminar);
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
	public boolean editarCultivo(Parcela parcela) {
		List<Cultivo> listaCultivos = parcela.getListaCultivos();
			if (listaCultivos.isEmpty()) {
				System.out.println("No hay cultivos para editar.");
				return false;
			}

			listarCultivos(parcela);
			System.out.print("\nIngrese el número del cultivo a editar: ");

			try {
				int index = Integer.parseInt(scanner.nextLine()) - 1;

				if (index < 0 || index >= listaCultivos.size()) {
					throw new IndexOutOfBoundsException("Número de cultivo inválido");
				}

				/*
				 * Al hacer cambio en la variable cultivo se cambia tanto en la lista de la
				 * parcela como en la lista del gestor de parcelas.
				 * 
				 * Porque la variable cultivo apunta al único objeto Cultivo que está en la
				 * posición index.
				 */
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

				/*
				 * Esto es redundante, ya se explicó más arriba por qué!!
				 */
				listaCultivos.set(index, cultivo);
				this.gestorDeCultivos.modificarCultivo(cultivo);

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

	// Método para mostrar todos los cultivos almacenados
	public void listarCultivos(Parcela parcela) {
		List<Cultivo> listaCultivos = parcela.getListaCultivos();
		System.out.println("\n=== Lista de Cultivos Registrados para la Parcelas ===");

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

}
