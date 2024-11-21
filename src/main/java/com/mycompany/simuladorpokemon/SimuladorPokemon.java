package com.mycompany.simuladorpokemon;

import com.mycompany.simuladorpokemon.Pokemones.*;
import java.util.List;
import java.util.Scanner;

public class SimuladorPokemon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pokedex pokedex = new Pokedex();

        // Mostrar Pokémon disponibles
        mostrarPokemonesDisponibles(pokedex);

        // Entrenador 1
        System.out.println("Ingresa el nombre del primer entrenador: ");
        String nombre1 = scanner.next();
        Entrenador1 entrenador1 = new Entrenador1(nombre1); // Asumiendo que esta clase tiene sus Pokémon definidos

        List<Pokemon> equipo1 = entrenador1.getPokemones(); // Obtener el equipo del Entrenador 1

        // Entrenador 2
        System.out.println("Ingresa el nombre del segundo entrenador: ");
        String nombre2 = scanner.next();
        Entrenador2 entrenador2 = new Entrenador2(nombre2); // Asumiendo que esta clase tiene sus Pokémon definidos

        List<Pokemon> equipo2 = entrenador2.getPokemones(); // Obtener el equipo del Entrenador 2

        // Mostrar equipos iniciales
        System.out.println("Equipo de " + nombre1 + ":");
        for (Pokemon pokemon : equipo1) {
            System.out.println(pokemon.getNombre()); // Mostrar Pokémon del Entrenador 1
        }

        System.out.println("Equipo de " + nombre2 + ":");
        for (Pokemon pokemon : equipo2) {
            System.out.println(pokemon.getNombre()); // Mostrar Pokémon del Entrenador 2
        }

        int primerOpcion = 0;
        do {
            System.out.println("Elige una opcion:");
            System.out.println("1. Iniciar Batalla");
            System.out.println("2. Gestionar Entrenadores");
            System.out.println("3. Gestionar Pokemones");
            System.out.println("4. Salir del Juego");
            primerOpcion = scanner.nextInt();
            switch (primerOpcion) {
                case 1:
                    // Elegir Pokémon del Entrenador 1
                    Pokemon pokemon1 = elegirPokemonEntrenador(scanner, equipo1, nombre1);
                    // Elegir Pokémon del Entrenador 2
                    Pokemon pokemon2 = elegirPokemonEntrenador(scanner, equipo2, nombre2);

                    Batalla batalla = new Batalla();
                    Pokemon ganador = batalla.iniciarBatalla(pokemon1, pokemon2);
                    System.out.println("GANADOR: " + ganador.getNombre());
                    scanner.nextInt(); // Esperar a que el usuario presione una tecla
                    break;
                case 2:
                    gestionarEntrenador(scanner, entrenador1);
                    break;
                case 3:
                    gestionarEntrenador(scanner, entrenador2);
                    break;
                case 4:
                    System.out.println("¡Gracias por jugar!");
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        } while (primerOpcion != 4);
    }

    private static void mostrarPokemonesDisponibles(Pokedex pokedex) {
        System.out.println("Pokemon disponibles:");
        for (Pokemon pokemon : pokedex.getTodosLosPokemones()) { // Asumiendo que tienes un método que devuelve todos los Pokémon
            System.out.println(pokemon.getNombre()); // Mostrar solo el nombre
        }
    }

    private static Pokemon elegirPokemonEntrenador(Scanner scanner, List<Pokemon> equipo, String nombreEntrenador) {
        System.out.println(nombreEntrenador + ", elige tu Pokemon:");
        for (int i = 0; i < equipo.size(); i++) {
            System.out.println((i + 1) + ". " + equipo.get(i).getNombre());
        }
        int eleccion;
        while (true) {
            System.out.print("Elige tu Pokemon (1-" + equipo.size() + "): ");
            try {
                eleccion = scanner.nextInt();
                if (eleccion > 0 && eleccion <= equipo.size()) {
                    return equipo.get(eleccion - 1);
                } else {
                    System.out.println("Eleccien no valida, intenta de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Entrada no valida. Por favor, ingresa un numero.");
                scanner.next(); // Limpiar la entrada no válida
            }
        }
    }

    private static void gestionarEntrenador(Scanner scanner, Entrenador entrenador) {
        System.out.println("Gestión de " + entrenador.getNombre() + "...");
    }
}