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
    public void evaluarJugadores(Jugador jugador1, Jugador jugador2) {

        Puntaje puntaje1 = puntaje.duplicar();
        Puntaje puntaje2 = puntaje.duplicar();

        puntaje1.calcularPuntaje(jugador1, totalCorrectas);
        puntaje2.calcularPuntaje(jugador2, totalCorrectas);

        jugador1.aplicarExclusividad(puntaje1, puntaje2);
        jugador2.aplicarExclusividad(puntaje2, puntaje1);

        puntaje1.asignarPuntaje(jugador1);
        puntaje2.asignarPuntaje(jugador2);
    }
}
