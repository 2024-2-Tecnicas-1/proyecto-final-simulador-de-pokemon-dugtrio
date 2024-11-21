package com.mycompany.simuladorpokemon;

import com.mycompany.simuladorpokemon.Pokemones.EntrenadorChild;
import com.mycompany.simuladorpokemon.Pokemones.Pokemon;
import com.mycompany.simuladorpokemon.Pokemones.PokemonChild;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class EntrenadorTest {

    private Entrenador entrenador;
    private Pokemon pokemon1;
    private Pokemon pokemon2;

    @BeforeEach
    void setUp() {
        InputStream simulatedInput = new ByteArrayInputStream("2\n".getBytes());
        Scanner simulatedScanner = new Scanner(simulatedInput);
        entrenador = new EntrenadorChild("DugTrio", simulatedScanner);
        pokemon1 = new PokemonChild("P1", 120, 45, TipoPokemon.FUEGO);
        pokemon2 = new PokemonChild("P2", 130, 40, TipoPokemon.PLANTA);
    }

    @Test
    void testAgregarPokemon_EquipoNoLleno() {
        boolean agregado = entrenador.agregarPokemon(pokemon1);
        assertTrue(agregado, "El Pokémon debería haberse agregado.");
        assertEquals(2, entrenador.getPokemones().size(), "El equipo debería tener 2 Pokémon.");
    }

    @Test
    void testAgregarPokemon_EquipoLleno() {
        for (int i = 0; i < 5; i++) {
            entrenador.agregarPokemon(new PokemonChild("Test" + i, 100, 50, TipoPokemon.AGUA));
        }

        boolean agregado = entrenador.agregarPokemon(pokemon2);
        assertFalse(agregado, "El Pokémon no debería haberse agregado porque el equipo está lleno.");
    }

    @Test
    void testReemplazarPokemon_IndiceValido() {
        entrenador.agregarPokemon(pokemon1);
        entrenador.reemplazarPokemon(0, pokemon2);

        List<Pokemon> equipo = entrenador.getPokemones();
        assertEquals(pokemon2, equipo.get(0), "El Pokémon debería haber sido reemplazado.");
    }

    @Test
    void testReemplazarPokemon_IndiceInvalido() {
        entrenador.reemplazarPokemon(5, pokemon2);
        assertEquals(1, entrenador.getPokemones().size(), "El equipo no debería haber cambiado.");
    }

    @Test
    void testEliminarPokemon_IndiceValido() {
        boolean eliminado = entrenador.eliminarPokemon(0);
        assertTrue(eliminado, "El Pokémon debería haberse eliminado.");
        assertTrue(entrenador.getPokemones().isEmpty(), "El equipo debería estar vacío.");
    }

    @Test
    void testEliminarPokemon_IndiceInvalido() {
        boolean eliminado = entrenador.eliminarPokemon(5);
        assertFalse(eliminado, "No se debería haber eliminado ningún Pokémon.");
    }

    @Test
    void testMostrarPokemones() {
        // No se prueba directamente porque imprime en consola.
        assertEquals(1, entrenador.getPokemones().size(), "El equipo inicial debería tener un Pokémon.");
    }

    @Test
    void testGetNombre() {
        assertEquals("DugTrio", entrenador.getNombre(), "El nombre del entrenador debería ser 'DugTrio'.");
    }

    @Test
    void testSetNombre() {
        entrenador.setNombre("Goku");
        assertEquals("Goku", entrenador.getNombre(), "El nombre del entrenador debería ser 'Goku'.");
    }
    
    @Test
    void testEntrenarPokemon() {
        pokemon1.sethoraUltimoEntrenamiento(LocalTime.now().minusMinutes(20));
        entrenador.agregarPokemon(pokemon1);
        entrenador.EntrenarPokemon();

        // Verifica que el ataque del primer Pokémon haya incrementado.
        assertEquals(48, pokemon1.getPuntosDeAtaque(), "El ataque de P1 debería haber incrementado.");
    }
}
