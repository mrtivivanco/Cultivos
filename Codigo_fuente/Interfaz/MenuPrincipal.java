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

    private void mostrarMenu() {
        System.out.println("\n=== MENÚ PRINCIPAL ===");
        System.out.println("1. Listar cultivos");
        System.out.println("2. Crear nuevo cultivo");
        System.out.println("3. Eliminar cultivo");
        System.out.println("4. Editar cultivo");
        System.out.println("5. Listar parcelas");
        System.out.println("6. Agregar parcela");
