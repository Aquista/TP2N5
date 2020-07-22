package edu.fiuba.algo3.modelo;

public class Marcador {
    private int cantRespuestasCorrectas = 0;
    private int cantRespuestasIncorrectas = 0;
    private Jugador jugador;

    public Marcador(Jugador jugador) {
        this.jugador = jugador;
    }
    public int getRespuestasCorrectas() {
        return cantRespuestasCorrectas;
    }
    public int getRespuestasIncorrectas() {
        return cantRespuestasIncorrectas;
    }
    public void sumarRespuestasCorrectas() {
        cantRespuestasCorrectas += 1;
    }
    public void sumarRespuestasIncorrectas() {
        cantRespuestasIncorrectas += 1;
    }

    public Jugador getJugador() {
        return jugador;
    }
}
