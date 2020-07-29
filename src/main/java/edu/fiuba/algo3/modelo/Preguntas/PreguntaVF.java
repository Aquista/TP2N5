package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;

import java.util.ArrayList;

public class PreguntaVF extends Pregunta {

    @Override
    public void evaluarJugadores(ArrayList<Jugador> jugadores) {
        for(Jugador jugador : jugadores) {
            PuntajeClasico unPuntaje = new PuntajeClasico();
            unPuntaje.calcularPuntaje(jugador);
        }
    }
    
}
