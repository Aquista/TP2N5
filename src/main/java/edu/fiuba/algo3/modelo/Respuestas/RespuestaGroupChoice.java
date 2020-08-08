package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionConGrupo;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class RespuestaGroupChoice implements Respuesta {
    private ArrayList<Opcion> opciones = new ArrayList<Opcion>();

    public RespuestaGroupChoice(Opcion ... opciones) {
        for (Opcion opcion : opciones){
            this.opciones.add(opcion);
        }
    }

    public void agregarOpcion(OpcionConGrupo unaOpcion, int grupo){
        OpcionConGrupo opcion = unaOpcion.duplicar(/*grupo*/);
        opcion.seleccionarGrupo(grupo);
        opciones.add(opcion);
    }

    public void evaluar(Puntaje unPuntaje){
        for(Opcion opcion : opciones){
            opcion.evaluar(unPuntaje);
        }
    }
}
