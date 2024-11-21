/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simuladorpokemon.Pokemones;

import com.mycompany.simuladorpokemon.Entrenador;
import com.mycompany.simuladorpokemon.TipoPokemon;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class EntrenadorChild extends Entrenador{
    public EntrenadorChild(String nombre, Scanner scanner)
    {
        super(nombre, scanner);
    }
    
        @Override
    protected void inicializarEquipo() {
        // Inicializa un equipo básico de prueba.
        pokemones.add(new PokemonChild("P0", 100, 50, TipoPokemon.ELECTRICO));
    }
}
