package edu.fiuba.algo3.modelo.Puntajes;

import edu.fiuba.algo3.modelo.Jugador;

public class PuntajeClasico extends Puntaje {
    
    @Override
    public void calcularPuntaje(Jugador unJugador, int cantidadRespCorrectasPregunta) {
        if(cantidadCorrectas == cantidadRespCorrectasPregunta && cantidadIncorrectas == 0) {
            puntos = 1;
        } else puntos = 0;
    }


    @Override
    public Puntaje nuevoPuntaje(int unMulti) {
        return new PuntajeClasico();
    }

    @Override
    public void setMultiplicador(int multiplicador) {

    }
}