package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

public abstract class Pregunta {

    protected String texto;
    protected Puntaje puntaje;
    protected int tiempo = 0;

    public Pregunta(String texto, Puntaje puntaje){
        this.texto = texto;
        this.puntaje = puntaje;
    }

    public Pregunta(String texto, Puntaje puntaje, int tiempo){
        this.texto = texto;
        this.puntaje = puntaje;
        this.tiempo = tiempo;
    }
    public String texto(){
        return this.texto;
    }

    public abstract void evaluarJugadores(Jugador jugador1, Jugador jugador2);

    public abstract Respuesta tipo();

    public Puntaje getPuntaje() {
        return puntaje;
    }

    public int getTiempo() {
        return tiempo;
    }

}
