
package com.mycompany.simuladorpokemon.Pokemones;

import com.mycompany.simuladorpokemon.EstadoPokemon;
import com.mycompany.simuladorpokemon.MatrizDeAtaque;
import com.mycompany.simuladorpokemon.TipoPokemon;
import com.mycompany.simuladorpokemon.TipoPokemon;
import java.time.LocalTime;


public abstract class Pokemon {

    private String nombre;
    private int salud;
    private double ataque;
    private TipoPokemon tipo;
    private EstadoPokemon estado;
    private LocalTime horaUltimoEntrenamiento;
    

    public Pokemon(String nombre, int salud, double ataque, TipoPokemon tipoPokemon) {
        this.nombre = nombre;
        this.salud = salud;
        this.ataque = ataque;
        this.tipo = tipoPokemon;
        this.horaUltimoEntrenamiento = LocalTime.now();
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public double getPuntosDeAtaque() {
        return ataque;
    }

    public TipoPokemon getTipo() {
        return tipo;
    }

    public EstadoPokemon getEstado() {
        return estado;
    }

    public void setEstado(EstadoPokemon estadoNuevo) {
        this.estado = estadoNuevo;
    }

    public void damage(double dano) {
        salud -= dano;
    }

    public int atacar(Pokemon oponente) {
        //double ataque = this.ataque * this.getMultiplicador(oponente);
        double ataque = this.ataque * TipoPokemon.obtenerMultiplicadorDeDaño(this.getTipo(), oponente.getTipo());
        
        oponente.damage(ataque);
        if (oponente.getSalud() < 10) {
            oponente.setEstado(EstadoPokemon.Debilitado);
        }

        if (oponente.getSalud() < 1) {
            oponente.setEstado(EstadoPokemon.Muerto);
        }

        System.out.println(this.getNombre() + " - Salud : " + this.getSalud());
        System.out.println("OPONENTE: " + oponente.getNombre() + " - Salud : " + oponente.getSalud());

        return this.salud;
    }

    public int recibirDano(int daño) {
        return 0;
    }

    public int entrenar() {
        return 0;
    }

    public double getMultiplicador(Pokemon defensor) {
        int ejeX = this.tipo.ordinal();
        int ejeY = defensor.getTipo().ordinal();

        return MatrizDeAtaque.matriz[ejeX][ejeY];
    }

    public int incrementarSalud() {
        salud = salud + 3;
        System.out.println("salud mejorada: " + salud);
        return salud;
    }

    public int incrementarAtaque() {
        ataque = ataque + 3;
        System.out.println("ataque mejorada: " + ataque);
        return salud;
    }
    public LocalTime gethoraUltimoEntrenamiento(){
        return horaUltimoEntrenamiento;
    }
    public void sethoraUltimoEntrenamiento(LocalTime horaUltimoEntrenamiento){
        this.horaUltimoEntrenamiento = horaUltimoEntrenamiento;
    }
    
    
    
    
    
    @Override
    public String toString() {
        return "Pokemon " + nombre + " tiene , salud : " + salud + ", ataque : " + ataque + " y tipo : " + tipo + '}';
    }
    
}
