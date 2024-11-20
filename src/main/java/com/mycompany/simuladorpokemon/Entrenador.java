package com.mycompany.simuladorpokemon;

import com.mycompany.simuladorpokemon.Pokemones.Drowzee;
import com.mycompany.simuladorpokemon.Pokemones.Pikachu;
import com.mycompany.simuladorpokemon.Pokemones.Pokemon;
import com.mycompany.simuladorpokemon.Pokemones.Rhyhorn;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Entrenador {
    // tener los dos entrenadores
    // cada entrenador tenga su lista 
    Scanner sc = new Scanner(System.in);
    private String nombre;
    private ArrayList<Pokemon> pokemones;
    private Gimnasio gimnasio;
    
    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.pokemones = new ArrayList<>();
        
        /*
        pokemones.add(new Pikachu());
        pokemones.add(new Rhyhorn());
        pokemones.add(new Drowzee());
        */
        
        this.gimnasio = new Gimnasio();
    }
    
    public Entrenador(String nombre,ArrayList<Pokemon> pokemones) {
        this.nombre = nombre;
        this.pokemones = pokemones;
    }
    
    public void EntrenarPokemon(){
        System.out.println("Seleccione un Pokemon");
        for(int i = 0; i < pokemones.size(); i++){
            System.out.println(i+1 + " " + pokemones.get(i).getNombre());
        }
        int IndexPokemonElegido = sc.nextInt() - 1;
        Pokemon PokemonElegido = pokemones.get(IndexPokemonElegido);
        gimnasio.EntrenarAtaque(PokemonElegido);
    }
    
    
    

   
    public boolean agregarPokemon(Pokemon pokemon) {
        if (pokemones.size() <= 6) { // Limite de 6 pokemones por entrenador siguiendo las reglas tradicionales de un juego de pokemon
            pokemones.add(pokemon);
            System.out.println(pokemon.getNombre() + " ha sido agregado.");
            return true;
        } else {
            System.out.println("No se pueden agregar más Pokémon. El equipo está lleno.");
            return false;
        }
    }

    
    public void mostrarPokemones() {
        System.out.println("Pokémon de " + nombre + ":");
        for (Pokemon pokemon : pokemones) {
            System.out.println(pokemon.toString());
        }
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pokemon> getPokemones() {
        return pokemones;
    }
}
