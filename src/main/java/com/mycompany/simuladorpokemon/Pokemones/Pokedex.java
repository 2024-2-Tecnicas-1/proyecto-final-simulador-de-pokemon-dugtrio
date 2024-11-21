package com.mycompany.simuladorpokemon.Pokemones;

import com.mycompany.simuladorpokemon.Pokemones.Pikachu;
import com.mycompany.simuladorpokemon.Pokemones.Vulpix;
import com.mycompany.simuladorpokemon.Pokemones.Drowzee;
import com.mycompany.simuladorpokemon.Pokemones.Koffing;
import com.mycompany.simuladorpokemon.Pokemones.Magnemite;
import com.mycompany.simuladorpokemon.Pokemones.Mankey;
import com.mycompany.simuladorpokemon.Pokemones.Meowth;
import com.mycompany.simuladorpokemon.Pokemones.Oddish;
import com.mycompany.simuladorpokemon.Pokemones.Poliwag;
import com.mycompany.simuladorpokemon.Pokemones.Rhyhorn;
import com.mycompany.simuladorpokemon.Pokemones.Spearow;
import com.mycompany.simuladorpokemon.Pokemones.Pokemon;

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
    
    public ArrayList<Pokemon> getPokemones() {
        return pokemones;
    }

    // Implementación del método getTodosLosPokemones
    public ArrayList<Pokemon> getTodosLosPokemones() {
        return new ArrayList<>(pokemones); // Retorna una copia de la lista de Pokémon
    }
}
