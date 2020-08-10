package edu.fiuba.algo3.modelo.Panel;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;

public class Panel {
    private Jugador actual;
    private Jugador primerJugador;
    private Jugador segundoJugador;

    public Panel(Jugador... jugadores) {
        this.actual=null;
        this.primerJugador=jugadores[0];
        this.segundoJugador=jugadores[1];
    }
    public Jugador ganador(){
        return this.primerJugador.ganador(this.segundoJugador);
    }
}
