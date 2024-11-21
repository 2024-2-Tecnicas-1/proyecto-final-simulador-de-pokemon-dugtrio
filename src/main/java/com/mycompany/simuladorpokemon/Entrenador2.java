package com.mycompany.simuladorpokemon;

import com.mycompany.simuladorpokemon.Pokemones.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Entrenador2 extends Entrenador {

    public Entrenador2(String nombre) {
        super(nombre);
        this.pokemones = new ArrayList<>();
        inicializarEquipo();
        this.gimnasio = new Gimnasio();
    }

    // Implementación del constructor que acepta un Scanner
    public Entrenador2(String nombre, Scanner scanner) {
        super(nombre);
        this.pokemones = new ArrayList<>();
        inicializarEquipo();
        this.gimnasio = new Gimnasio();
        
        // Aquí puedes agregar lógica para interactuar con el scanner
        System.out.println("Entrenador creado: " + nombre);
        // Por ejemplo, podrías preguntar si quieren personalizar el equipo
    }

    @Override
    protected void inicializarEquipo() {
        this.pokemones.add(new Vulpix());
        this.pokemones.add(new Poliwag());
        this.pokemones.add(new Koffing());
        this.pokemones.add(new Magnemite());
        this.pokemones.add(new Drowzee());
    }
}
