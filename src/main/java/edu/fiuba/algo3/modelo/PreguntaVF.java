package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaVF implements IPregunta{
    private ArrayList<IRespuesta> respuestas;
    private int puntos;
    public PreguntaVF(ArrayList<IRespuesta> respuestas) {
        this.respuestas = respuestas;
    }

    @Override
    public void evaluarJugadores(ArrayList<Jugador> jugadores) {
        for(Jugador jugador : jugadores) {
            PuntajeClasico unPuntaje = new PuntajeClasico();
            unPuntaje.calcularPuntaje(jugador);
        }
    }
    
}
