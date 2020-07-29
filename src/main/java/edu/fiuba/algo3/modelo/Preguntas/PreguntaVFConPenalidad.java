package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeConPenalidad;

import java.util.ArrayList;

public class PreguntaVFConPenalidad extends Pregunta {

    public PreguntaVFConPenalidad(String texto){
        super(texto);
    }

    @Override
    public void evaluarJugadores(ArrayList<Jugador> jugadores) {
        for(Jugador jugador : jugadores) {
            PuntajeConPenalidad unPuntaje = new PuntajeConPenalidad();
            unPuntaje.calcularPuntaje(jugador);
        }
    }
    
}
