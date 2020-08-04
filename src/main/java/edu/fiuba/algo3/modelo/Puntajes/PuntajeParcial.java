package edu.fiuba.algo3.modelo.Puntajes;

import edu.fiuba.algo3.modelo.Jugador;

public class PuntajeParcial extends Puntaje{

    @Override
    public void calcularPuntaje(Jugador unJugador, int cantidadRespCorrectasPregunta) {
        unJugador.evaluarRespuestas(this);
        if(cantidadIncorrectas == 0)
            puntos = cantidadCorrectas;
    }

    @Override
    public PuntajeParcial duplicar() {
        return new PuntajeParcial();
    }
}
