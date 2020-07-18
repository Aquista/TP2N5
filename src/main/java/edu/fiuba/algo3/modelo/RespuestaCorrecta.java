package edu.fiuba.algo3.modelo;

public class RespuestaCorrecta implements IRespuesta{
    private boolean valor;

    public RespuestaCorrecta(boolean valor) {

        this.valor = valor;
    }
    public void evaluar(Jugador jugador, int puntos) {

        jugador.sumarPuntos(puntos);
    }
}
