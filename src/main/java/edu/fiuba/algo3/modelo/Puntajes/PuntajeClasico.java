package edu.fiuba.algo3.modelo.Puntajes;

import edu.fiuba.algo3.modelo.Jugador;

public class PuntajeClasico extends Puntaje {

    private int puntos = 1;
    
    @Override
    public void calcularPuntaje(Jugador unJugador, int cantidadRespCorrectasPregunta) {
        if(cantidadCorrectas == cantidadRespCorrectasPregunta && cantidadIncorrectas == 0) {
            //unJugador.actualizarPuntaje(puntos);
        } else puntos = 0;
    }

    @Override
    public int getPuntos() {
        return puntos;
    }

    @Override
    public Puntaje nuevoPuntaje(int unMulti) {
        return new PuntajeClasico();
    }

    @Override
    public void setMultiplicador(int multiplicador) {

    }
}