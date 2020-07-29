package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeConPenalidad;

import java.util.ArrayList;

public class PreguntaMultipleChoiceConPenalidad extends Pregunta{

    @Override
    public void evaluarJugadores(ArrayList<Jugador> jugadores) {
        for(Jugador jugador : jugadores) {
            PuntajeConPenalidad puntajeJugador = new PuntajeConPenalidad();
            puntajeJugador.calcularPuntaje(jugador);
        }
    }
}
