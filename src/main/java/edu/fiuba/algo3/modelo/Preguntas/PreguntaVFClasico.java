package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;

import java.util.ArrayList;

public class PreguntaVFClasico extends Pregunta {
    public PreguntaVFClasico(String texto){
        super(texto);
    }

    @Override
    public void evaluarJugadores(ArrayList<Jugador> jugadores) {
        for(Jugador jugador : jugadores) {
            PuntajeClasico puntajeJugador = new PuntajeClasico();
            puntajeJugador.calcularPuntaje(jugador, this.totalCorrectas);
        }
    }
    public void evaluarJugadores(ArrayList<Jugador> jugadores, PuntajeClasico puntaje) {
        for(Jugador jugador : jugadores) {
            PuntajeClasico puntajeJugador = puntaje.duplicar();
            puntajeJugador.calcularPuntaje(jugador, this.totalCorrectas);
        }
    }
    
}
