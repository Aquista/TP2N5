package edu.fiuba.algo3.modelo.Puntajes;

import edu.fiuba.algo3.modelo.Jugador;

public class PuntajeClasico extends Puntaje {

    @Override
    public int calcularPuntaje(Jugador unJugador, int cantidadRespCorrectasPregunta) {
        unJugador.evaluarRespuestas(this);
        if(cantidadCorrectas == cantidadRespCorrectasPregunta && cantidadIncorrectas == 0)
            puntos = 1;
        return puntos;
    }
    @Override
    public void asignarPuntaje(Jugador unJugador) {
        unJugador.actualizarPuntaje(puntos);
    }

    @Override
    public PuntajeClasico duplicar() {
        return new PuntajeClasico();
    }
}