package edu.fiuba.algo3.modelo;

import javax.swing.*;

public class PuntajeClasico extends IPuntaje {
    @Override
    public void calcularPuntaje(Jugador unJugador) {
        unJugador.evaluarRespuestas(this);
        unJugador.actualizarPuntaje(this.cantidadCorrectas);//creo que las preguntas clasicas solo suman las respuetas correctas
    }
}
