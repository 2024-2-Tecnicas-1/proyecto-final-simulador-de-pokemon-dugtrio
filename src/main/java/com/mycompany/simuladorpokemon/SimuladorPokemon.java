package com.mycompany.simuladorpokemon;
import com.mycompany.simuladorpokemon.Pokemones.Pikachu;
import com.mycompany.simuladorpokemon.Pokemones.Pokemon;
import com.mycompany.simuladorpokemon.Pokemones.Vegeta;
import java.util.Scanner;
public class SimuladorPokemon {

    public static void main(String[] args) {
        Pokemon pikachu = new Pikachu();
        Pokemon vegeta = new Vegeta();
        Batalla batalla = new Batalla();
        
        Pokemon ganador = batalla.iniciarBatalla(pikachu, vegeta);
        
        System.out.println("GANADOR: " + ganador.getNombre());
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
    }
}
