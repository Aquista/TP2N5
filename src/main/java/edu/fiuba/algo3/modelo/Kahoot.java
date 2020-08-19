package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Kahoot {
    private ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private Queue<Ronda> rondas = new LinkedList<Ronda>();

    public void empezarPartida(String nombreArchivo){
        preguntas.addAll(CreadorDePreguntas.generarPreguntas(nombreArchivo));
        generarRondas();
    }

    public Ronda avanzarRonda() {
        if(!rondas.isEmpty())
            return rondas.poll();
        else
            return null;
    }

    public void generarRondas(){
        for(Pregunta pregunta : preguntas){
            Ronda ronda = new Ronda(jugadores.get(0), jugadores.get(1), pregunta);
            rondas.add(ronda);
        }
    }

    public void agregarJugadores(String nombreJugador1, String nombreJugador2) {
        Jugador jugador1 = new Jugador(nombreJugador1);
        Jugador jugador2 = new Jugador(nombreJugador2);

        jugadores.add(jugador1);
        jugadores.add(jugador2);
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
}
