package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionNula;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class RespuestaVF implements Respuesta {
    private Opcion opcionSeleccionada = new OpcionNula();
    
    public void evaluar(Puntaje unPuntaje){
        this.opcionSeleccionada.evaluar(unPuntaje);
    }

    public void agregarOpciones(Opcion... opciones) {
        if(opciones != null)
            this.opcionSeleccionada = opciones[0];
    }
}