package edu.fiuba.algo3.modelo;

public class Jugador {
    int puntos = 0;

    public void sumarPuntos(int puntosASumar) {
        puntos += puntosASumar;
    }
    public int getPuntos() {
        return puntos;
    }
}
