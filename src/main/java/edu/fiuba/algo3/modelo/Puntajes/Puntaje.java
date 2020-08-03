package edu.fiuba.algo3.modelo.Puntajes;

import edu.fiuba.algo3.modelo.Jugador;

public abstract class Puntaje {

    protected int cantidadCorrectas = 0;
    protected int cantidadIncorrectas = 0;

    public abstract void calcularPuntaje(Jugador unJugador, int cantidadRespCorrectasPregunta);

    public abstract Puntaje duplicar();

    public void sumarCorrecta() {
        cantidadCorrectas += 1;
    }

    public void sumarIncorrecta() {
        cantidadIncorrectas += 1;
    }
}
