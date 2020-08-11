package edu.fiuba.algo3.modelo.Panel;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;

import java.util.ArrayList;

public class Panel {
    private Jugador primerJugador;
    private Jugador segundoJugador;
    private ControlTurnos turnos;
    private ArrayList<Jugador> jugadores;

    public Panel (){
        this.jugadores=new ArrayList<>();
    }
    public Panel(ArrayList<Jugador> jugadores) {
        this.primerJugador=jugadores.get(0);
        this.segundoJugador=jugadores.get(1);
    }
    public Jugador ganador(){
        return this.primerJugador.ganador(this.segundoJugador);
    }
    public int cantJugadores(){
        return this.jugadores.size();
    }
    public void agregarJugador(Jugador unJugador){
        this.jugadores.add(unJugador);
    }
    public void iniciarJuego(){
        this.primerJugador=this.jugadores.get(0);
        this.segundoJugador=this.jugadores.get(1);
        this.turnos=new ControlTurnos(this.primerJugador,this.segundoJugador);
        this.turnos.iniciarJuego();
    }
    public Jugador jugadorActual(){
        return this.turnos.jugadorActual();
    }
    public void pasarTurno(){
        this.turnos.cambiarTurno();
    }
}
