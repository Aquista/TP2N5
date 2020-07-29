package edu.fiuba.algo3.modelo.Puntajes;

import edu.fiuba.algo3.modelo.Jugador;

public class PuntajeClasico extends Puntaje {

    public void calcularPuntaje(Jugador unJugador, int cantidadRespCorrectasPregunta) {
        unJugador.evaluarRespuestas(this);

        if(cantidadCorrectas == cantidadRespCorrectasPregunta && cantidadIncorrectas == 0)
            unJugador.actualizarPuntaje(this.cantidadCorrectas);//creo que las preguntas clasicas solo suman las respuetas correctas
    }
}
