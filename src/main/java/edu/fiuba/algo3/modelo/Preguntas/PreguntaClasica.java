package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Opciones.*;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public abstract class PreguntaClasica extends Pregunta {

    protected int totalCorrectas = 0;

    public PreguntaClasica(String texto, Puntaje puntaje){
        super(texto, puntaje);
    }

    public void agregarOpcionCorrecta(OpcionCorrecta opcionCorrecta){
        opciones.add(opcionCorrecta);
        totalCorrectas++;
    }

    public void agregarOpcionIncorrecta(OpcionIncorrecta opcionIncorrecta){
        opciones.add(opcionIncorrecta);
    }
}
