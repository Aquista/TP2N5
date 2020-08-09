package edu.fiuba.algo3.modelo.Puntajes;

import edu.fiuba.algo3.modelo.Jugador;

public class PuntajeParcial extends Puntaje{

    @Override
    public int calcularPuntaje(Jugador unJugador, int cantidadRespCorrectasPregunta) {
        unJugador.evaluarRespuestas(this);
        if(cantidadIncorrectas == 0)
            puntos = cantidadCorrectas;
        return puntos;
    }

    @Override
    public PuntajeParcial duplicar() {
        return new PuntajeParcial();
    }
}
