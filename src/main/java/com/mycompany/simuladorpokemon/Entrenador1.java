package com.mycompany.simuladorpokemon;

import com.mycompany.simuladorpokemon.Pokemones.*;
import java.util.ArrayList;

public class Entrenador1 extends Entrenador {
    
    public Entrenador1(String nombre) {
        super(nombre);
        this.pokemones = new ArrayList<>();
        inicializarEquipo();
        this.gimnasio = new Gimnasio();
    }

    @Override
    protected void inicializarEquipo() {
        this.pokemones.add(new Vulpix());
        this.pokemones.add(new Rhyhorn());
        this.pokemones.add(new Oddish());
        this.pokemones.add(new Mankey());
        this.pokemones.add(new Meowth());
        this.pokemones.add(new Spearow());    
    }


  

}
