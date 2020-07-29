package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;

import java.util.ArrayList;

public class PreguntaVF implements IPregunta {
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
