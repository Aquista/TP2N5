package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class RespuestaVF extends Respuesta {
    private Opcion opcion;

    public RespuestaVF(Opcion ... elegidas){ opcion = elegidas[0]; }
    @Override
    public void agregarOpcion(Opcion unaOpcion){
        this.opcion=unaOpcion;
    }
    @Override
    public void evaluar(Puntaje unPuntaje){
        this.opcion.evaluar(unPuntaje);
    }
}
