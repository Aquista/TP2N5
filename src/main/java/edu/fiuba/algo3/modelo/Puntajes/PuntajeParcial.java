package edu.fiuba.algo3.modelo.Puntajes;

import edu.fiuba.algo3.modelo.Jugador;

public class PuntajeParcial extends Puntaje{

    @Override
    public void calcularPuntaje(Jugador unJugador, int respuestasCorrectas) {
        if(cantidadIncorrectas == 0)
            puntos = cantidadCorrectas;
    }

    @Override
    public Puntaje nuevoPuntaje(int  unMulti) {
        return new PuntajeParcial();
    }

    @Override
    public void setMultiplicador(int multiplicador) {

    }
}
