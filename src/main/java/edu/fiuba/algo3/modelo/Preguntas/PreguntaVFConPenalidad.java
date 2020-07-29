package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaVFConPenalidad implements IPregunta {

    private ArrayList<Opcion> opciones;
    private int puntos;
    public PreguntaVFConPenalidad(ArrayList<Opcion> unasOpciones) {
        this.opciones = unasOpciones;
    }

    @Override
    public void evaluarJugadores(ArrayList<Jugador> jugadores) {
        for(Jugador jugador : jugadores) {
            PuntajeConPenalidad unPuntaje = new PuntajeConPenalidad();
            unPuntaje.calcularPuntaje(jugador);
        }
    }
    
}
