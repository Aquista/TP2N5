package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.ArrayList;

public class Ronda {
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private Pregunta pregunta;
    private Kahoot kahoot;
    private Panel panel;

    private int cantidadRespondidos = 0;

    public Ronda(Jugador jugador1, Jugador jugador2, Pregunta pregunta, Kahoot kahoot, Panel panel){
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        this.pregunta = pregunta;
        this.kahoot = kahoot;
        this.panel = panel;

    }
    public void avanzarTurno(){
        if(cantidadRespondidos == jugadores.size()){
            pregunta.evaluarJugadores(jugadores.get(0), jugadores.get(1));
            kahoot.avanzarRonda();
        }
        else{
            panel.mostrarVista(pregunta, jugadores.get(cantidadRespondidos), this);
            cantidadRespondidos++;
        }
    }
}
