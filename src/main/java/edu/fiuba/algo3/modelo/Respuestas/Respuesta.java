package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public interface Respuesta {

    void evaluar(Puntaje unPuntaje);

    void agregarOpciones(Opcion ... opciones);
}
