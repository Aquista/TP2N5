package edu.fiuba.algo3.modelo;

import javax.swing.*;

public class PuntajeClasico implements IPuntaje {
    private int puntos = 0;
    private int cantidadCorrectas = 0;
    private int cantidadIncorrectas = 0;
    @Override
    public void calcularPuntaje(Jugador unJugador) {
        unJugador.evaluarRespuestas(this);
        unJugador.actualizarPuntaje(cantidadCorrectas);//creo que las preguntas clasicas solo suman las respuetas correctas
    }

    @Override
    public void sumarCorrecta() {
        cantidadCorrectas += 1;
    }

    @Override
    public void sumarIncorrecta() {
        cantidadIncorrectas += 1;
    }

    public int getRespuestasCorrectas() {
        return cantidadCorrectas;
    }

    public int getRespuestasIncorrectas() {
        return cantidadIncorrectas;
    }
}
