package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionConGrupo;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

import java.util.ArrayList;

public abstract class Pregunta {
    protected ArrayList<Opcion> opciones = new ArrayList<Opcion>();
    protected String texto;
    protected Puntaje puntaje;

    public Pregunta(String texto, Puntaje puntaje){
        this.texto = texto;
        this.puntaje = puntaje;
    }
    public String texto(){
        return this.texto;
    }
    public ArrayList<Opcion> opciones(){
        return this.opciones;
    }
    public abstract void evaluarJugadores(Jugador jugador1, Jugador jugador2);

}
