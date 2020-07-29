package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaVF implements IPregunta{
    private ArrayList<Opcion> opciones;
    private int puntos;
    public PreguntaVF(ArrayList<Opcion> unasOpciones) {
        this.opciones = unasOpciones;
    }

    @Override
    public void evaluarJugadores(ArrayList<Jugador> jugadores) {
        for(Jugador jugador : jugadores) {
            PuntajeClasico unPuntaje = new PuntajeClasico();
            unPuntaje.calcularPuntaje(jugador);
        }
    }
    
}
