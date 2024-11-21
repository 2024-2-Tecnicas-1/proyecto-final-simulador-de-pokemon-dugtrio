package com.mycompany.simuladorpokemon;

import com.mycompany.simuladorpokemon.Pokemones.*;
import java.util.ArrayList;

public class Entrenador2 extends Entrenador {

    public Entrenador2(String nombre) {
        super(nombre);
        this.pokemones = new ArrayList<>();
        inicializarEquipo();
        this.gimnasio = new Gimnasio();
    }

    @Override
    protected void inicializarEquipo() {
        this.pokemones.add(new Vulpix());
        this.pokemones.add(new Pikachu());
        this.pokemones.add(new Poliwag());
        this.pokemones.add(new Koffing());
        this.pokemones.add(new Magnemite());
        this.pokemones.add(new Drowzee());
    }

}
