package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class RespuestaVF implements Respuesta {
    private Opcion opcion;

    public RespuestaVF(){}

    public RespuestaVF(Opcion opcion){
       this.opcion = opcion;
    }
    public void agregarOpcion(Opcion unaOpcion){
        this.opcion=unaOpcion;
    }
    
    public void evaluar(Puntaje unPuntaje){
        this.opcion.evaluar(unPuntaje);
    }
}