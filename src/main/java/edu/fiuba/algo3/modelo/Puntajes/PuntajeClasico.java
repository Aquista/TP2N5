package edu.fiuba.algo3.modelo.Puntajes;

import edu.fiuba.algo3.modelo.Jugador;

public class PuntajeClasico extends IPuntaje {
    @Override
    public void calcularPuntaje(Jugador unJugador) {
        unJugador.evaluarRespuestas(this);
        unJugador.actualizarPuntaje(this.cantidadCorrectas);//creo que las preguntas clasicas solo suman las respuetas correctas
    }
}
