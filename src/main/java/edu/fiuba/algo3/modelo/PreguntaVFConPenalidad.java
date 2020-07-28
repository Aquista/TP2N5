package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaVFConPenalidad implements IPregunta {

    private ArrayList<IRespuesta> respuestas;
    private int puntos;
    public PreguntaVFConPenalidad(ArrayList<IRespuesta> respuestas) {
        this.respuestas = respuestas;
    }

    @Override
    public void evaluarJugadores(ArrayList<Jugador> jugadores) {
        for(Jugador jugador : jugadores) {
            PuntajeConPenalidad unPuntaje = new PuntajeConPenalidad();
            unPuntaje.calcularPuntaje(jugador);
        }
    }
    
}
