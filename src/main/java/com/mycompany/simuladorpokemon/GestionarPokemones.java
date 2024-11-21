package com.mycompany.simuladorpokemon;

import com.mycompany.simuladorpokemon.Pokemones.Pokedex;
import com.mycompany.simuladorpokemon.Pokemones.Pokemon;

import java.util.Scanner;

public class GestionarPokemones {
    private Scanner scanner;
    private Entrenador entrenador;

    public GestionarPokemones(Scanner scanner, Entrenador entrenador) {
        this.scanner = scanner;
        this.entrenador = entrenador;
    }

    public void gestionar() {
        System.out.println("Gestion de Pokemon para " + entrenador.getNombre());
        System.out.println("1. Agregar Pokemon");
        System.out.println("2. Ver Pokemon");
        System.out.println("3. Salir");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        switch (opcion) {
            case 1:
                agregarPokemon();
                break;
            case 2:
                verPokemones();
                break;
            case 3:
                System.out.println("Saliendo de la gestion de Pokemon.");
                break;
            default:
                System.out.println("Opción no valida.");
        }
    }

    private void agregarPokemon() {
        Pokedex pokedex = new Pokedex();
        System.out.println("Pokemon disponibles para agregar:");
        for (Pokemon pokemon : pokedex.getTodosLosPokemones()) {
            System.out.println(pokemon.getNombre());
        }

        System.out.print("Ingrese el nombre del Pokemon a agregar: ");
        String nombrePokemon = scanner.nextLine();
        Pokemon pokemon = pokedex.buscarPokemon(nombrePokemon);
        if (pokemon != null) {
            entrenador.agregarPokemon(pokemon);
            System.out.println("Pokemon " + nombrePokemon + " agregado a " + entrenador.getNombre());
        } else {
            System.out.println("Pokemon no encontrado.");
        }
    }

    private void verPokemones() {
        System.out.println("Pokemon de " + entrenador.getNombre() + ":");
        for (Pokemon pokemon : entrenador.getPokemones()) {
            System.out.println(pokemon.getNombre());
        }
    }
}