package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionConGrupo;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

import java.util.ArrayList;

public class RespuestaGroupChoice implements Respuesta {
    private ArrayList<OpcionConGrupo> opciones = new ArrayList<OpcionConGrupo>();

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
