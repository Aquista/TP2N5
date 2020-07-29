package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

import java.util.ArrayList;

public class RespuestaMultipleChoice implements IRespuesta {
    private ArrayList<Opcion> opciones = new ArrayList<Opcion>();

    public void agregarOpcion(Opcion unaOpcion){
        opciones.add(unaOpcion);
    }

    public void evaluar(Puntaje unPuntaje){
        for(Opcion opcion : opciones){
            opcion.evaluar(unPuntaje);
        }
    }
}
