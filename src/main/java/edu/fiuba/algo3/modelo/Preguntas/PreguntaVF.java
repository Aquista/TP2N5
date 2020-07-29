package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;

import java.util.ArrayList;

public class PreguntaVF extends Pregunta {
    private final int cantidadPreguntasCorrectas = 1;
    @Override
    public void evaluarJugadores(ArrayList<Jugador> jugadores) {
        for(Jugador jugador : jugadores) {
            PuntajeClasico puntajeJugador = new PuntajeClasico();
            puntajeJugador.calcularPuntaje(jugador, cantidadPreguntasCorrectas);
        }
    }
    
}
