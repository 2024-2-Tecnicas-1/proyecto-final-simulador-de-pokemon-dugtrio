package com.mycompany.simuladorpokemon;

import com.mycompany.simuladorpokemon.Pokemones.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Entrenador1 extends Entrenador {
    
    public Entrenador1(String nombre) {
        super(nombre);
        this.pokemones = new ArrayList<>();
        inicializarEquipo();
        this.gimnasio = new Gimnasio();
    }

    // Implementación del constructor que acepta un Scanner
    public Entrenador1(String nombre, Scanner scanner) {
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
        this.pokemones.add(new Rhyhorn());
        this.pokemones.add(new Oddish());
        this.pokemones.add(new Mankey());
        this.pokemones.add(new Meowth());
        this.pokemones.add(new Spearow());    
    }
}
