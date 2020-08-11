package edu.fiuba.algo3.modelo.Panel;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;

public class ControlTurnos {
    private Jugador actual;
    private Jugador primerJugador;
    private Jugador segundoJugaor;
    public ControlTurnos(Jugador... jugadores){
        this.actual=null;
        this.primerJugador=jugadores[0];
        this.segundoJugaor=jugadores[1];
    }
    public void iniciarJuego(){
        this.actual=this.primerJugador;
    }
    public void cambiarTurno(){
        if(this.actual.equals(this.primerJugador)){
            this.actual=this.segundoJugaor;
        }else{
            this.actual=this.primerJugador;
        }
    }
    public Jugador jugadorActual(){
        return this.actual;
    }
}
