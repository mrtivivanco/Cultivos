package controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelos.Actividad;
import modelos.Cultivo;
import modelos.Estado;
import modelos.Parcela;

public class ControladorCultivos {
	private List<Cultivo> listaCultivos = new ArrayList<>();
	private SimpleDateFormat sDF = new SimpleDateFormat("yyyy-MM-dd");

	private List<Actividad> obtenerActividades(String linea) {
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
			try {
				Date date = sDF.parse(partes[1]);
				Actividad actividad = new Actividad(nombre, date);
				listaActividades.add(actividad);

			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return listaActividades;

	}

	private Cultivo obtenerCultivo(String linea) throws ParseException {
		int index = linea.indexOf("[");

		String cul = linea.substring(0, index - 2);
		String[] arrAtributos = cul.split(",");

		for (int n = 0; n < arrAtributos.length; n++) {
			arrAtributos[n] = arrAtributos[n].replace("\"", "");

		}
		String nombre = arrAtributos[1];
		String variedad = arrAtributos[2];
		float superficie = Float.parseFloat(arrAtributos[3]);
		Date fecha = sDF.parse(arrAtributos[5]);
		Estado estado = new Estado(arrAtributos[6]);
		List<Actividad> la = obtenerActividades(linea);
		Parcela parcela = new Parcela(arrAtributos[4]);

		Cultivo cultivo = new Cultivo(nombre, variedad, superficie, fecha, estado, la, parcela);
		return cultivo;
	}

	public List<Cultivo> readFile(String file) throws Exception, IOException {
		List<Cultivo> cultivos = new ArrayList<Cultivo>();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String linea;
			boolean primeraLinea = false;

			while ((linea = br.readLine()) != null) {
				if (primeraLinea) {
					primeraLinea = false;
					continue;
				}

				Cultivo c = obtenerCultivo(linea);
				cultivos.add(c);

			}

		}
		return cultivos;
	}
	
	public static void main(String[] args) throws IOException, Exception {
		ControladorCultivos c =  new ControladorCultivos();
		List<Cultivo> list = c.readFile("kaka.csv");
		for(Cultivo cc: list) {
			System.out.println(cc);
		}
	}
}