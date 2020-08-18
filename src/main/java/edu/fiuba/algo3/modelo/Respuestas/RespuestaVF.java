package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class RespuestaVF implements Respuesta {
    private Opcion opcion;

    public RespuestaVF(){}

    public void evaluar(Puntaje unPuntaje){
        this.opcion.evaluar(unPuntaje);
    }

    public void agregarOpciones(Opcion... opciones) {
        this.opcion = opciones[0];
    }
}