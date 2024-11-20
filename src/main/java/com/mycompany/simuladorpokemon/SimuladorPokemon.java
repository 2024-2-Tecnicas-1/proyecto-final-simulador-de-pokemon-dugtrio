package com.mycompany.simuladorpokemon;

import com.mycompany.simuladorpokemon.Pokemones.Drowzee;
import com.mycompany.simuladorpokemon.Pokemones.Koffing;
import com.mycompany.simuladorpokemon.Pokemones.Magnemite;
import com.mycompany.simuladorpokemon.Pokemones.Mankey;
import com.mycompany.simuladorpokemon.Pokemones.Meowth;
import com.mycompany.simuladorpokemon.Pokemones.Oddish;
import com.mycompany.simuladorpokemon.Pokemones.Pikachu;
import com.mycompany.simuladorpokemon.Pokemones.Pokedex;
import com.mycompany.simuladorpokemon.Pokemones.Pokemon;
import com.mycompany.simuladorpokemon.Pokemones.Poliwag;
import com.mycompany.simuladorpokemon.Pokemones.Rhyhorn;
import com.mycompany.simuladorpokemon.Pokemones.Spearow;
import com.mycompany.simuladorpokemon.Pokemones.Vulpix;
import java.util.Scanner;

public class SimuladorPokemon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pokemon pikachu = new Pikachu();
        Pokemon vulpix = new Vulpix();
        Pokemon drowzee = new Drowzee();
        Pokemon koffing = new Koffing();
        Pokemon magnemite = new Magnemite();
        Pokemon mankey = new Mankey();
        Pokemon meowth = new Meowth();
        Pokemon oddish = new Oddish();
        Pokemon poliwag = new Poliwag();
        Pokemon rhyhorn = new Rhyhorn();
        Pokemon spearow = new Spearow();
        
        Pokedex pokedex = new Pokedex();
        Batalla batalla = new Batalla();

        System.out.println("Ingresa tu nombre: ");
        String nombre = scanner.next();
        Entrenador entrenador = new Entrenador(nombre);

        int primerOpcion = 0;
        do {
            System.out.println("Elige una opcion:");
            System.out.println("1. Seleccionar Pokemon y empezar batalla");
            System.out.println("2. Gestionar Entrenador");
            System.out.println("3. Gestionar Pokemones");
            System.out.println("4. Salir del Juego");
            primerOpcion = scanner.nextInt();
            switch (primerOpcion) {
                case 1:
                    // Selección de Pokémon y batalla       RAUL RESULVE
                    System.out.println("Elige el Pokémon que deseas utilizar: ");
                    entrenador.mostrarPokemones();
                    Pokemon[] eleccionPokemon = new Pokemon[2];

                    for (int i = 0; i < 2; i++) {
                        System.out.print("Elige tu Pokémon 1: ");
                        int eleccion = scanner.nextInt();

                        switch (eleccion) {
                            case 1:
                                eleccionPokemon[i] = pikachu;
                                System.out.println("Has elegido Pikachu");
                                break;
                            case 2:
                                eleccionPokemon[i] = vulpix;
                                System.out.println("Has elegido Vulpix");
                                break;
                            default:
                                System.out.println("Elección no válida, intenta de nuevo.");
                                i--;
                                break;
                        }
                    }

                    Pokemon ganador = batalla.iniciarBatalla(eleccionPokemon[0], eleccionPokemon[1]);
                    System.out.println("GANADOR: " + ganador.getNombre());
                    scanner.nextInt();
                    break;
                case 2:
                    // Clase entrenador
                    System.out.println("Gestión de entrenador...");

                    int opcion;
                    do {
                        System.out.println(" Simulador Pokémon");
                        System.out.println("");
                        System.out.println("1. Mostrar equipo");
                        System.out.println("2. Agregar Pokémon al equipo");
                        System.out.println("3. Reemplazar un Pokémon del equipo");
                        System.out.println("4. Eliminar un Pokémon del equipo");
                        System.out.println("5. Salir");
                        System.out.print("Elige una opción: ");
                        opcion = scanner.nextInt();

                        switch (opcion) {
                            case 1: // Mostrar el equipo
                                entrenador.mostrarPokemones();
                                break;

                            case 2: // Agregar un Pokémon
                                // System.out.println("Elige un Pokémon para agregar:");
                                // entrenador.mostrarPokemones();
                                //int eleccionAgregar = scanner.nextInt();
                                // System.out.println("Elija el Pokemon que desea");
                                // Pokemon nuevoPokemon = entrenador.reemplazarPokemon(int indice, int eleccionAgregar)
                                // if (nuevoPokemon != null) {
                                //     entrenador.agregarPokemon(nuevoPokemon);

                                //}
                                break;

                            case 3: // Reemplazar un Pokémon
                                System.out.println("Elige el Pokémon que deseas reemplazar:");
                                entrenador.mostrarPokemones();
                                int indiceReemplazo = scanner.nextInt() - 1;
                                System.out.println("Elige el Pokemon que desees agregar:");
                                pokedex.mostrarTodosLosPokemones();
                                int eleccionReemplazo = scanner.nextInt();
                                // Pokemon pokemonReemplazo = seleccionarPokemon(eleccionReemplazo);
                                //if (pokemonReemplazo != null) {
                                //    entrenador.reemplazarPokemon(indiceReemplazo, pokemonReemplazo);
                                // }
                                break;

                            case 4: // Eliminar un Pokémon
                                System.out.println("Elige la posición (1-6) del Pokémon que deseas eliminar:");
                                entrenador.mostrarPokemones();
                                int indiceEliminar = scanner.nextInt() - 1;
                                entrenador.eliminarPokemon(indiceEliminar);
                                break;

                            case 5: // Salir
                                System.out.println("¡Gracias por jugar!");
                                break;
                            default:
                                System.out.println("Opción no válida. Inténtalo de nuevo.");
                                break;

                        }
                    } while (opcion != 5);

                    break;
                case 3:
                    // Clase Pokemones
                    System.out.println("Gestión de opciones en desarrollo...");
                    break;
                case 4:
                    System.out.println("¡Gracias por jugar!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (primerOpcion != 4);

    }
}
