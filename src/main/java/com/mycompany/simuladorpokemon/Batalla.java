package com.mycompany.simuladorpokemon;
import com.mycompany.simuladorpokemon.EstadoPokemon;
import com.mycompany.simuladorpokemon.Pokemones.Pokemon;
import java.util.Random;

public class Batalla {
    private final Pokemon[] combatientes = new Pokemon[2];
    
    public Pokemon iniciarBatalla(Pokemon pokemon1, Pokemon pokemon2){          
        ordenarCombatientes(pokemon1, pokemon2);
        int indexAtacante = 0;
        int indexDefensor = 1;
        
        do{
            combatientes[indexAtacante].atacar(combatientes[indexDefensor]);
            
            int indexTmp = indexAtacante;
            indexAtacante = indexDefensor;
            indexDefensor = indexTmp;
        }
        while(AmbosEstanVivos(pokemon1, pokemon2));
        
        if(combatientes[0].getEstado() == EstadoPokemon.Muerto)
            return combatientes[1];
        
        return combatientes[0];
    }

    private void ordenarCombatientes(Pokemon pokemon1, Pokemon pokemon2)
    {
        int primerMovimiento = getPrimerMovimiento();
        if(primerMovimiento == 1)
        {
            combatientes[0] = pokemon1;
            combatientes[1] = pokemon2;
        }
        else
        {
             combatientes[0] = pokemon2;
             combatientes[1] = pokemon1;
        }
    }    
    
    private int getPrimerMovimiento()
    {
        Random random = new Random();
        return random.nextInt(2) + 1;
    }
    
        private boolean AmbosEstanVivos(Pokemon pokemon1, Pokemon pokemon2)
    {
        return pokemon1.getEstado() != EstadoPokemon.Muerto
                && pokemon2.getEstado() != EstadoPokemon.Muerto;
    }
}
