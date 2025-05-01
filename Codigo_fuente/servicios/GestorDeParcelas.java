package Codigo_fuente.servicios;

import java.util.ArrayList;
import java.util.List;

import Codigo_fuente.clases.Parcela;

public class GestorDeParcelas {
	
	List<Parcela> listaParcelas = new ArrayList<>();

	public List<Parcela> getListaParcelas() {
		return listaParcelas;
	}

	public void setListaParcelas(List<Parcela> listaParcelas) {
		this.listaParcelas = listaParcelas;
	}
    
}
//Aquí irá la lógica del programa (leer CSV, guardar datos, etc.