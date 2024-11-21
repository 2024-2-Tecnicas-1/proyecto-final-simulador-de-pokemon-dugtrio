package com.mycompany.simuladorpokemon;

import com.mycompany.simuladorpokemon.Pokemones.Pokemon;
import java.time.Duration;
import java.time.LocalTime;

public class Gimnasio {
//>>>>>>>>>><<<<<<<<<<<<

    

    private long ValidacionDiezMinutos(Pokemon pokemon) {
        LocalTime HoraActual = LocalTime.now();
        LocalTime UltimaHora = pokemon.gethoraUltimoEntrenamiento();
        Duration Diferencia = Duration.between(UltimaHora, HoraActual);
        
        return Diferencia.toMinutes();
    }

    public void EntrenarAtaque(Pokemon pokemon) {
        if (ValidacionDiezMinutos(pokemon) > 1) {
            pokemon.incrementarAtaque();
        } else {
            System.out.println("Aun no puede entrenar");
        }

    }

    public void EntrenarSalud(Pokemon pokemon) {
        if (ValidacionDiezMinutos(pokemon) > 1) {
            pokemon.incrementarSalud();
        } else {
            System.out.println("Aun no puede entrenar");
        }
    }

    void entrenarAtaque(Pokemon pokemonElegido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
