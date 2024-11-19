package com.mycompany.simuladorpokemon;

import com.mycompany.simuladorpokemon.Pokemones.Pokemon;
import java.util.ArrayList;
import java.util.List;

public class Entrenador {
    // tener los dos entrenadores
    // cada entrenador tenga su lista 

    private String nombre;
    private ArrayList<Pokemon> pokemones;
   
    
    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.pokemones = new ArrayList<>();
    }
    
    public Entrenador(String nombre,ArrayList<Pokemon> pokemones) {
        this.nombre = nombre;
        this.pokemones = pokemones;
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
