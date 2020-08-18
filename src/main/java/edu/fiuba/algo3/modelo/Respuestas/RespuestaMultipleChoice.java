package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

import java.util.ArrayList;

public class RespuestaMultipleChoice implements Respuesta {
    private ArrayList<Opcion> opciones = new ArrayList<Opcion>();


    public RespuestaMultipleChoice(){

    }
    public void agregarOpciones(Opcion ... opciones){
        for (Opcion op : opciones){
            this.opciones.add(op);
        }
    }

    public void evaluar(Puntaje unPuntaje){
        for(Opcion opcion : opciones){
            opcion.evaluar(unPuntaje);
        }
    }
}
