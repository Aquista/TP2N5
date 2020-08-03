package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

import java.util.ArrayList;

public class RespuestaMultipleChoice extends Respuesta {
    private ArrayList<Opcion> opciones = new ArrayList<Opcion>();

    public RespuestaMultipleChoice(Opcion ... elegidas) {

        for(Opcion unaOpcion : elegidas){
            agregarOpcion(unaOpcion);
        }
    }

    @Override
    public void agregarOpcion(Opcion unaOpcion){
        opciones.add(unaOpcion);
    }

    @Override
    public void evaluar(Puntaje unPuntaje){
        for(Opcion opcion : opciones){
            opcion.evaluar(unPuntaje);
        }
    }


}
