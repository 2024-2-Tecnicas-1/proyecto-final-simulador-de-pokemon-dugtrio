package com.mycompany.simuladorpokemon.Pokemones;

import java.util.ArrayList;

public class Pokedex {
    private ArrayList<Pokemon> pokemones;

    public Pokedex() {
        pokemones = new ArrayList<>();
        inicializarPokemones();
    }

    private void inicializarPokemones() {
        pokemones.add(new Pikachu());
        pokemones.add(new Vulpix());
        pokemones.add(new Drowzee());
        pokemones.add(new Koffing());
        pokemones.add(new Magnemite());
        pokemones.add(new Mankey());
        pokemones.add(new Meowth());
        pokemones.add(new Oddish());
        pokemones.add(new Poliwag());
        pokemones.add(new Rhyhorn());
        pokemones.add(new Spearow());
    }
    
    public void mostrarTodosLosPokemones() {
        for (Pokemon pokemon : pokemones) {
            System.out.println(pokemon.toString());
        }
    }
    
    public ArrayList<Pokemon> getTodosLosPokemones() {
        return new ArrayList<>(pokemones); // Retorna una copia de la lista de Pokémon
    }

    public Pokemon buscarPokemon(String nombrePokemon) {
        for (Pokemon pokemon : pokemones) {
            if (pokemon.getNombre().equalsIgnoreCase(nombrePokemon)) {
                return pokemon; // Retorna el Pokémon si se encuentra
            }
        }
        return null; // Retorna null si no se encuentra
    }
}