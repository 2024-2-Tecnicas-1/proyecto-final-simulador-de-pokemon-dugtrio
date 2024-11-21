package com.mycompany.simuladorpokemon;

import com.mycompany.simuladorpokemon.Pokemones.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Entrenador{

    protected String nombre;
    protected Gimnasio gimnasio;
    protected List<Pokemon> pokemones;
    private Scanner scanner;

    public Entrenador(String nombre) {
        this(nombre, new Scanner(System.in)); // Usa la entrada estándar por defecto.
    }
    
    public Entrenador(String nombre, Scanner scanner) {
        this.nombre = nombre;
        this.pokemones = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        inicializarEquipo(); // Asegurate de que esto este implementado en las subclases
        this.gimnasio = new Gimnasio();
        this.scanner = scanner;
    }

    protected abstract void inicializarEquipo();

    Scanner SCAN = new Scanner(System.in);
    public void entrenarPokemon() {
        if (pokemones.isEmpty()) {
            System.out.println("No tienes Pokemon para entrenar.");
            return;
        }else{
            System.out.println("Seleccione un Pokemon");
        for(int i = 0; i < pokemones.size(); i++){
            System.out.println(i+1 + " " + pokemones.get(i).getNombre());
        }
        int IndexPokemonElegido = SCAN.nextInt() - 1;
        Pokemon PokemonElegido = pokemones.get(IndexPokemonElegido);
        gimnasio.EntrenarAtaque(PokemonElegido);
        gimnasio.EntrenarSalud(PokemonElegido);
    }

        System.out.println("Seleccione un Pokemon:");
        for (int i = 0; i < pokemones.size(); i++) {
            System.out.println((i + 1) + ". " + pokemones.get(i).getNombre());
        }

        try {
            int indicePokemonElegido = scanner.nextInt() - 1;
            if (indicePokemonElegido < 0 || indicePokemonElegido >= pokemones.size()) {
                System.out.println("Indice no valido. Seleccion cancelada.");
                return;
            }
            Pokemon pokemonElegido = pokemones.get(indicePokemonElegido);
            gimnasio.entrenarAtaque(pokemonElegido);
        } catch (Exception e) {
            System.out.println("Entrada no valida. Por favor, ingresa un numero.");
            scanner.next(); // Limpiar el buffer
        }
    }

    public boolean agregarPokemon(Pokemon pokemon) {
        if (pokemones.size() < 6) {
            pokemones.add(pokemon);
            System.out.println(pokemon.getNombre() + " ha sido agregado.");
            return true;
        } else {
            System.out.println("El equipo esta lleno.");
            return false;
        }
    }

    public void reemplazarPokemon(int indice, Pokemon nuevoPokemon) {
        if (indice >= 0 && indice < pokemones.size()) {
            System.out.println("Reemplazando a " + pokemones.get(indice).getNombre() + " con " + nuevoPokemon.getNombre());
            pokemones.set(indice, nuevoPokemon);
        } else {
            System.out.println("Indice fuera de rango. No se puede reemplazar.");
        }
    }

    public boolean eliminarPokemon(int indice) {
        if (indice >= 0 && indice < pokemones.size()) {
            System.out.println(pokemones.get(indice).getNombre() + " ha sido eliminado del equipo.");
            pokemones.remove(indice);
            return true;
        } else {
            System.out.println("Indice fuera de rango. No se puede eliminar.");
            return false;
        }
    }

    public void mostrarPokemones() {
        System.out.println("Pokemon de " + this.nombre + ":");
        int indice = 1;
        for (Pokemon pokemon : pokemones) {
            System.out.println(indice + " ." + pokemon.toString());
            indice++;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pokemon> getPokemones() {
        return new ArrayList<>(pokemones); // Retorna una copia para evitar modificaciones externas
    }
}
