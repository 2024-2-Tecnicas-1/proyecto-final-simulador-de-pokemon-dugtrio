package com.mycompany.simuladorpokemon;

import com.mycompany.simuladorpokemon.Pokemones.Pokedex;
import com.mycompany.simuladorpokemon.Pokemones.Pokemon;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SimuladorPokemon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pokedex pokedex = new Pokedex();

        // Mostrar Pokémon disponibles
        mostrarPokemonesDisponibles(pokedex);

        // Crear entrenadores
        GestionarEntrenadores gestionarEntrenadores = new GestionarEntrenadores(scanner);
        gestionarEntrenadores.gestionar();

        // Menú principal
        int opcion;
        do {
            opcion = mostrarMenu(scanner);
            procesarOpcion(opcion, scanner, gestionarEntrenadores);
        } while (opcion != 4);

        scanner.close(); // Cerrar el scanner al final
    }

    private static void mostrarPokemonesDisponibles(Pokedex pokedex) {
        System.out.println("Pokemon disponibles:");
        for (Pokemon pokemon : pokedex.getTodosLosPokemones()) {
            System.out.println(pokemon.getNombre());
        }
    }

    private static int mostrarMenu(Scanner scanner) {
        int opcion = -1; // Inicializar con un valor no válido
        while (opcion < 1 || opcion > 4) {
            System.out.println("Elige una opcion:");
            System.out.println("1. Iniciar Batalla");
            System.out.println("2. Gestionar Entrenadores");
            System.out.println("3. Gestionar Pokemones");
            System.out.println("4. Salir del Juego");
            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un numero valido.");
                scanner.nextLine(); 
            }
        }
        return opcion;
    }

    private static void procesarOpcion(int opcion, Scanner scanner, GestionarEntrenadores gestionarEntrenadores) {
        switch (opcion) {
            case 1:
                iniciarBatalla(scanner, gestionarEntrenadores);
                break;
            case 2:
                gestionarEntrenadores.gestionar();
                break;
            case 3:
                // Asumiendo que tienes un entrenador seleccionado
                List<Entrenador> entrenadores = gestionarEntrenadores.getEntrenadores();
                if (entrenadores.isEmpty()) {
                    System.out.println("No hay entrenadores disponibles para gestionar Pokemon.");
                    break;
                }
                // Puedes elegir el primer entrenador para la gestión de Pokémon o permitir al usuario seleccionar uno
                Entrenador entrenador = entrenadores.get(0); // O el que desees
                GestionarPokemones gestionarPokemones = new GestionarPokemones(scanner, entrenador);
                gestionarPokemones.gestionar();
                break;
            case 4:
                System.out.println("¡Gracias por jugar!");
                break;
            default:
                System.out.println("Opcion no valida.");
        }
    }

    private static void iniciarBatalla(Scanner scanner, GestionarEntrenadores gestionarEntrenadores) {
        List<Entrenador> entrenadores = gestionarEntrenadores.getEntrenadores();

        if (entrenadores.size() < 2) {
            System.out.println("No hay suficientes entrenadores para iniciar una batalla.");
            return;
        }

        for (Entrenador entrenador : entrenadores) {
            if (entrenador.getPokemones().isEmpty()) {
                System.out.println(entrenador.getNombre() + " no tiene Pokémon para luchar.");
                return;
            }
        }

        // Elegir Pokémon de los entrenadores
        Pokemon pokemon1 = elegirPokemonEntrenador(scanner, entrenadores.get(0));
        Pokemon pokemon2 = elegirPokemonEntrenador(scanner, entrenadores.get(1));

        Batalla batalla = new Batalla();
        Pokemon ganador = batalla.iniciarBatalla(pokemon1, pokemon2);
        System.out.println("GANADOR: " + ganador.getNombre());
        scanner.nextLine(); // Esperar a que el usuario presione una tecla
    }

    private static Pokemon elegirPokemonEntrenador(Scanner scanner, Entrenador entrenador) {
        System.out.println(entrenador.getNombre() + ", elige tu Pokemon:");
        List<Pokemon> equipo = entrenador.getPokemones(); 

        for (int i = 0; i < equipo.size(); i++) {
            System.out.println((i + 1) + ". " + equipo.get(i).getNombre());
        }

            int seleccion = -1;
        while (seleccion < 1 || seleccion > equipo.size()) {
            try {
                System.out.print("Selecciona un numero: ");
                seleccion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un numero valido.");
                scanner.nextLine();
            }
        }

        return equipo.get(seleccion - 1); // Retorna el Pokémon seleccionado
    }
}