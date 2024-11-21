package com.mycompany.simuladorpokemon;

import com.mycompany.simuladorpokemon.Pokemones.*;
import com.mycompany.simuladorpokemon.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import java.util.Scanner;

public class SimuladorPokemon {

    public static Scanner scanner = new Scanner(System.in);
    public static Pokedex pokedex = new Pokedex();
    public static GestionarEntrenadores gestionarEntrenadores = new GestionarEntrenadores(scanner);
    


    public static void main(String[] args) {

        System.out.println("Al ingresar al juego se le recomienda crear minimo 2 entrenadores primero, por ello: ");
        System.out.println("");

        gestionarEntrenadores.gestionar();

        int primerOpcion = 0;
        do {
            System.out.println("");
            System.out.println("Elige una opcion:");
            System.out.println("1. Iniciar Batalla");
            System.out.println("2. Gestionar Entrenadores");
            System.out.println("3. Gestionar Pokemones");
            System.out.println("4. Salir del Juego");
            primerOpcion = scanner.nextInt();
            switch (primerOpcion) {
                case 1:
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
                    break;
                case 2:
                    // Gestion entrenar
                    menuGestionarEntrenadores();
                    break;
                case 3:
                    int opcionGestionarPokemones;
                    System.out.println("");
                    System.out.println("Bienvenido a Gestionae Pokemones.");
                    do {
                        System.out.println("Elige una opcion:");
                        System.out.println("");
                        System.out.println("1. Ver todos los Pokémones registrados:");
                        System.out.println("2. Registrar nuevo Pokémon");
                        System.out.println("3. Volver al menú principal");
                        opcionGestionarPokemones = scanner.nextInt();
                        switch (opcionGestionarPokemones) {
                            case 1:
                                pokedex.mostrarTodosLosPokemones();
                                break;
                            case 2:
                                System.out.println("");
                                System.out.println("Ingresa el nombre del Pokémon:");
                                String nombre = scanner.next();
                                System.out.println("Ingresa la salud del Pokémon " + nombre + ":");
                                int salud = scanner.nextInt();
                                System.out.println("Ingresa el ataque del Pokémon " + nombre + ":");
                                double ataque = scanner.nextDouble();
                                System.out.println("Elige el tipo del Pokémon:");
                                int indice = 1;
                                for (TipoPokemon tipo : TipoPokemon.values()) {
                                    System.out.println(indice + ". " + tipo);
                                    indice++;
                                }
                                int numeroTipo = scanner.nextInt();
                                if (numeroTipo >= 1 && numeroTipo <= TipoPokemon.values().length) {
                                    TipoPokemon tipoSeleccionado = TipoPokemon.values()[numeroTipo - 1];

                                    // Crea y agrega el nuevo Pokémon a la Pokedex
                                    Pokemon nuevoPokemon = new PokemonVacio(nombre, salud, ataque, tipoSeleccionado);
                                    pokedex.agregarPokemones(nuevoPokemon);

                                    System.out.println("¡Se ha añadido el nuevo Pokémon: " + nombre + " (Tipo: " + tipoSeleccionado + ") a la Pokedex!");
                                } else {
                                    System.out.println("Opción no válida. Elige un número entre 1 y " + TipoPokemon.values().length);
                                }

                                break;
                            case 3:
                                System.out.println("Saliendo de Gestionar Pokemones...");
                                System.out.println("");
                                break;
                            default:
                                System.out.println("Opcion invalida intentelo de nuevo.");
                        }
                    } while (opcionGestionarPokemones != 3);
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

    private static void menuGestionarEntrenadores() {
        int opcionGestionarEntrenador = 0;
        do {
            System.out.println("Bienvenido a Gestionar Entrenadores:");
            System.out.println("1. Registrar nuevo entrenador");
            System.out.println("2. Ver lista de entrenadores");
            System.out.println("3. Seleccionar un entrenador");
            System.out.println("4. Volver al menú principal");
            opcionGestionarEntrenador = scanner.nextInt();

            switch (opcionGestionarEntrenador) {
                case 1:
                    System.out.println("Ingresa el nombre del nuevo entrenador:");
                    String nombreEntrenador = scanner.next();
                    // Crear un nuevo entrenador y agregarlo a la lista
                    Entrenador nuevoEntrenador = new Entrenador(nombreEntrenador) {
                        @Override
                        protected void inicializarEquipo() {
                            pokemones.add(new Meowth());
                            pokemones.add(new Oddish());
                            pokemones.add(new Poliwag());
                            pokemones.add(new Rhyhorn());
                            pokemones.add(new Spearow());
                        }
                    };
                    
                    gestionarEntrenadores.getEntrenadores().add(nuevoEntrenador);
                    System.out.println("Entrenador " + nombreEntrenador + " registrado exitosamente.");
                    break;
                case 2:
                    System.out.println("Lista de entrenadores:");
                    gestionarEntrenadores.mostrarEntrenadores();
                    break;
                case 3:
                    System.out.println("Selecciona un entrenador:");
                    int seleccion = scanner.nextInt();
                    System.out.println("Lista de entrenadores:");
                    gestionarEntrenadores.mostrarEntrenadores();
                    if (seleccion > 0 && seleccion <= gestionarEntrenadores.getEntrenadores().size()) {
                    Entrenador entrenadorSeleccionado = gestionarEntrenadores.getEntrenadores().get(seleccion - 1);
                        System.out.println("Has seleccionado a " + entrenadorSeleccionado.getNombre());
                        menuSeleccionEntrenador(entrenadorSeleccionado);
                    } else {
                        System.out.println("Selección inválida.");
                    }
                    break;
                case 4:
                    System.out.println("Volviendo al menu principal...");
                    System.out.println("");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcionGestionarEntrenador != 4);
    }

    private static void menuSeleccionEntrenador(Entrenador entrenadorSeleccionado) {

        System.out.println("Gestión de entrenador...");

        int opcionGestion;
        do {
            System.out.println("");
            System.out.println("1. Mostrar equipo");
            System.out.println("2. Agregar Pokémon al equipo");
            System.out.println("3. Reemplazar un Pokémon del equipo");
            System.out.println("4. Eliminar un Pokémon del equipo");
            System.out.println("5. Entrenar pokemones");
            System.out.println("6. Volver a Gestionar Entrenadores");
            System.out.print("Elige una opción: ");
            opcionGestion = scanner.nextInt();

            switch (opcionGestion) {
                case 1: // Mostrar el equipo
                    entrenadorSeleccionado.mostrarPokemones();
                    break;

                case 2: // Agregar un Pokémon
                    agregarPokemonEntrenador(entrenadorSeleccionado);
                    break;

                case 3: // Reemplazar un Pokémon
                    eliminarPokemonEntrenador(entrenadorSeleccionado);
                    agregarPokemonEntrenador(entrenadorSeleccionado);
                    break;

                case 4: // Eliminar un Pokémon
                    eliminarPokemonEntrenador(entrenadorSeleccionado);
                    break;

                case 5:
                        
                        entrenadorSeleccionado.entrenarPokemon();
                    break;
                case 6:
                    // Salir
                    System.out.println("¡Gracias por jugar!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;

            }
        } while (opcionGestion != 5);
    }

    private static void eliminarPokemonEntrenador(Entrenador entrenadorSeleccionado) {
        System.out.println("Elige la posición (1-6) del Pokémon que deseas eliminar:");
        entrenadorSeleccionado.mostrarPokemones();
        int indiceEliminar = scanner.nextInt() - 1;
        entrenadorSeleccionado.eliminarPokemon(indiceEliminar);
    }

    private static void agregarPokemonEntrenador(Entrenador entrenadorSeleccionado) {
        System.out.println("Elige un opcion: ");
        pokedex.getTodosLosPokemones();
        System.out.println("1. Agregar un pokemon totalmente nuevo.");
        System.out.println("Elegir un pokemon:");
        int opcionAgregar = scanner.nextInt();
        if (opcionAgregar == 1) {
            anadirNuevoPokemonEntrenador(entrenadorSeleccionado);
        } else if (opcionAgregar == 2) {
            System.out.println("Elige un Pokémon para agregar:");
            pokedex.mostrarTodosLosPokemones();
            int eleccionAgregar = scanner.nextInt();
            Pokemon nuevoPokemon = pokedex.getPokemones().get(eleccionAgregar - 1);
            if (nuevoPokemon != null) {
                entrenadorSeleccionado.agregarPokemon(nuevoPokemon);
            }
        } else {
            System.out.println("Opcion invalida, vuelvalo a intentar.");
        }

    }

    private static void anadirNuevoPokemonEntrenador(Entrenador entrenadorSeleccionado) {
        System.out.println("Ingresa el nombre del pokemon :");
        String nombre = scanner.next();
        System.out.println("Ingresa la salud del pokemon " + nombre);
        double salud = scanner.nextDouble();
        System.out.println("Ingresa el ataque del pokemon " + nombre);
        double ataque = scanner.nextDouble();
        System.out.println("Elige el tipo de Pokemon: ");
        int indice = 1;

        // Muestra los tipos disponibles
        for (TipoPokemon tipo : TipoPokemon.values()) {
            System.out.println(indice + ". " + tipo);
            indice++;
        }

        // Obtener la elección del tipo
        int numeroTipo = scanner.nextInt();

        // Validar la elección
        if (numeroTipo >= 1 && numeroTipo <= TipoPokemon.values().length) {
            TipoPokemon tipoSeleccionado = TipoPokemon.values()[numeroTipo - 1]; // Restar 1 para ajustar al índice del enum

            // Crear el nuevo Pokémon con los valores proporcionados
            Pokemon nuevoPokemon = new PokemonVacio("Pikachu", 100, 50.0, TipoPokemon.ELECTRICO);
            entrenadorSeleccionado.agregarPokemon(nuevoPokemon);

            System.out.println("Has añadido un nuevo Pokémon de tipo " + tipoSeleccionado + " llamado " + nombre);
        } else {
            System.out.println("Opción no válida. Elige un número entre 1 y " + TipoPokemon.values().length);
        }
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
