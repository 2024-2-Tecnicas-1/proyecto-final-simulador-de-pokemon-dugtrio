package com.mycompany.simuladorpokemon;

import com.mycompany.simuladorpokemon.Batalla;
import com.mycompany.simuladorpokemon.Entrenador;
import com.mycompany.simuladorpokemon.Pokemones.Pokedex;
import com.mycompany.simuladorpokemon.Pokemones.Pokemon;

import java.util.Scanner;

public class SimuladorPokemon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Crear la Pokedex
        Pokedex pokedex = new Pokedex();
        Batalla batalla = new Batalla();

        // Entrenador 1
        System.out.println("Ingresa el nombre del primer entrenador: ");
        String nombre1 = scanner.next();
        Entrenador entrenador1 = new Entrenador(nombre1);

        // Entrenador 2
        System.out.println("Ingresa el nombre del segundo entrenador: ");
        String nombre2 = scanner.next();
        Entrenador entrenador2 = new Entrenador(nombre2);

        int primerOpcion = 0;
        do {
            System.out.println("Elige una opcion:");
            System.out.println("1. Seleccionar Pokémon y empezar batalla");
            System.out.println("2. Gestionar Entrenador 1");
            System.out.println("3. Gestionar Entrenador 2");
            System.out.println("4. Salir del Juego");
            primerOpcion = scanner.nextInt();
            switch (primerOpcion) {
                case 1:
                    // Selección de Pokémon y batalla
                    System.out.println("Entrenador 1, elige el Pokémon que deseas utilizar: ");
                    pokedex.mostrarTodosLosPokemones(); // Mostrar todos los Pokémon disponibles

                    Pokemon pokemon1 = seleccionarPokemon(scanner, pokedex);

                    System.out.println("Entrenador 2, elige el Pokémon que deseas utilizar: ");
                    pokedex.mostrarTodosLosPokemones(); // Mostrar todos los Pokémon disponibles

                    Pokemon pokemon2 = seleccionarPokemon(scanner, pokedex);

                    Pokemon ganador = batalla.iniciarBatalla(pokemon1, pokemon2);
                    System.out.println("GANADOR: " + ganador.getNombre());
                    scanner.nextInt();
                    break;
                case 2:
                    // Gestión de entrenador 1
                    System.out.println("Gestión de " + entrenador1.getNombre() + "...");
                    // Aquí puedes implementar la gestión del entrenador como en tu código original
                    break;
                case 3:
                    // Gestión de entrenador 2
                    System.out.println("Gestión de " + entrenador2.getNombre() + "...");
                    // Aquí puedes implementar la gestión del entrenador como en tu código original
                    break;
                case 4:
                    System.out.println("¡Gracias por jugar!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (primerOpcion != 4);
    }

    private static Pokemon seleccionarPokemon(Scanner scanner, Pokedex pokedex) {
        Pokemon pokemon;
        int eleccion;
        do {
            System.out.print("Elige tu Pokémon: ");
            eleccion = scanner.nextInt();

            if (eleccion > 0 && eleccion <= pokedex.getPokemones().size()) {
                pokemon = pokedex.getPokemones().get(eleccion - 1);
                System.out.println("Has elegido " + pokemon.getNombre());
                return pokemon;
            } else {
                System.out.println("Elección no válida, intenta de nuevo.");
            }
        } while (true);
    }
}
