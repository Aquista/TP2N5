package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

import java.util.ArrayList;
import java.util.Arrays;

public class RespuestaMultipleChoice implements Respuesta {
    private ArrayList<Opcion> opciones = new ArrayList<Opcion>();


    public void agregarOpciones(Opcion ... opciones){
        if(opciones == null || Arrays.asList(opciones).contains(null))
            return;

        for (Opcion opcion : opciones){
            this.opciones.add(opcion);
        }
    }

    public void evaluar(Puntaje unPuntaje){
        for(Opcion opcion : opciones){
            opcion.evaluar(unPuntaje);
        }
    }
}
