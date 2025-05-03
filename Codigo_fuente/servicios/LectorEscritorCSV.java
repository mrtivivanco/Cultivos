// Indicamos que esta clase está en el paquete "servicios"
package Codigo_fuente.servicios;

import java.io.File;
// Importamos clases de Java necesarias para leer y escribir archivos
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Codigo_fuente.clases.Actividad;
// Importamos la clase Cultivo para poder crear objetos Cultivo
import Codigo_fuente.clases.Cultivo;

// Esta clase se encarga de manejar archivos CSV
public class LectorEscritorCSV {
	static DecimalFormat formato = new DecimalFormat("#.0#");
	// Método que guarda todos los cultivos en un archivo CSV
	// Recibe la lista de cultivos y el nombre del archivo
	public static void guardarCultivosEnCSV(List<Cultivo> lista, String nombreArchivo) {
		try {
			// Creamos o reemplazamos el archivo con FileWriter
			FileWriter escritor = new FileWriter(nombreArchivo);

			// Recorremos cada cultivo en la lista
			for (Cultivo cultivo : lista) {
				// Formateamos cada línea con los datos del cultivo

				// Se va a construir el string de la lista de actividades
				String actividades = "[";
				List<Actividad> lst = cultivo.getListaActividades();

				for (Actividad a : lst) {
					String n = String.format("\"%s:%s\"", a.getNombre(), a.getFecha());
					if (!actividades.equals("[")) {
						actividades = actividades + ",";
					}
					actividades = actividades + n;
				}
				actividades = actividades + "]";
				
				// Se formatea la línea asociado al cultivo
				String linea = String.format("Cultivo,\"%s\",\"%s\",%s,\"%s\",\"%s\",\"%s\",%s\n", cultivo.getNombre(),
						cultivo.getVariedad(), formato.format(cultivo.getSuperficie()), cultivo.getCodigoParcela(),
						cultivo.getFecha(), cultivo.getEstado(), actividades

				);

				// Escribimos la línea en el archivo
				escritor.write(linea);
			}

			// Cerramos el archivo al terminar
			escritor.close();

			// Mensaje de éxito
			System.out.println("✅ Cultivos guardados correctamente en " + nombreArchivo);

		} catch (IOException e) {
			// Si ocurre un error al guardar, mostramos un mensaje
			e.printStackTrace();
			System.out.println("❌ Error al guardar los cultivos: " + e.getMessage());
		}
	}


	/**
	 * Permite obtener la lista de actividades que vienen en linea
	 * @param linea es la línea leida desde el archivo 
	 * @return una lista de actividades 
	 */
	private static List<Actividad> obtenerActividades(String linea) {
		int index = linea.indexOf("[");
		List<Actividad> listaActividades = new ArrayList<>();

		if (index == -1) {
			return listaActividades;
		}
		int l = linea.length();
		String actividades = linea.substring(index + 1, l - 1);
		String[] arrActividades = actividades.split(",");

		for (String s : arrActividades) {
			String a = s.replace("\"", "");
			String[] partes = a.split(":");
			String nombre = partes[0];
			Actividad actividad = new Actividad(nombre, partes[1], "P");
			listaActividades.add(actividad);

		}
		return listaActividades;

	}

	// Método que lee cultivos desde un archivo CSV
	// y los agrega a la lista proporcionada
	public static List<Cultivo> leerCultivosDesdeCSV(String nombreArchivo) {
		List<Cultivo> lista = new ArrayList<>();

		try {
			// Abrimos el archivo usando Scanner
			Scanner lector = new Scanner(new File(nombreArchivo));

			// Mientras haya líneas en el archivo
			while (lector.hasNextLine()) {
				// Leemos una línea
				String linea = lector.nextLine();

				// Solo procesamos si comienza con "Cultivo,"
				if (linea.startsWith("Cultivo,")) {
					// Quitamos "Cultivo," del inicio
					linea = linea.substring(8);

					// Dividimos la línea en partes, quitando comillas y corchetes
					String[] partes = linea.split("\",\"|\",|,\"|,\\[|\\]");

					// Obtenemos cada dato (limpio) desde el arreglo
					String nombre = partes[0].replace("\"", "");
					String variedad = partes[1].replace("\"", "");
					double superficie = Double.parseDouble(partes[2]);
					String codigoParcela = partes[3].replace("\"", "");
					String fecha = partes[4].replace("\"", "");
					String estado = partes[5].replace("\"", "");

					// Creamos un objeto Cultivo con esos datos
					Cultivo cultivo = new Cultivo(nombre, fecha, estado, variedad, superficie, codigoParcela);

					List<Actividad> l = obtenerActividades(linea);
					cultivo.setListaActividades(l);
					// Lo agregamos a la lista
					lista.add(cultivo);
					
				}

			}

			// Cerramos el lector del archivo
			lector.close();

			// Mensaje de éxito
			System.out.println("✅ Cultivos cargados desde el archivo " + nombreArchivo);

		} catch (Exception e) {
			// Si ocurre algún error al leer el archivo, lo informamos
			System.out.println("❌ Error al leer el archivo CSV: " + e.getMessage());
		}
		return lista;
	}
}
