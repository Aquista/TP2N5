package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntajes.*;

import java.util.ArrayList;

public class PreguntaVF extends PreguntaClasica {
    public PreguntaVF(String texto, Puntaje puntaje){
        super(texto, puntaje);
    }

    @Override
    public void evaluarJugadores(Jugador jugador1, Jugador jugador2) {
        Puntaje puntaje1 = puntaje.duplicar();
        puntaje1.calcularPuntaje(jugador1, this.totalCorrectas);

        Puntaje puntaje2 = puntaje.duplicar();
        puntaje2.calcularPuntaje(jugador2, this.totalCorrectas);

        puntaje1.asignarPuntaje(jugador1);
        puntaje2.asignarPuntaje(jugador2);
    }
}
