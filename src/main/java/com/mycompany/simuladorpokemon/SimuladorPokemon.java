package com.mycompany.simuladorpokemon;

import com.mycompany.simuladorpokemon.Pokemones.Drowzee;
import com.mycompany.simuladorpokemon.Pokemones.Pikachu;
import com.mycompany.simuladorpokemon.Pokemones.Pokemon;
import com.mycompany.simuladorpokemon.Pokemones.Vulpix;
import java.util.Scanner;

public class SimuladorPokemon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pokemon pikachu = new Pikachu();
        Pokemon vulpix = new Vulpix();
        Pokemon Drowzee = new Drowzee();
        
             
        Batalla batalla = new Batalla();

        System.out.println("Elige una opción:");
        System.out.println("1. Seleccionar Pokémon y empezar batalla");
        System.out.println("2. Gestionar entrenadores");
        System.out.println("3. Configurar opciones");
        int primerOpcion = scanner.nextInt();

        switch (primerOpcion) {
            case 1:
                // Selección de Pokémon y batalla
                System.out.println("Elige el Pokémon que deseas utilizar:");
                System.out.println("1. Pikachu");
                System.out.println("2. Vulpix");
                
                Pokemon[] eleccionPokemon = new Pokemon[2];

                for (int i = 0; i < 2; i++) {
                    System.out.print("Elige tu Pokémon (1 para Pikachu, 2 para Vulpix): ");
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
                            i--;  // Permitir que el usuario vuelva a elegir
                            break;
                    }
                }

                Pokemon ganador = batalla.iniciarBatalla(eleccionPokemon[0], eleccionPokemon[1]);
                System.out.println("GANADOR: " + ganador.getNombre());
                scanner.nextInt();
                break;
            case 2:
                // Clase entrenador
                System.out.println("Gestión de entrenadores en desarrollo...");
                break;
            case 3:
                // Clase gestionar
                System.out.println("Gestión de opciones en desarrollo...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}
