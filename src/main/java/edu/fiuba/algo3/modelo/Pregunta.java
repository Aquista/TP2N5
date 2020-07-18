package edu.fiuba.algo3.modelo;

public class Pregunta {
    private IRespuesta respuestaCorrecta;
    private int puntos;
    public Pregunta(int puntos, IRespuesta respuestaCorrecta) {
        this.puntos = puntos;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public void evaluarRespuestas(Jugador primerJugador, IRespuesta res1, Jugador segundoJugador, IRespuesta res2) {
        res1.evaluar(primerJugador, puntos);
        res2.evaluar(segundoJugador, puntos);
    }
}
