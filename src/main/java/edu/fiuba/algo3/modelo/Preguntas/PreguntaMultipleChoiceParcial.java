package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeParcial;

import java.util.ArrayList;

public class PreguntaMultipleChoiceParcial extends Pregunta{

    public PreguntaMultipleChoiceParcial(String texto) {
        super(texto);
    }

    @Override
    public void evaluarJugadores(ArrayList<Jugador> jugadores) {
        for(Jugador jugador : jugadores) {
            PuntajeParcial puntajeJugador = new PuntajeParcial();
            puntajeJugador.calcularPuntaje(jugador);
        }
    }
}
