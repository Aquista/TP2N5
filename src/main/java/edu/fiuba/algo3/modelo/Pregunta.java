package edu.fiuba.algo3.modelo;

public class Pregunta {
    IRespuesta respuestaCorrecta;
    int puntos;
    public Pregunta(int puntos, IRespuesta respuestaCorrecta) {
        this.puntos = puntos;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public void evaluarRespuestas(Jugador j1, IRespuesta res1, Jugador j2, IRespuesta res2) {
        res1.evaluar(j1, puntos);
        res2.evaluar(j2, puntos);
    }
}
