package edu.fiuba.algo3.modelo.Panel;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;

public class Panel {
    private Jugador primerJugador;
    private Jugador segundoJugador;
    private ControlTurnos turnos;

    public Panel(Jugador... jugadores) {
        this.primerJugador=jugadores[0];
        this.segundoJugador=jugadores[1];
        this.turnos=new ControlTurnos(this.primerJugador,this.segundoJugador);

    }
    public Jugador ganador(){
        return this.primerJugador.ganador(this.segundoJugador);
    }
}
