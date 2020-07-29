package edu.fiuba.algo3.modelo.Puntajes;

import edu.fiuba.algo3.modelo.Jugador;

public class PuntajeParcial extends Puntaje{

    public void calcularPuntaje(Jugador unJugador) {
        unJugador.evaluarRespuestas(this);
        if(cantidadIncorrectas == 0)
            unJugador.actualizarPuntaje(cantidadCorrectas);
    }
}
