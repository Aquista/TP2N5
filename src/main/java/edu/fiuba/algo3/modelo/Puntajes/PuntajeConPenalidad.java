package edu.fiuba.algo3.modelo.Puntajes;


import edu.fiuba.algo3.modelo.Jugador;

public class PuntajeConPenalidad extends Puntaje {

    @Override
    public void calcularPuntaje(Jugador unJugador, int cantidadRespCorrectasPregunta) {
        unJugador.evaluarRespuestas(this);
        unJugador.actualizarPuntaje(this.cantidadCorrectas-this.cantidadIncorrectas);
    }

    @Override
    public PuntajeConPenalidad duplicar() {
        return new PuntajeConPenalidad();
    }
}
