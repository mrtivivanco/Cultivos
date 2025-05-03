package Codigo_fuente.servicios;

import Codigo_fuente.clases.Parcela;
import Codigo_fuente.clases.Cultivo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Esta clase se encargará de gestionar las parcelas
public class GestorDeParcelas {

	//Creamos una lista que almacenará las parcelas creadas
	private List<Parcela> listaParcelas;

	//Constructor: se ejecuta al crear un objeto de tipo GestorDeParcelas
	public GestorDeParcelas() {
	        listaParcelas = new ArrayList<>(); //Inicializamos la lista vacía
	}

	// Método para agregar parcela
        public boolean agregarParcela(Scanner scanner) {
        System.out.println("\n=== Agregar Nueva Parcela ===");
        System.out.print("Ingrese código de parcela: ");
        String codigo = scanner.nextLine();
        
        if(buscarParcela(codigo) != null) {
            System.out.println("¡Esta parcela ya existe!");
            return false;
        }
        
        Parcela nueva = new Parcela(codigo);
        listaParcelas.add(nueva);
        return true;
    }
	
        // Método para buscar parcela
        public Parcela buscarParcela(String codigo) {
            for(Parcela p : listaParcelas) {
                if(p.getCodigoParcela().equalsIgnoreCase(codigo)) {
                    return p;
                }
            }
            return null;
        }
	
        // Método para listar parcelas
        public void listarParcelas() {
            if(listaParcelas.isEmpty()) {
                System.out.println("\nNo hay parcelas registradas");
                return;
            }

        System.out.println("\n=== Listado de Parcelas ===");
        for(Parcela p : listaParcelas) {
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
    
}
