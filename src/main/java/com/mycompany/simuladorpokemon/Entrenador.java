package com.mycompany.simuladorpokemon;

import com.mycompany.simuladorpokemon.Pokemones.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Entrenador {

    Scanner scanner = new Scanner(System.in);

    protected String nombre;
    protected Gimnasio gimnasio;
    protected List<Pokemon> pokemones;

    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.pokemones = new ArrayList<>();
        inicializarEquipo();
        this.gimnasio = new Gimnasio();
    }

    protected abstract void inicializarEquipo();

    public void EntrenarPokemon() {
        System.out.println("Seleccione un Pokemon");
        for (int i = 0; i < pokemones.size(); i++) {
            System.out.println(i + 1 + " " + pokemones.get(i).getNombre());
        }
        int IndexPokemonElegido = scanner.nextInt() - 1;
        Pokemon PokemonElegido = pokemones.get(IndexPokemonElegido);
        gimnasio.EntrenarAtaque(PokemonElegido);
    }

    public boolean agregarPokemon(Pokemon pokemon) {
        if (pokemones.size() < 6) {
            pokemones.add(pokemon);
            System.out.println(pokemon.getNombre() + " ha sido agregado.");
            return true;
        } else {
            System.out.println("El equipo está lleno.");
            return false;
        }
    }

    // Método para reemplazar un Pokémon en una posición específica
    public void reemplazarPokemon(int indice, Pokemon nuevoPokemon) {
        if (indice >= 0 && indice < pokemones.size()) {
            System.out.println("Reemplazando a " + pokemones.get(indice).getNombre() + " con " + nuevoPokemon.getNombre());
            pokemones.set(indice, nuevoPokemon);
        } else {
            System.out.println("Índice fuera de rango. No se puede reemplazar.");
        }
    }

    // Método para eliminar un Pokémon por índice
    public boolean eliminarPokemon(int indice) {
        if (indice >= 0 && indice < pokemones.size()) {
            System.out.println(pokemones.get(indice).getNombre() + " ha sido eliminado del equipo.");
            pokemones.remove(indice);
            return true;
        } else {
            System.out.println("Índice fuera de rango. No se puede eliminar.");
            return false;
        }
    }

    public void mostrarPokemones() {
        System.out.println("Pokemones del Entrenador " + this.nombre);
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
