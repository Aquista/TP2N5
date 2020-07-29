package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeConPenalidad;

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
