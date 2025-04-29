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
