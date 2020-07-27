package edu.fiuba.algo3.modelo;

public class Puntaje {
    private int puntos;
    public Puntaje(int unosPuntos){
        this.puntos=unosPuntos;
    }
    public void agregarPuntos(Jugador unJugador){
        unJugador.actualizarPuntaje(1);
    }
}
