package Codigo_fuente.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//La clase parcela representa una parcela agrícola en la que se pueden cultivar dicersos cultivos.
//Cada parcela está identificada por un código y posee una lista de cultivos asociados.
public class Parcela {
	//Código que ifentifica la parcela.
	//Valor por defecto "123"
	private String codigoParcela = "";
	//Lista de cultivos asociados a la parcela
	private List<Cultivo> listaCultivos = new ArrayList<>();
	
	//Constructor por defecto.
	public Parcela() {
	}

	//Constructor que permite inicializar la parcela con un código específico.
	public Parcela(String codigoParcela) {
		this.codigoParcela = codigoParcela;
	}

	//Agrega un cultivo a la lista de cultivos de la parcela.
	public void agregarCultivo(Cultivo c) {
		this.listaCultivos.add(c);
	}

	//Obtiene la lista de cultivos asociados a la parcela.
	public List<Cultivo> getListaCultivos() {
		return listaCultivos;
	}

	//Establece una nueva lisra de cultivos asociados a la parcela. 
	public void setListaCultivos(List<Cultivo> listaCultivos) {
		this.listaCultivos = listaCultivos;
	}

	//Devuelve el código identificador de la parcela 
	public String getCodigoParcela() {
		return codigoParcela;
	}

	//Establece un nuevo código identificador para la parcela. 
	public void setCodigoParcela(String nuevoCodigo) {
		this.codigoParcela = nuevoCodigo;
	}
	
	//Calcula el código hash de la parcela basado en su código. 
	@Override
	public int hashCode() {
		return Objects.hash(codigoParcela);
	}

	//Compara la parcela con otra para verificar si son iguales en base a su código. 
	//TRUE si los códigos son iguales, FALSE si no lo son. 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parcela other = (Parcela) obj;
		return Objects.equals(codigoParcela, other.codigoParcela);
	}

	//Método principal de la prueba. Crea una parcela, imprime su código, lo modifica e imprime el nuevo código. 
	public static void main(String[] args) {
		Parcela p = new Parcela("456");
		String valor = p.getCodigoParcela();
		System.out.println(valor);
		p.setCodigoParcela("789");
		valor = p.getCodigoParcela();
		System.out.println(valor);
	}
}
