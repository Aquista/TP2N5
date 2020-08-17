package edu.fiuba.algo3.modelo.Jugadores;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

public abstract class JugadorDeTipo {

    protected Respuesta respuesta;

    public abstract void responder(Opcion... opciones);
    public void evaluar(Puntaje unPuntaje){ this.respuesta.evaluar(unPuntaje); }
}
