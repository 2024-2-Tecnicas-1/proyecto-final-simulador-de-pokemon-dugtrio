package com.mycompany.simuladorpokemon;

import com.mycompany.simuladorpokemon.Pokemones.Pokemon;
import com.mycompany.simuladorpokemon.Pokemones.PokemonChild;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BatallaTest {

    private Batalla batalla;
    private Pokemon pokemon1;
    private Pokemon pokemon2;

    @BeforeEach
    void setUp() {
        batalla = new Batalla();
        pokemon1 = new PokemonChild("p1", 100, 50.0, TipoPokemon.ELECTRICO);
        pokemon2 = new PokemonChild("Charmander", 120, 45.0, TipoPokemon.FUEGO);
    }

    @Test
    void testIniciarBatalla_DeterminaGanador() {
        Pokemon ganador = batalla.iniciarBatalla(pokemon1, pokemon2);

        assertTrue(
            ganador.getEstado() != EstadoPokemon.Muerto,
            "El ganador no debería estar muerto."
        );

        assertTrue(
            pokemon1.getEstado() == EstadoPokemon.Muerto || pokemon2.getEstado() == EstadoPokemon.Muerto,
            "Uno de los Pokémon debe estar muerto."
        );
    }

    @Test
    void testIniciarBatalla_Pokemon1Gana() {
        pokemon2.damage(150); // Forzamos que Charmander esté en estado muerto.
        Pokemon ganador = batalla.iniciarBatalla(pokemon1, pokemon2);

        assertEquals(pokemon1, ganador, "p1 debería ganar la batalla.");
    }

    @Test
    void testIniciarBatalla_Pokemon2Gana() {
        pokemon1.damage(150); // Forzamos que Pikachu esté en estado muerto.
        Pokemon ganador = batalla.iniciarBatalla(pokemon1, pokemon2);

        assertEquals(pokemon2, ganador, "p2 debería ganar la batalla.");
    }
}
