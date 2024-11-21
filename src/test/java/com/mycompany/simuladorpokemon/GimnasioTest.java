package com.mycompany.simuladorpokemon;


import com.mycompany.simuladorpokemon.Pokemones.Pikachu;
import com.mycompany.simuladorpokemon.Pokemones.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class GimnasioTest {
    private Gimnasio gimnasio;
    private Pokemon pokemon;

    @BeforeEach
    void setUp() {
        gimnasio = new Gimnasio();
        pokemon = new Pikachu();
    }

    @Test
    void testEntrenarAtaque_CuandoHanPasado5Minutos() {
        pokemon.sethoraUltimoEntrenamiento(LocalTime.now().minusMinutes(10));
        gimnasio.EntrenarAtaque(pokemon);
        assertEquals(19, pokemon.getPuntosDeAtaque(), "El ataque debería haber incrementado");
    }

    @Test
    void testEntrenarAtaque_CuandoNoHanPasado5Minutos() {
        pokemon.sethoraUltimoEntrenamiento(LocalTime.now().minusMinutes(3));
        gimnasio.EntrenarAtaque(pokemon);
        assertEquals(19, pokemon.getPuntosDeAtaque(), "El ataque no debería haber cambiado");
    }

    @Test
    void testEntrenarSalud_CuandoHanPasado5Minutos() {
        pokemon.sethoraUltimoEntrenamiento(LocalTime.now().minusMinutes(10));
        gimnasio.EntrenarSalud(pokemon);
        assertEquals(38, pokemon.getSalud(), "La salud debería haber incrementado");
    }

    @Test
    void testEntrenarSalud_CuandoNoHanPasado5Minutos() {
        pokemon.sethoraUltimoEntrenamiento(LocalTime.now().minusMinutes(3));
        gimnasio.EntrenarSalud(pokemon);
        assertEquals(38, pokemon.getSalud(), "La salud no debería haber cambiado");
    }
}
