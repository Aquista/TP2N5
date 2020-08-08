package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaMultipleChoice;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

import java.util.ArrayList;

public class RespuestaMultipleChoice implements Respuesta {
    private ArrayList<Opcion> opciones = new ArrayList<Opcion>();

    public RespuestaMultipleChoice(Opcion ... opciones) {
        for (Opcion op : opciones){
            this.opciones.add(op);
        }
    }
    public void agregarOpcion(Opcion unaOpcion){
        opciones.add(unaOpcion);
    }

    public void evaluar(Puntaje unPuntaje){
        for(Opcion opcion : opciones){
            opcion.evaluar(unPuntaje);
        }
    }
}
