package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.ArrayList;

public class Ronda {
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private Pregunta pregunta;

    private int numeroTurno = 0;

    public Ronda(Jugador jugador1, Jugador jugador2, Pregunta pregunta){
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        this.pregunta = pregunta;
    }
    public void avanzarTurno(){
        numeroTurno++;
    }

    public void evaluarJugadores() {
        pregunta.evaluarJugadores(jugadores.get(0), jugadores.get(1));
    }

    public boolean finalizada() {
        return (numeroTurno == (jugadores.size()));
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public Jugador getJugador() {
        return jugadores.get(numeroTurno - 1);
    }
}
