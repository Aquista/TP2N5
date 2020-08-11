package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Jugadores.JugadorDeTipo;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

import java.util.ArrayList;

public abstract class Pregunta {

    protected String texto;
    protected Puntaje puntaje;

    public Pregunta(String texto, Puntaje puntaje){
        this.texto = texto;
        this.puntaje = puntaje;
    }
    public String texto(){
        return this.texto;
    }

    public abstract void evaluarJugadores(Jugador jugador1, Jugador jugador2);

    public abstract JugadorDeTipo tipo();
}
