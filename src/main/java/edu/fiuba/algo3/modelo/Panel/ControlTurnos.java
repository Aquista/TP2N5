package edu.fiuba.algo3.modelo.Panel;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVF;
import java.util.ArrayList;

public class ControlTurnos {
    private Jugador actual;
    private Jugador primerJugador;
    private Jugador segundoJugador;
    private PreguntaVF actualP;
    private ArrayList<PreguntaVF> preguntas;
    private int cantidadRespondidos;
    public ControlTurnos(Jugador... jugadores){
        this.actual=null;
        this.primerJugador=jugadores[0];
        this.segundoJugador=jugadores[1];
        this.cantidadRespondidos=0;
    }
    public ControlTurnos(ArrayList<PreguntaVF> preguntas, Jugador... jugadores){
        this.actual=null;
        this.actualP=null;
        this.primerJugador=jugadores[0];
        this.segundoJugador=jugadores[1];
        this.preguntas=preguntas;
        this.cantidadRespondidos=0;
    }
    public void iniciarJuego(){
        this.actual=this.primerJugador;
        this.actualP=this.preguntas.get(0);
    }
    public void cambiarTurno(){
        this.cantidadRespondidos++;
        if(this.actual.equals(this.primerJugador)){
            this.actual=this.segundoJugador;
        }else{
            this.actual=this.primerJugador;
        }
    }
    public void cambiarPregunta(){
        if(this.cantidadRespondidos==2){
            this.actualP=this.preguntas.get(1);
            this.preguntaActual().evaluarJugadores(this.primerJugador,this.segundoJugador);
            this.cantidadRespondidos=0;
        }
    }
    public Jugador jugadorActual(){
        return this.actual;
    }
    public PreguntaVF preguntaActual(){
        return this.actualP;
    }
}
