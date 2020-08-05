package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionConOrden;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

import java.util.ArrayList;

public class RespuestaOrderChoice implements Respuesta {
    private ArrayList<OpcionConOrden> opciones = new ArrayList<OpcionConOrden>();

    public void agregarOpcion(OpcionConOrden unaOpcion){
        OpcionConOrden opcion = unaOpcion.duplicar();
        opcion.seleccionarOrden(opciones.size() + 1);
        opciones.add(opcion);
    }

    public void evaluar(Puntaje unPuntaje){
        for(Opcion opcion : opciones){
            opcion.evaluar(unPuntaje);
        }
    }
}
