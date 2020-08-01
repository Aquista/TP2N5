package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import java.util.ArrayList;

public class PreguntaMultipleChoice extends Pregunta {
    
    public PreguntaMultipleChoice(String texto, Puntaje unPuntaje) {
        super(texto,unPuntaje);
    }

    public void evaluarJugador(Jugador jugador ,Opcion ... elegidas) {
        Puntaje puntajeJugador = this.puntaje.nuevoPuntaje();
        for (Opcion unaOpcion:elegidas){
            unaOpcion.evaluar(puntajeJugador);
        }
        puntajeJugador.calcularPuntaje(jugador,this.totalCorrectas);
    }
    
}
