package com.mycompany.simuladorpokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionarEntrenadores {

    private static List<Entrenador> listaDeEntrenadores = new ArrayList<>();
    public Scanner scanner;

    public GestionarEntrenadores(Scanner scanner) {
        this.listaDeEntrenadores = new ArrayList<>();
        this.scanner = scanner;
    }

    public void agregarEntrenador() {
        System.out.println("");
        System.out.print("Ingrese el nombre del nuevo entrenador: ");
        String nombre = scanner.nextLine();
        System.out.println("Se le agregaron Pokemones determinados, ir a gestion de entrenadores, para editarlo.");

        Entrenador nuevoEntrenador;
        nuevoEntrenador = new Entrenador1(nombre, scanner);

        listaDeEntrenadores.add(nuevoEntrenador);
        System.out.println("Entrenador " + nombre + " agregado.");
    }

    public void eliminarEntrenador() {
        System.out.print("Ingrese el indice del entrenador a eliminar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        if (indice >= 0 && indice < listaDeEntrenadores.size()) {
            listaDeEntrenadores.remove(indice);
            System.out.println("Entrenador eliminado.");
        } else {
            System.out.println("Indice no valido.");
        }
    }

    public void mostrarEntrenadores() {
        System.out.println("Entrenadores:");
        for (int i = 0; i < listaDeEntrenadores.size(); i++) {
            System.out.println(i + ". " + listaDeEntrenadores.get(i).getNombre());
        }
    }

    public void gestionar() {
        while (true) {
            System.out.println("");
            System.out.println("1. Agregar Entrenador");
            System.out.println("2. Eliminar Entrenador");
            System.out.println("3. Mostrar Entrenadores");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarEntrenador();
                    break;
                case 2:
                    eliminarEntrenador();
                    break;
                case 3:
                    mostrarEntrenadores();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }

    public List<Entrenador> getEntrenadores() {
        return listaDeEntrenadores; // Devuelve la lista de entrenadores
    }
}
