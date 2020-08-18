package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionNula;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class RespuestaVF implements Respuesta {
    private Opcion seleccionada = new OpcionNula();

    public RespuestaVF(){}

    public void evaluar(Puntaje unPuntaje){
        this.seleccionada.evaluar(unPuntaje);
    }

    public void agregarOpciones(Opcion... opciones) {
        if(opciones != null)
            this.seleccionada = opciones[0];
    }
}