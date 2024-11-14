package com.mycompany.simuladorpokemon;
public enum TipoPokemon{
    FUEGO, AGUA, PLANTA, VENENO, ELECTRICO, PSIQUICO, ROCA, TIERRA, NORMAL, VOLADOR, HADA, LUCHA, ACERO, BICHO, HIELO, FANTASMA; 
 public static double obtenerMultiplicadorDeDaño(TipoPokemon atacante, TipoPokemon defensor) {

        switch (atacante) {
            case FUEGO:
                switch (defensor) {
                    case AGUA:
                    case ROCA:
                    case ACERO:
                        return 0.5;
                    case PLANTA:
                    case BICHO:
                    case HIELO:
                        return 2;
                    default:
                        return 1;
                }
            case AGUA:
                switch (defensor) {
                    case PLANTA:
                        return 0.5;
                    case FUEGO:
                    case ROCA:
                        return 2;
                    default:
                        return 1;
                }
            case PLANTA:
                switch (defensor) {
                    case FUEGO:
                    case VENENO:
                    case ACERO:
                    case BICHO:
                        return 0.5;
                    case AGUA:
                    case ROCA:
                    case TIERRA:
                        return 2;
                    default:
                        return 1;
                }
            case VENENO:
                switch (defensor) {
                    case ROCA:
                    case FANTASMA:
                        return 0.5;
                    case PLANTA:
                    case HADA:
                        return 2;
                    default:
                        return 1;
                }
            case ELECTRICO:
                switch (defensor) {
                    case PLANTA:
                        return 0.5;
                    case TIERRA:
                        return 0;
                    case AGUA:
                    case VOLADOR:
                        return 2;
                    default:
                        return 1;
                }
            case PSIQUICO:
                switch (defensor) {
                    case VENENO:
                    case LUCHA:
                        return 2;
                    default:
                        return 1;
                }
            case ROCA:
                switch (defensor) {
                    case LUCHA:
                        return 0.5;
                    case FUEGO:
                    case VOLADOR:
                    case ACERO:
                    case BICHO:
                    case HIELO:
                        return 2;
                    default:
                        return 1;
                }
            case TIERRA:
                switch (defensor) {
                    case VOLADOR:
                        return 0.5;
                    case FUEGO:
                    case VENENO:
                    case ROCA:
                    case ACERO:
                        return 2;
                    case ELECTRICO:
                        return 0;
                    default:
                        return 1;
                }
            case NORMAL:
                switch (defensor) {
                    case FANTASMA:
                        return 0;
                    default:
                        return 1;
                }
            case VOLADOR:
                switch (defensor) {
                    case ROCA:
                        return 0.5;
                    case PLANTA:
                    case ELECTRICO:
                    case BICHO:
                        return 2;
                    default:
                        return 1;
                }
            case HADA:
                switch (defensor) {
                    case PSIQUICO:
                        return 2;
                    default:
                        return 1;
                }
            case LUCHA:
                switch (defensor) {
                    case PSIQUICO:
                    case HADA:
                    case FANTASMA:
                        return 0.5;
                    case ROCA:
                    case NORMAL:
                    case HIELO:
                        return 2;
                    default:
                        return 1;
                }
            case ACERO:
                switch (defensor) {
                    case PSIQUICO:
                        return 0.5;
                    case FUEGO:
                    case ROCA:
                    case HADA:
                    case LUCHA:
                        return 2;
                    default:
                        return 1;
                }
            case BICHO:
                switch (defensor) {
                    case ACERO:
                    case FANTASMA:
                        return 0.5;
                    case PLANTA:
                    case VOLADOR:
                        return 2;
                    default:
                        return 1;
                }
            case HIELO:
                switch (defensor) {
                    case PLANTA:
                    case TIERRA:
                        return 2;
                    default:
                        return 1;
                }
            case FANTASMA:
                switch (defensor) {
                    case VENENO:
                        return 0.5;
                    case NORMAL:
                        return 0;
                    case FANTASMA:
                        return 2;
                    default:
                        return 1;
                }
        }
        
        return 1;
    }
}
