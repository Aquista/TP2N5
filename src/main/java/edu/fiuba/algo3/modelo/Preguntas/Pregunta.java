package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.*;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import java.util.ArrayList;

public abstract class Pregunta {
    protected ArrayList<Opcion> opciones = new ArrayList<>();
    private final String texto;
    protected int totalCorrectas ;
    protected Puntaje puntaje;

    public Pregunta(String texto, Puntaje unPuntaje){
        this.texto = texto;
        this.totalCorrectas=0;
        this.puntaje=unPuntaje;
    }

    public void agregarOpcionCorrecta(OpcionCorrecta opcionCorrecta){
        opciones.add(opcionCorrecta);
        totalCorrectas++;
    }

    public void agregarOpcionIncorrecta(OpcionIncorrecta opcionIncorrecta){
        opciones.add(opcionIncorrecta);
    }

    public abstract void evaluarJugadores(Jugador primerJugador, Jugador segundoJugador);
}
