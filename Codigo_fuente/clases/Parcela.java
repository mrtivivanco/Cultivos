package Codigo_fuente.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//La clase parcela repreenta una parcela agrícola donde se cultivan los cultivos. 
public class Parcela {
	//Código que ifentifica la parcela. Valor por defecto "123"
	private String codigoParcela = "123";
	//Lista de cultivos de la parcela
	private List<Cultivo> listaCultivos = new ArrayList<>();
	
	
	public Parcela() {
	}
	
	public Parcela(String codigoParcela) {
		this.codigoParcela = codigoParcela;
	}
	public void agregarCultivo(Cultivo c) {
		this.listaCultivos.add(c);
	}

	public List<Cultivo> getListaCultivos() {
		return listaCultivos;
	}

	public void setListaCultivos(List<Cultivo> listaCultivos) {
		this.listaCultivos = listaCultivos;
	}

	public String getCodigoParcela() {
		return codigoParcela;
	}
	
	public void setCodigoParcela(String nuevoCodigo) {
		this.codigoParcela = nuevoCodigo;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigoParcela);
	}

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

	public static void main(String[] args) {
		Parcela p = new Parcela("456");
		String valor = p.getCodigoParcela();
		System.out.println(valor);
		p.setCodigoParcela("789");
		valor = p.getCodigoParcela();
		System.out.println(valor);
	}
}
