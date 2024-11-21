package com.mycompany.simuladorpokemon.Pokemones;
import com.mycompany.simuladorpokemon.*;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PokemonTest {

    private Pokemon pokemon1;
    private Pokemon pokemon2;

    @BeforeEach
    void setUp() {
        pokemon1 = new PokemonChild("p1", 100, 50.0, TipoPokemon.FUEGO);
        pokemon2 = new PokemonChild("p2", 120, 40.0, TipoPokemon.AGUA);
    }

    @Test
    void testGetNombre() {
        assertEquals("p1", pokemon1.getNombre());
    }

    @Test
    void testGetSalud() {
        assertEquals(100, pokemon1.getSalud());
    }

    @Test
    void testGetPuntosDeAtaque() {
        assertEquals(50.0, pokemon1.getPuntosDeAtaque());
    }

    @Test
    void testGetTipo() {
        assertEquals(TipoPokemon.FUEGO, pokemon1.getTipo());
    }

    @Test
    void testDamage() {
        pokemon1.damage(30);
        assertEquals(70, pokemon1.getSalud());
    }

    @Test
    void testAtacar_CausaDano() {
        pokemon1.atacar(pokemon2);
        assertTrue(pokemon2.getSalud() < 120, "La salud del oponente debería disminuir.");
    }

    @Test
    void testAtacar_EstadoDebilitado() {
        pokemon2.damage(90); // Deja al oponente con menos de 10 de salud
        pokemon1.atacar(pokemon2);
        assertEquals(EstadoPokemon.Debilitado, pokemon2.getEstado(), "El estado del oponente debería ser 'Debilitado'.");
    }

    @Test
    void testAtacar_EstadoMuerto() {
        pokemon2.damage(120); // Deja al oponente sin salud
        pokemon1.atacar(pokemon2);
        assertEquals(EstadoPokemon.Muerto, pokemon2.getEstado(), "El estado del oponente debería ser 'Muerto'.");
    }

    @Test
    void testIncrementarSalud() {
        pokemon1.incrementarSalud();
        assertEquals(103, pokemon1.getSalud());
    }

    @Test
    void testIncrementarAtaque() {
        pokemon1.incrementarAtaque();
        assertEquals(53.0, pokemon1.getPuntosDeAtaque());
    }

    @Test
    void testGetHoraUltimoEntrenamiento() {
        LocalTime hora = LocalTime.now();
        pokemon1.sethoraUltimoEntrenamiento(hora);
        assertEquals(hora, pokemon1.gethoraUltimoEntrenamiento());
    }

    @Test
    void testToString() {
        String expected = "Pokemon p1 tiene , salud : 100, ataque : 50.0 y tipo : FUEGO}";
        assertEquals(expected, pokemon1.toString());
    }
}
