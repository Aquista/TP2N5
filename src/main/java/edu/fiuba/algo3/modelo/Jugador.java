package edu.fiuba.algo3.modelo;

public class Jugador {
    private int puntos = 0;

    public void sumarPuntos(int puntosASumar) {

        puntos += puntosASumar;
    }
    public int misPuntos() {

        return puntos;
    }
}
