package cine;

import java.util.Scanner;

public class Cine {
    private static final int FILAS = 5;
    private static final int COLUMNAS = 6;
    private static char[][] asientos = new char[FILAS][COLUMNAS];
    private static String nombrePelicula = "Megalodon 2";

    public static void main(String[] args) {
        inicializarAsientos();
        mostrarMenu();
    }

    private static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\nMenu del Cine");
            System.out.println("1. Mostrar todos los asientos del cine");
            System.out.println("2. Modificar el nombre de la pelicula");
            System.out.println("3. Asignar un asiento");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    mostrarEstadoAsientos();
                    break;
                case 2:
                    modificarNombrePelicula(scanner);
                    break;
                case 3:
                    asignarAsiento(scanner);
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (true);
    }

    private static void inicializarAsientos() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                asientos[i][j] = 'L'; 
            }
        }
        asientos[1][2] = 'O';
        asientos[2][0] = 'O';
        asientos[3][2] = 'O';
        asientos[3][3] = 'O';
        asientos[3][4] = 'O';
        asientos[4][1] = 'O';
        asientos[4][2] = 'O';
        asientos[4][3] = 'O';
    }

    private static void mostrarEstadoAsientos() {
        System.out.println("\nEstado de los asientos del cine para la pelicula: " + nombrePelicula);
        System.out.println("   123456");
        System.out.println("  _______");
        for (int i = 0; i < FILAS; i++) {
            System.out.print((char) (65 + i) + " |");
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(" " + asientos[i][j]);
            }
            System.out.println();
        }
    }

    private static void modificarNombrePelicula(Scanner scanner) {
        System.out.print("Ingrese el nuevo nombre de la pelicula: ");
        scanner.nextLine();
        nombrePelicula = scanner.nextLine();
        System.out.println("Nombre de la pelicula modificado correctamente.");
    }

    private static void asignarAsiento(Scanner scanner) {
        System.out.println("Ingrese la fila y columna del asiento que desea asignar");
        String entrada = scanner.next().toUpperCase();
        char fila = entrada.charAt(0);
        int columna = Character.getNumericValue(entrada.charAt(1));

        if (fila < 'A' || fila >= 'A' + FILAS || columna < 1 || columna > COLUMNAS) {
            System.out.println("Asiento invalido");
            return;
        }

        int filaIndex = fila - 'A';
        int columnaIndex = columna - 1;

        if (asientos[filaIndex][columnaIndex] == 'O') {
            System.out.println("El asiento seleccionado ya esta ocupado");
        } else {
            asientos[filaIndex][columnaIndex] = 'O';
            System.out.println("Asiento asignado");
        }
    }
}
