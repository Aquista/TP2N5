package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntajes.*;

import java.util.ArrayList;

public class PreguntaVF extends PreguntaClasica {
    public PreguntaVF(String texto, Puntaje puntaje){
        super(texto, puntaje);
    }

    @Override
    public void evaluarJugadores(ArrayList<Jugador> jugadores) {
        for(Jugador jugador : jugadores) {
            Puntaje puntajeJugador = puntaje.duplicar();
            puntajeJugador.calcularPuntaje(jugador, this.totalCorrectas);
        }
    }
}
