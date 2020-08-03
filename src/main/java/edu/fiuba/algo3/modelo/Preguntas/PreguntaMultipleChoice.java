package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import java.util.ArrayList;

public class PreguntaMultipleChoice extends PreguntaClasica {

    public PreguntaMultipleChoice(String texto, Puntaje puntaje) {
        super(texto, puntaje);
    }

    @Override
    public void evaluarJugadores(ArrayList<Jugador> jugadores) {
        for(Jugador jugador : jugadores) {
            Puntaje puntajeJugador = puntaje.duplicar();
            puntajeJugador.calcularPuntaje(jugador, totalCorrectas);
        }
    }
}
